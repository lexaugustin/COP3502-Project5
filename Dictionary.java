//Name: Alexander Augustin
//
//Section: 165B
//Project Number: 5
//Brief description of file contents: Auto Grader

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

	private ArrayList<String> dictionary = new ArrayList<>();

	String dictionaryFile;
	public int getVocabularySize(){
		return dictionary.size();
	}

	public boolean loadDictionaryFromFile(String filePath){
		File dictionaryFile = new File(filePath);

		try{
			Scanner input = new Scanner (dictionaryFile);
			while (input.hasNext()){
				String newWord = input.next().toLowerCase();
				dictionary.add(newWord);
			}
		}
		catch (FileNotFoundException ex){
		}

		if (dictionaryFile.exists()){
			return true;
		}
		else return false;

	}


	public boolean isWord(String word){

		String theWord = word.toLowerCase();
		String theWordWithNoPunctuation = theWord.replaceAll("[?!+.^:,]","");

		if(!dictionary.contains(theWordWithNoPunctuation)){
			return false;
		}
		else
			return true;

	}
}
