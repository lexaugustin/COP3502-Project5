//Name: Alexander Augustin
// 
//Section: 165B
//Project Number: 5
//Brief description of file contents: Auto Grader

import java.io.File;
import java.util.*;
import java.io.*;

public class GraduateStudent extends Student{


	private String major;
	private String advisor;


	public GraduateStudent(String name, String id, String essay, ArrayList<String> errorList, String major, String advisor){

		super (name, id, major, errorList);

		this.major = major;
		this.advisor = advisor;
	}

	public String getMajor(){
		return major;
	}

	public void setMajor(String major){
		this.major = major;
	}

	public String getAdvisor(){
		return advisor;
	}

	public void setAdvisor(String advisor){
		this.advisor = advisor;
	}

	public void writeToFile(){

		try {
			File dictionaryFile = new File (getId() + "_graded.txt");

			//			if (!dictionaryFile.exists()){
			//				dictionaryFile.createNewFile();
			//			}

			PrintWriter graduateStudentInfo = new PrintWriter(dictionaryFile);
			graduateStudentInfo.println("Graduate Student " + getName());
			graduateStudentInfo.println("Student ID: " + getId());
			graduateStudentInfo.println("Major: " + getMajor());
			graduateStudentInfo.println("Advisor: " + getAdvisor());
			graduateStudentInfo.println(getPrintableErrorList());

			graduateStudentInfo.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}


	}

}
