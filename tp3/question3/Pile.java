package question3;
import question1.PilePleineException;
import question1.PileVideException;

/**
 * Write a description of class Pile here.
 *
 * @author Jalal Hassane
 * @version 26/3/2019
 */
public class Pile<T> implements PileI<T>
{
    // instance variables - replace the example below with your own
    private int CAPACITE_PAR_DEFAUT = PileI.CAPACITE_PAR_DEFAUT;
    private Object[] zone;
    private int ptr;

    /**
     * Constructor for objects of class Pile
     */
    public Pile(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public T depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return (T)zone[ptr];
    }

    public T sommet() throws PileVideException {
        if(!estVide())
        return (T)zone[taille()-1];
        else throw new PileVideException();
    }

    public int capacite() {
        return zone.length;
    }

    public int taille() {
        if(estPleine())
            return capacite();
        if(estVide())
            return 0;
        return ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        if (o instanceof Pile) {
            Pile pileAComparer = (Pile) o;
            if(pileAComparer.capacite() != capacite())return false;
            if(pileAComparer.taille() != taille())return false;
            for(int i = 0; i<taille();i++ ){
                if(!pileAComparer.zone[i].equals(this.zone[i]))return false;
            }
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
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
