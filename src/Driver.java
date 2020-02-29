import es.uned.master.java.basico.*;
import es.uned.master.java.coleccion.*;

public class Driver {
    public static void main(String[] arg) {
        Kwic kwic = new Kwic();
        String noKeys = "el la los las un una unos unas y o a ante bajo cabe con contra de desde en entre hacia hasta para por según sin sobre tras si no";
        String[] phrases = {
                "El color del dinero",
                "Color púrpura",
                "Misión: imposible",
                "La misión",
                "La rosa púrpura del Cairo",
                "El dinero llama al dinero",
                "La rosa del azafrán",
                "El nombre de la rosa",
                "Toma el dinero y corre"
        };

        kwic.computaNoClaves(noKeys);

        for (int i = 0; i < phrases.length; i++) {
            kwic.computaIndice(phrases[i]);
        }

        System.out.println("Kwic:" + kwic.print());
    }
}
