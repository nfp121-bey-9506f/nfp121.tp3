package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author Jalal Hassane
 * @version 26/3/2019
 */
public class Pile3 implements PileI {
    private int CAPACITE_PAR_DEFAUT = PileI.CAPACITE_PAR_DEFAUT;
    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.v= new Vector(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        boolean added = this.v.add(o);
        if(!added)
            throw new PilePleineException();
    }

    public Object depiler() throws PileVideException {
        if(!estVide()){
             Object obj = sommet();
             this.v.remove(obj);
             return obj;
            }
        else throw new PileVideException();
    }

    public Object sommet() throws PileVideException {
        if(!estVide())
            return this.v.get(taille()-1);
        else throw new PileVideException();
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
        return v.capacity();
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return taille()==capacite();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = taille()-1; i >= 0; i--) {
            if(this.v.get(i)==null) sb.append("null");
            else sb.append(this.v.get(i).toString());
            if(i!=0)sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if(o instanceof Pile3){
            Pile3 pileAComparer = (Pile3) o;
            if(pileAComparer.capacite() != capacite())return false;
            if(pileAComparer.taille() != taille())return false;
            for(int i = 1; i<=taille();i++ ){
                if(!pileAComparer.v.get(i).equals(this.v.get(i)))return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return toString().hashCode();
    }

}
