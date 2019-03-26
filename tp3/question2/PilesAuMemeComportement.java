package question2;

public class PilesAuMemeComportement extends junit.framework.TestCase {

    private question2.PileI p1;
    private question2.PileI p2;
    private question2.PileI p3;
    private question2.PileI p4;

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        p1 = new question2.Pile(PileI.CAPACITE_PAR_DEFAUT);
        p2 = new question2.Pile2(PileI.CAPACITE_PAR_DEFAUT);
        p3 = new question2.Pile3(PileI.CAPACITE_PAR_DEFAUT);
        p4 = new question2.Pile4(PileI.CAPACITE_PAR_DEFAUT);
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }

    public void test_Sommaire()  throws Exception {

        p4.empiler("b");p4.empiler("a");
        p3.empiler("b");p3.empiler("a");
        p2.empiler("b");p2.empiler("a");
        p1.empiler("b");p1.empiler("a");

        assertEquals(p1.capacite(), p2.capacite());
        assertEquals(p2.capacite(), p3.capacite());
        assertEquals(p3.capacite(), p4.capacite());

        assertEquals("[a,b]", p1.toString());
        assertEquals(p1.toString(), p2.toString());
        assertEquals(p2.toString(), p3.toString());
        assertEquals(p3.toString(), p4.toString());

        assertEquals(p1.sommet(), p2.sommet());
        assertEquals(p2.sommet(), p3.sommet());
        assertEquals(p3.sommet(), p4.sommet());

        String s = (String) p1.depiler();
        assertEquals(s, (String) p2.depiler());
        assertEquals(s, (String) p3.depiler());
        assertEquals(s, (String) p4.depiler());

    }

    public void test_meme_comportement() throws Exception { 
        p4.empiler("aze");
        p3.empiler("aze");
        p2.empiler("aze");
        p1.empiler("aze");

        assertEquals("p1.capacité() == p2.capacité() ??",p1.capacite(), p2.capacite());
        assertEquals("p2.capacite() == p3.capacite() ??",p2.capacite(), p3.capacite());
        assertEquals("p3.capacite() == p4.capacite() ??",p3.capacite(), p4.capacite());

        assertEquals("[aze]", p1.toString());
        assertEquals("p1.toString() != p2.toString() ?? ", p1.toString(), p2.toString());
        assertEquals("p2.toString()!= p3.toString() ?? ",p2.toString(), p3.toString());
        assertEquals("p3.toString()!= p4.toString() ?? ", p3.toString(), p4.toString());

        assertEquals("p1.sommet() != p2.sommet() ??? ", p1.sommet(), p2.sommet());
        assertEquals("p2.sommet() != p3.sommet() ??? ", p2.sommet(), p3.sommet());
        assertEquals("p1.estVide() != p2.estVide() ??? ",p1.estVide(), p2.estVide());
        assertEquals("p2.estVide()!= p3.estVide() ??? ", p2.estVide(), p3.estVide());
        assertEquals("p1.estPleine() != p2.estPleine() ??? ",p1.estPleine(), p2.estPleine());
        assertEquals("p2.estPleine()!=  p3.estPleine() ??? ",p2.estPleine(), p3.estPleine());

        String s = (String) p1.depiler();
        assertEquals(" différence après avoir dépilé ?? ", s, (String) p2.depiler());
        assertEquals(" différence après avoir dépilé ?? ",s, (String) p3.depiler());
        assertEquals(" différence après avoir dépilé ?? ",s, (String) p4.depiler());

        assertEquals("p1.estVide() != p2.estVide() ??? ",p1.estVide(), p2.estVide());
        assertEquals("p2.estVide()!= p3.estVide() ??? ", p2.estVide(), p3.estVide());
        assertEquals("p1.estPleine() != p2.estPleine() ??? ",p1.estPleine(), p2.estPleine());
        assertEquals("p2.estPleine()!=  p3.estPleine() ??? ",p2.estPleine(), p3.estPleine());

        assertEquals(" différence sur la taille() ?? ",p1.taille(), p2.taille());
        assertEquals(" différence sur la taille() ?? ",p2.taille(), p3.taille());
        assertEquals(" différence sur la taille() ?? ",p3.taille(), p4.taille());

        p4.empiler("azerty");
        p3.empiler("azerty");
        p2.empiler("azerty");
        p1.empiler("azerty");

        assertEquals("p1.sommet() != p2.sommet() ??? ", p1.sommet(), p2.sommet());
        assertEquals("p2.sommet() != p3.sommet() ??? ", p2.sommet(), p3.sommet());
        assertEquals("p1.estVide() != p2.estVide() ??? ",p1.estVide(), p2.estVide());
        assertEquals("p2.estVide()!= p3.estVide() ??? ", p2.estVide(), p3.estVide());
        assertEquals("p1.estPleine() != p2.estPleine() ??? ",p1.estPleine(), p2.estPleine());
        assertEquals("p2.estPleine()!=  p3.estPleine() ??? ",p2.estPleine(), p3.estPleine());
        assertEquals(" différence sur la taille() ?? ",p1.taille(), p2.taille());
        assertEquals(" différence sur la taille() ?? ",p2.taille(), p3.taille());
        assertEquals(" différence  sur la taille() ?? ",p3.taille(), p4.taille());

        p4.empiler("azer");
        p3.empiler("azer");
        p2.empiler("azer");
        p1.empiler("azer");

        assertEquals("p1.toString() != p2.toString() ?? ", p1.toString(), p2.toString());
        assertEquals("p2.toString() != p3.toString() ?? ",p2.toString(), p3.toString());
        assertEquals("p3.toString() != p4.toString() ?? ", p3.toString(), p4.toString());

        assertEquals("p1.sommet() != p2.sommet() ??? ", p1.sommet(), p2.sommet());
        assertEquals("p2.sommet() != p3.sommet() ??? ", p2.sommet(), p3.sommet());

        assertEquals("p1.estVide() != p2.estVide() ??? ",p1.estVide(), p2.estVide());
        assertEquals("p2.estVide()!= p3.estVide() ??? ", p2.estVide(), p3.estVide());
        assertEquals("p1.estPleine() != p2.estPleine() ??? ",p1.estPleine(), p2.estPleine());
        assertEquals("p2.estPleine()!=  p3.estPleine() ??? ",p2.estPleine(), p3.estPleine());

        assertEquals(" différence sur la taille() ?? ",p1.taille(), p2.taille());
        assertEquals(" différence sur la taille() ?? ",p2.taille(), p3.taille());
        assertEquals(" différence  sur la taille() ?? ",p3.taille(), p4.taille());

        p4.empiler("azer");
        p3.empiler("azer");
        p2.empiler("azer");
        p1.empiler("azer");

        assertEquals("p1.toString() != p2.toString() ?? ", p1.toString(), p2.toString());
        assertEquals("p2.toString() != p3.toString() ?? ",p2.toString(), p3.toString());
        assertEquals("p3.toString() != p4.toString() ?? ", p3.toString(), p4.toString());

        assertEquals("p1.sommet() != p2.sommet() ??? ", p1.sommet(), p2.sommet());
        assertEquals("p2.sommet() != p3.sommet() ??? ", p2.sommet(), p3.sommet());

        assertEquals("p1.estVide() != p2.estVide() ??? ",p1.estVide(), p2.estVide());
        assertEquals("p2.estVide()!= p3.estVide() ??? ", p2.estVide(), p3.estVide());
        assertEquals("p1.estPleine() != p2.estPleine() ??? ",p1.estPleine(), p2.estPleine());
        assertEquals("p2.estPleine()!=  p3.estPleine() ??? ",p2.estPleine(), p3.estPleine());

        assertEquals(" différence sur la taille() ?? ",p1.taille(), p2.taille());
        assertEquals(" différence sur la taille() ?? ",p2.taille(), p3.taille());
        assertEquals(" différence  sur la taille() ?? ",p3.taille(), p4.taille());

        p4.depiler();
        p3.depiler();
        p2.depiler();
        p1.depiler();

        assertEquals("p1.toString() != p2.toString() ?? ", p1.toString(), p2.toString());
        assertEquals("p2.toString() != p3.toString() ?? ",p2.toString(), p3.toString());
        assertEquals("p3.toString() != p4.toString() ?? ", p3.toString(), p4.toString());

        assertEquals("p1.sommet() != p2.sommet() ??? ", p1.sommet(), p2.sommet());
        assertEquals("p2.sommet() != p3.sommet() ??? ", p2.sommet(), p3.sommet());

        assertEquals("p1.estVide() != p2.estVide() ??? ",p1.estVide(), p2.estVide());
        assertEquals("p2.estVide()!= p3.estVide() ??? ", p2.estVide(), p3.estVide());
        assertEquals("p1.estPleine() != p2.estPleine() ??? ",p1.estPleine(), p2.estPleine());
        assertEquals("p2.estPleine()!=  p3.estPleine() ??? ",p2.estPleine(), p3.estPleine());

        assertEquals(" différence sur la taille() ?? ",p1.taille(), p2.taille());
        assertEquals(" différence sur la taille() ?? ",p2.taille(), p3.taille());
        assertEquals(" différence  sur la taille() ?? ",p3.taille(), p4.taille());

    }
    public void test_meme_comportement_2()throws Exception{
        p1.empiler("1");p1.empiler("2");p1.empiler("3");p1.empiler("4");p1.empiler("Ordre decroissant de 4 a 1");
        p2.empiler("4");p2.empiler("3");p2.empiler("2");p2.empiler("1");p2.empiler("Ordre croissant de 1 a 4");
        p3.empiler("a");p3.empiler("b");p3.empiler("c");p3.empiler("d");p3.empiler("dcba");
        p4.empiler("d");p4.empiler("c");p4.empiler("b");p4.empiler("a");p4.empiler("abcd");
        assertTrue(p1.toString().equals("[Ordre decroissant de 4 a 1,4,3,2,1]"));
        assertTrue(p2.toString().equals("[Ordre croissant de 1 a 4,1,2,3,4]"));
        assertTrue(p3.toString().equals("[dcba,d,c,b,a]"));
        assertTrue(p4.toString().equals("[abcd,a,b,c,d]"));
        p1.empiler("la pile est pleine");
        assertTrue("Pile pleine?",p1.estPleine());
        assertTrue(p3.sommet().equals("dcba"));
        assertTrue(p4.sommet().equals("abcd"));
        for(int i =1;i<=5;i++)
            p2.depiler();
        assertTrue("La pile p2 est vide maintenant?",p2.estVide());
    }
}

