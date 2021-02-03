import es.uned.master.java.basico.*;
import es.uned.master.java.coleccion.*;
import es.uned.master.java.resources.LoadData;
/**
 * Main class. In this class load the parameters from files and tell the methods init the program
 */
public class Driver {
    public static void main(String[] arg) throws Exception {

        Kwic kwic = new Kwic();
        LoadData loadData = new LoadData();
        String noKeys= loadData.loadNoKeys();
        loadData.stringSum("//#/1#1,1");
        String[] phrases= loadData.loadFilms();

        kwic.computaNoClaves(noKeys);

        for (int i = 0; i < phrases.length; i++) {
            kwic.computaIndice(phrases[i]);
        }

        System.out.println("Kwic:" + kwic.print());
    }
}
