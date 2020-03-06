package es.uned.master.java.resources;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to load keys and index from file
 */
public class LoadData {

    /**
     *  Read list of no importart words and load in the string noKeys
      * @return
     * @throws Exception
     */
    public String loadNoKeys() throws Exception{
        InputStream inputStream = new FileInputStream("src/es/uned/master/java/resources/nokeys.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String nokeys = bufferedReader.readLine();
        return nokeys;
    }

    /**
     *  Read list of films and load in array.
     * @return
     * @throws Exception
     */
    public String[] loadFilms() throws Exception{
        InputStream inputStream = new FileInputStream("src/es/uned/master/java/resources/films.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        List<String> filmsList = new ArrayList<String>();
        filmsList.add(line);
        StringBuilder stringBuilder = new StringBuilder();
        while(line != null){
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
            if (line != null)
                filmsList.add(line);
        }
        String [] films = filmsList.toArray(new String[0]);
        return films;
    }


}
