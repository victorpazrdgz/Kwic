package es.uned.master.java.resources;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadData {

    public String loadNoKeys() throws Exception{
        InputStream inputStream = new FileInputStream("src/es/uned/master/java/resources/nokeys.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String nokeys = bufferedReader.readLine();
        return nokeys;
    }

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
