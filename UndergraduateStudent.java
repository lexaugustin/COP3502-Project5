//Name: Alexander Augustin 
//2196 - 9085 
//Section: 165B
//Project Number: 5
//Brief description of file contents: Auto Grader

import java.io.*;
import java.util.*;

public class UndergraduateStudent extends Student {

	private String major;

	public UndergraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major){

		super (name, id, major, errorList);

		this.major = major;

	}

	public String getMajor(){
		return major;
	}

	public void setMajor(String major){
		this.major = major;
	}

	public void writeToFile(){

		try {
			File dictionaryFile = new File (getId() + "_graded.txt");

			//			if (!dictionaryFile.exists()){
			//				dictionaryFile.createNewFile();
			//			} 

			PrintWriter undergraduateStudentInfo = new PrintWriter(dictionaryFile);
			undergraduateStudentInfo.println("Undergraduate Student " + getName());
			undergraduateStudentInfo.println("Student ID: " + getId());
			undergraduateStudentInfo.println("Major: " + getMajor());
			undergraduateStudentInfo.println(getPrintableErrorList());

			undergraduateStudentInfo.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}


}
