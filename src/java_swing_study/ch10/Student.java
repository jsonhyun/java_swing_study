package java_swing_study.ch10;

import javax.swing.JTextField;

public class Student {
	private String name;
	private int stdNo;
	private String dept;
	private String subj;
	

	public Student(String name, int stdNo, String dept, String subj) {
		this.name = name;
		this.stdNo = stdNo;
		this.dept = dept;
		this.subj = subj;
	}

	public String getName() {
		return name;
	}

	public int getStdNo() {
		return stdNo;
	}

	public String getDept() {
		return dept;
	}

	public String getSubj() {
		return subj;
	}

	@Override
	public String toString() {
		return String.format("학생이름 : %s, 학생번호 : %s, 학과명 : %s, 과목 : %s", name, stdNo, dept, subj);
	}
	
	
	
	
	
}
