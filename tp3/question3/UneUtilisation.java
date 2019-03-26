package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        Pile p1 = new Pile<PolygoneRegulier>();
        Pile2 p2 = new Pile2<Pile>();

        // p1 est ici une pile de polygones réguliers PolygoneRegulier.java
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));

        System.out.println(" la pile p1 = " + p1);

        p2.empiler(p1);
        System.out.println(" la pile p2 = " + p2);

        try {
             p1.empiler(new PolygoneRegulier(5,100));
             String s = (String)p1.depiler();
             // pas de fautes lors de la compilation mais en runtime, l'exception levee est une exception de cast car
             // polygoneRegulier ne peut pas etre un string
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}