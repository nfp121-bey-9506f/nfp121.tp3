package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author Jalal Hassane    
 * @version 23/3/2019
 */
public class Pile implements PileI {
    private int CAPACITE_PAR_DEFAUT = PileI.CAPACITE_PAR_DEFAUT; 
    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        // a completer
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(!estVide())
        return zone[taille()-1];
        else throw new PileVideException();
    }

    public int capacite() {
        // a completer
        return zone.length;
    }

    public int taille() {
        // a completer
        if(estPleine())
            return capacite();
        if(estVide())
            return 0;
        return capacite()-ptr;
    }

    public boolean estVide() {
        // a completer
        return ptr == 0;
    }

    public boolean estPleine() {
        // a completer
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        // a completer
        Pile pileAComparer = (Pile) o;
        if(pileAComparer.capacite() != capacite())
            return false;
        if(pileAComparer.taille() != taille())
            return false;
        for(int i = 0; i<taille();i++ ){
            if(!pileAComparer.zone[i].equals(this.zone[i]))
                return false;
        }
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}