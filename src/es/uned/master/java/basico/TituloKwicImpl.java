package es.uned.master.java.basico;
import java.util.*;

public class TituloKwicImpl implements Comparable<TituloKwicImpl>,TituloKwic{
	private String tk;

	public TituloKwicImpl(String str){
		this.tk= str.toUpperCase();
	}
	public boolean equals(Object o){
		if (o instanceof TituloKwicImpl){
			TituloKwicImpl tk= (TituloKwicImpl) o;
			return this.tk.equals(tk.toString());
		}else{
			throw new KwicException("No es un TituloKwicImpl");
		}
	}
//	public int hasCode(){
//		return this.tk.hashCode();
//	}
	public int compareTo(TituloKwicImpl tk){
		return this.tk.compareToIgnoreCase(tk.toString());
	}
	public String toString(){
		return this.tk;
	}

	//Este metodo introduce una frase y un patrón y cambia el patron por los caracteres '...'

	public String replace(String frase){
		StringTokenizer strk= new StringTokenizer(frase," ,");
		String resultado="";
		while (strk.hasMoreTokens()){
			String palabraAComparar= strk.nextToken();
			TituloKwicImpl tk= new TituloKwicImpl(palabraAComparar);
			if (this.tk.equals(tk.toString())){
				resultado += "... ";
			}else{
				resultado += palabraAComparar+" ";
			}
		}
		return resultado;
	}


}