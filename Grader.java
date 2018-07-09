//Name: Alexander Augustin
// 
//Section: 165B
//Project Number: 5
//Brief description of file contents: Auto Grader

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grader {

	private boolean available;
	private Student student;
	private Dictionary dict;

	private ArrayList<String> errorList;


	public Grader(Dictionary dict){
		available = true;
		this.dict = dict;
	}

	public boolean gradeStudent(String fileName){

		File studentEssay = new File (fileName + ".txt");
		Scanner input;

		try{
			errorList = new ArrayList<String>();
			input = new Scanner(studentEssay);
		}
		catch(FileNotFoundException ex){
			return false;
		}

		String name;
		String nameOfSchool = null;
		String id;

		// Read the first line of the essay.
		String studentTitle = input.nextLine();
		name = input.nextLine();
		id = input.nextLine();
		String essay = null;


		if (studentTitle.equalsIgnoreCase("HighSchool Student")){
			nameOfSchool = input.nextLine();
		}

		String major = null;
		if (studentTitle.equalsIgnoreCase("Undergraduate Student")){
			major = input.nextLine();
		}

		String advisor = null;
		if (studentTitle.equalsIgnoreCase("Graduate Student")){
			major = input.nextLine();
			advisor = input.nextLine();
		}


		while(input.hasNextLine()){
			essay = input.nextLine();
		}


		String [] arr = essay.split("\\s+");
		for (int i = 0; i < arr.length; i++){

			String essayWord = arr[i].toLowerCase(); //.trim();
			if (dict.isWord(essayWord) == false){
				errorList.add(essayWord.toLowerCase().replaceAll("[?!+.^:,]",""));
			}
		}

		if (studentTitle.equalsIgnoreCase("HighSchool Student")){
			student = new HighSchoolStudent(name, id, essay, errorList, nameOfSchool);
		}

		if (studentTitle.equalsIgnoreCase("Undergraduate Student")){
			student = new UndergraduateStudent(name, id, essay.toString(), errorList, major);
		}

		if (studentTitle.equalsIgnoreCase("Graduate Student")){
			student = new GraduateStudent(name, id, essay.toString(), errorList, major, advisor);
		}

		available = false;
		return true;
	}


	public boolean isAvailable(){
		if (student == null && available == true)
			return true;
		else
			return false;
	}

	public Student getStudent(){
		return student;
	}

	public void reset(){
		student = null;
		available = true;
	}
}
