package es.uned.master.java.basico;
import java.util.*;

/**
 *
 */
public class TituloKwicImpl implements Comparable<TituloKwicImpl>,TituloKwic{

	private String characterChain;

	/**
	 *
	 * @param characters
	 * @throws Exception
	 */
	public TituloKwicImpl(String characters) throws Exception{
		this.characterChain= characters.toUpperCase();
	}

	/**
	 *
	 * @param chain
	 * @return
	 */
	public int compareTo(TituloKwicImpl chain) {
		Integer result = null;
		try {
			result = this.characterChain.compareToIgnoreCase(chain.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *  This method return
	 * @return
	 */
	public String toString() {
		return this.characterChain;
	}

	/**
	 * This method introduces a phrase and a pattern and changes the pattern to the characters '...'
	 * @param phrase
	 * @return
	 */
	public String replace(String phrase){
		StringTokenizer evaluate= new StringTokenizer(phrase," ,");
		String result="";
		try {
			if (!evaluate.equals(null) || !evaluate.equals("undefined")){}
			while (evaluate.hasMoreTokens()) {
				String wordToCompare = evaluate.nextToken();
				TituloKwicImpl tk = new TituloKwicImpl(wordToCompare);
				if (this.characterChain.equals(tk.toString())) {
					result += "... ";
				} else {
					result += wordToCompare + " ";
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}


}