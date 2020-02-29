package es.uned.master.java.basico;
import java.util.*;

public class TituloKwicImpl implements Comparable<TituloKwicImpl>,TituloKwic{
	private String tk;

	public TituloKwicImpl(String str){
		this.tk= str.toUpperCase();
	}

	public int compareTo(TituloKwicImpl tk){
		return this.tk.compareToIgnoreCase(tk.toString());
	}
	public String toString(){
		return this.tk;
	}

	//Este metodo introduce una frase y un patrón y cambia el patron por los caracteres '...'

	public String replace(String phrase){
		StringTokenizer evaluate= new StringTokenizer(phrase," ,");
		String resultado="";
		while (evaluate.hasMoreTokens()){
			String wordToCompare= evaluate.nextToken();
			TituloKwicImpl tk= new TituloKwicImpl(wordToCompare);
			if (this.tk.equals(tk.toString())){
				resultado += "... ";
			}else{
				resultado += wordToCompare+" ";
			}
		}
		return resultado;
	}


}