package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author Jalal Hassane
 * @version 23/3/2019
 */
public class Pile3 implements PileI {
    private int CAPACITE_PAR_DEFAUT = PileI.CAPACITE_PAR_DEFAUT;
    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.v= new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter
        boolean added = this.v.add(o);
        if(!added)
            throw new PilePleineException();
    }

    public Object depiler() throws PileVideException {
        // à compléter
        return null;
    }

    public Object sommet() throws PileVideException {
        // à compléter
        if(!estVide())
            return this.v.get(taille());
        else throw new PileVideException();
    }

    public int taille() {
        // à compléter
        return v.size();
    }

    public int capacite() {
        // à compléter
        return v.capacity();
    }

    public boolean estVide() {
        // à compléter
        return v.isEmpty();
    }

    public boolean estPleine() {
        // à compléter
        return v.lastElement().toString().equals(v.get(v.size()));
    }

    public String toString() {
        // à compléter
        StringBuffer sb = new StringBuffer("[");
        for (int i = taille(); i > 0; i--) {
            sb.append(this.v.get(i).toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object o) {
        // à compléter
        Pile3 pileAComparer = (Pile3) o;
        if(pileAComparer.capacite() != capacite())
            return false;
        if(pileAComparer.taille() != taille())
            return false;
        for(int i = 1; i<=taille();i++ ){
            if(!pileAComparer.v.get(i).equals(this.v.get(i)))
                return false;
        }
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
