package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille <= 0)
             capacite = PileI.CAPACITE_PAR_DEFAUT;
        else
            capacite = taille;
        this.stk= new Stack();
    }

    public Pile2(){
        this(0);
    }

    public void empiler(T o) throws PilePleineException{
        if(estPleine())
            throw new PilePleineException();
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
        if(estVide())throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        if(estVide())throw new PileVideException();
        return this.stk.peek();    
    }
    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return this.stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return taille()==capacite();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for (int i = taille()-1; i >= 0; i--) {
            s += this.stk.get(i).toString();
            if(i!=0)s += ",";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if(o instanceof Pile2){
            Pile2 pileAComparer = (Pile2) o;
            if(pileAComparer.capacite() != capacite())return false;
            if(pileAComparer.taille() != taille())return false;
            for(int i = 1; i<=taille();i++ ){
                if(!pileAComparer.stk.get(i).equals(this.stk.get(i)))return false;
            }
        }
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return this.stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return capacite;
    }

} // Pile2