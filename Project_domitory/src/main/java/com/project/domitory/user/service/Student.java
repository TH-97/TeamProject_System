package com.project.domitory.user.service;

public class Student {
	private static int nextStudentNo = 1;
	private static int nextPhoneNO= 1090420175;
	private String mj;
	private String fullName;
	private String password;
	private String role;
	private int stud_no;
	private int stud_pn;

	public Student(String mj, String fullName, String password) {
		this.mj = mj;
		this.fullName = fullName;
		this.password = password;
		this.role = "ROLE_STUDENT";
		this.stud_no = nextStudentNo++;
		this.stud_pn = nextPhoneNO++;
	}

	// Getter 메서드
	public String getMj() {
		return mj;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}

	public int getStud_no() {
		return stud_no;
	}

	public int getStud_pn() {
		return stud_pn;
	}
}
