//Name: Alexander Augustin
// 
//Section: 165B
//Project Number: 5
//Brief description of file contents: Auto Grader

import java.io.*;
import java.util.*;

public class HighSchoolStudent extends Student {


	private String nameOfSchool;

	public HighSchoolStudent(String name, String id, String essay, ArrayList<String> errorList, String nameOfSchool){
		super (name, id, nameOfSchool, errorList);


		this.nameOfSchool = nameOfSchool;

	}

	public String getSchoolName(){
		return nameOfSchool;
	}

	public void setSchoolName(String schoolName){
		nameOfSchool = schoolName;
	}

	public void writeToFile(){

		try {
			File dictionaryFile = new File (getId() + "_graded.txt");

			//			if (!dictionaryFile.exists()){
			//				dictionaryFile.createNewFile();
			//			}

			PrintWriter highSchoolStudentInfo = new PrintWriter(dictionaryFile);
			highSchoolStudentInfo.println("High School Student " + getName());
			highSchoolStudentInfo.println("Student ID: " + getId());
			highSchoolStudentInfo.println("School Name: " + getSchoolName());
			highSchoolStudentInfo.println(getPrintableErrorList());

			highSchoolStudentInfo.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


}
