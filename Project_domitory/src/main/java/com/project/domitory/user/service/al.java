package com.project.domitory.user.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class al {

	@Autowired
	@Qualifier("userService")
	UserService userService;

	public static String[] mj = {"전자","기계공학" , "철학과" , "국문과"};

	public static String[] fn = {"김","이","박"};

	public static char[] ln = {'가','나','다','라','마','바','사','아','자'};

	private static Random random = new Random();

	public static Student generateRandomStudent() {
		String major = getRandomElement(mj);
		String fullName = generateRandomName();
		String password = "1234"; // 고정된 비밀번호

		return new Student(major, fullName, password);
	}

	// 랜덤 이름 생성 메서드
	private static String generateRandomName() {
		String lastName = getRandomElement(fn);
		char firstSyllable = getRandomElement(ln);
		char secondSyllable = getRandomElement(ln);

		return lastName + firstSyllable + secondSyllable;
	}

	// 배열에서 랜덤 요소 선택 메서드
	private static <T> T getRandomElement(T[] array) {
		int randomIndex = random.nextInt(array.length);
		return array[randomIndex];
	}

	// 문자 배열에서 랜덤 문자 선택 메서드
	private static char getRandomElement(char[] array) {
		int randomIndex = random.nextInt(array.length);
		return array[randomIndex];
	}

	public static void main(String[] args) {
		al alInstance = new al();
		alInstance.init();

	}
	public void init() {
		Student student = generateRandomStudent();
		userService.dumy(student);
	}
}





