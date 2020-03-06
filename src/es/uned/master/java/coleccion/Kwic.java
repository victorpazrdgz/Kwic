package es.uned.master.java.coleccion;

import java.util.*;

import es.uned.master.java.basico.*;

/**
 * This class contain the methods used for calculate the words of the index.
 * This class has been modified for use the new interface.
 */
public class Kwic {
    private Set<TituloKwic> noclaves;
    private Map<TituloKwic, Set<String>> kwic;

    //Inicializo la estructura
    public Kwic() {
        this.noclaves = new TreeSet();
        this.kwic = new TreeMap();
    }

    /**
     * *Esta párte se tratará exclusivamente las noclaves
     */
    /**
     *
     * @param noclaves
     */
    public void computaNoClaves(String noclaves) throws Exception {
        StringTokenizer strk = new StringTokenizer(noclaves, " ,");

        while (strk.hasMoreTokens()) {
            this.noclaves.add(new TituloKwicImpl(strk.nextToken()));
        }
    }

    /*
     * Esta parte se tratará de kwic usando las noclaves como consulta
     */
    // Tu solo vales para cuando una palabra SEA INDICE
    // Se utiliza con el compunta que recibe un String

    /**
     *
     * @param palabra
     * @param frase
     */
    private void computaIndice(TituloKwic palabra, String frase) throws Exception {
        //Necesariamente se añade al map.
        // Si esta -> Solo añado la frase en el Set
        // Si no está -> Además de la frase el índice
        Set<String> frases = new TreeSet();
        if (this.kwic.containsKey(palabra)) {
            // Que lo contiene
            //Cariño dame ese valor de la palabra
            frases = this.kwic.get(palabra);
        }
        frases.add(palabra.replace(frase));
        //frases.add(TituloKwicImpl.reemplaza(palabra, frase));

        // Añadiro al map como nuevo y machaco el que había.
        this.kwic.put(palabra, frases);

    }


    /**
     * This method recieves the phrase and processes it with Kwic.
     * First extract each word in the sentence and then check if the word is in the unimportant keys,
     * if not add it to the index group.
     * @param phrase
     * @throws Exception
     */
    public void computaIndice(String phrase) throws Exception {

        StringTokenizer characterChain = new StringTokenizer(phrase, " ,");
        while (characterChain.hasMoreTokens()) {
            TituloKwicImpl palabra = new TituloKwicImpl(characterChain.nextToken());
            if (!(this.noclaves.contains(palabra))) {
                this.computaIndice(palabra, phrase);
            }
        }
    }

    /**
     * This method write unimportant words in the console
     * @return
     */
    private String writeNoKeys() {
        String str = "Palabras no claves: \r\n\n";
        Iterator<TituloKwic> it = this.noclaves.iterator();
        while (it.hasNext()) {
            str += it.next().toString() + ", ";
        }
        return str;
    }

    /**
     * Auxiliary method for help to write index
     * @param chain
     * @return
     */
    private String writeKwic(Set<String> chain) {
        String str = "";
        Iterator<String> it = chain.iterator();
        while (it.hasNext()) {
            str += "\t" + it.next() + "\n";
        }
        return str;
    }

    /**
     * Method for write index in the console
     * @return
     */
    private String writeKwic() {
        String str = "\n" + " ***** INDICE ***** \n\n";
        Iterator<Map.Entry<TituloKwic, Set<String>>> it = this.kwic.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<TituloKwic, Set<String>> mp = it.next();
            str += mp.getKey() + "\n";
            str += writeKwic(mp.getValue());
        }
        return str;
    }

    /**
     * Method for print in console
     * @return
     */
    public String print() {
        String text = "";
        text += writeNoKeys()+"\n";
        text += writeKwic();
        return text;
    }
}














