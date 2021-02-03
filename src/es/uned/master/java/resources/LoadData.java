package es.uned.master.java.resources;

import java.io.*;
import java.lang.reflect.Array;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
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
    public int stringSum(String chain){
        int sum = 0;
        final String[] parseNumber = {"0"};
        String pattern="";
        int i=0;
        char separator = getSeparator(chain,i);
        int count=0;
        List <Character> chainConverted = new ArrayList<Character>();
        for (char ch : chain.toCharArray())
            chainConverted.add(ch);
        chainConverted.forEach(e -> System.out.println(e));
        final String[] parNum = {"0"};
        UseLabmda chainAdd = (c,add,j) -> {
            String numbers = "0123456789";
            if (numbers.indexOf(c) >= 0) {
                parNum[0] += c;
            }
            if (c == separator ) {
                add += Integer.parseInt(parNum[0]);
                parNum[0]="0";
            }
            if(j == chainConverted.size()-1)
                add += Integer.parseInt(parNum[0]);
            System.out.println(add);
            return add;
        };


//        CharacterIterator iterator = new StringCharacterIterator(chain) ;
//        for (char n = iterator.first(); n != CharacterIterator.DONE ; n = iterator.next()){}

        while (i<chain.length() ){

            sum = chainAdd.add(chain.charAt(i), sum, i);

//            String  numbers = "0123456789";
//            if (numbers.indexOf(chain.charAt(i)) >= 0){
//                parseNumber[0] += chain.charAt(i);
//            }
//            if (chain.charAt(i)== separator){
//                sum += Integer.parseInt(parseNumber[0]);
//                parseNumber[0] = "0";
//            }
            i++;
        }
//        sum += Integer.parseInt(parseNumber[0]);
        System.out.println(sum);
        return sum;
    }

    private char getSeparator(String chain,int i) {
        char separator = ',';
        if (chain.length() >4) {
            if ((chain.charAt(i) == '/') && (chain.charAt(i+1) == '/') && (chain.charAt(i+3) == '/')) {
                separator = chain.charAt(i+2);
            }
        }
        return separator;
    }
    public interface UseLabmda{
        public int add (char c,int add, int i);

    }

}
