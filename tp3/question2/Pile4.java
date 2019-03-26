package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.capacite = taille;
        this.nombre = 0;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
            if(nombre==0){
                this.stk= new Maillon(o,null);
                
            }else{
            Maillon aAjouter = new Maillon(o,null);
            try{
                Maillon m =(Maillon) this.stk.clone(); 
                aAjouter.suivant = m;
                this.stk=aAjouter;
            }catch(CloneNotSupportedException e){
                System.out.println("Exception");
            }                
            
            }
            this.nombre++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        try{
            this.nombre--;
            Maillon sommet = (Maillon)this.stk.clone();
            
            if(nombre>1){
                this.stk.element= sommet.suivant().element();
                this.stk.suivant = sommet.suivant().suivant();
            }else{
                this.stk.element= sommet.element();
                this.stk.suivant = null;
            }
            
            return sommet.element;
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
        
    }

    public Object sommet() throws PileVideException {
        if (estVide()) throw new PileVideException();
        try{
             Maillon m =(Maillon) this.stk.clone(); 
             return m.element();
        }catch(CloneNotSupportedException e){
             System.out.println("Exception");
        }
        return null;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return nombre==0; 
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return nombre==capacite;
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        String s = "[";
        try{
            Maillon aAfficher= (Maillon)this.stk.clone();
            boolean isNull = aAfficher.suivant == null;
            if(!estVide())s += aAfficher.element();
            if(isNull) return s + "]";
            else s += ",";
            while(aAfficher.suivant!=null){
                s += aAfficher.suivant.element().toString();
                aAfficher.suivant=aAfficher.suivant.suivant();
                if(aAfficher.suivant!=null) s += ",";
                //else s+= ","+this.stk.element().toString();
            }
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if (o instanceof Pile4) {
            Pile4 pileAComparer = (Pile4) o;
            if(pileAComparer.capacite() != capacite())
                return false;
            if(pileAComparer.taille() != taille())
                return false;
            try{
                Maillon check= (Maillon)this.stk.clone();
                while(check.suivant()!=null){
                    if(!pileAComparer.stk.element().equals(check.element()))
                        return false;
                    pileAComparer.stk.suivant=pileAComparer.stk.suivant.suivant();
                    check.suivant=check.suivant.suivant();
                }
            }catch(CloneNotSupportedException e){
            }
        }
        return true;
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}