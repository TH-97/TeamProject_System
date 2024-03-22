package com.project.domitory.test;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.domitory.command.AdminVO;
import com.project.domitory.command.StudentVO;
import com.project.domitory.command.UserVO;
import com.project.domitory.user.service.UserService;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class al{
//	@Mock
//	dummyMapper dummyMapper;
	@Autowired
	dummyMapper dummyMapper;
	
	
//	@InjectMocks
//	al alInstance;

	private static int nextStudentNo = 24033899;
	public static String[] mj = {"전자","기계공학" , "철학과" , "국문과"};

	public static String[] fn = {"김","이","박"};

	public static char[] ln = {'가','나','다','라','마','바','사','아','자'};
	
	public static String[] ad1 = {"서울특별시","경기도"}; 
	public static String[] ad2 = {"종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구", "강동구"};
	public static String[] ad3 = {"수원시 장안구", "수원시 권선구", "수원시 팔달구", "수원시 영통구", "성남시 수정구", "성남시 중원구", "성남시 분당구", "의정부시", "안양시 만안구", "안양시 동안구", "부천시", "광명시", "평택시", "동두천시", "안산시 상록구", "안산시 단원구", "고양시 덕양구", "고양시 일산동구", "고양시 일산서구", "과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시 처인구", "용인시 기흥구", "용인시 수지구", "파주시", "이천시", "안성시", "김포시", "화성시", "광주시", "양주시", "포천시", "여주시", "연천군", "가평군", "양평군"};	
	public static String[] gndr = {"M","F"};
	private static Random random = new Random();

	public static Student generateRandomStudent() {
		String major = getRandomElement(mj);
		String fullName = generateRandomName();
		String password = "1234"; // 고정된 비밀번호
		String stud_ad = generateRandomAd(); 
		float snths_scr = generateRandomscr();
		String gndr_nm = generateRandomgndr();
		int stud_no = nextStudentNo++;

		return new Student(major, fullName, password, stud_ad, snths_scr, gndr_nm ,stud_no);
	}

	//랜덤 학점 생성 메소드
	private static float generateRandomscr() {
		return (float)(Math.random()*4.5*100)/100;
	}
	//랜덤 성별 생성 메소스
	private static String generateRandomgndr() {
		
		return getRandomElement(gndr);
	}
	
	//랜덤 주소 생성 메소드
	private static String generateRandomAd() {
		
		
		String add = getRandomElement(ad1);
		if(add.equals("서울특별시")) {
			String add1 = getRandomElement(ad2);
			return add +" " + add1;
			
		}else if(add.equals("경기도")) {
			String add2 = getRandomElement(ad3);
			return add + " " + add2;
			
		}
		
		return null;		
		
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

	@Test
	public void init() {
		for(int i = 999910920 ; i < 999911040 ; i++) {
			
		Student student = generateRandomStudent();
//		student.setStud_no(nextStudentNo++);
		

		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		String pw =(bc.encode(student.getPassword()));

		StudentVO vo2 = new StudentVO();

		vo2.setUser_nm(student.getFullName());
		System.out.println(student.getFullName());
		vo2.setMj(student.getMj());
		System.out.println(student.getMj());
		vo2.setRole(student.getRole());
		System.out.println(student.getRole());
		vo2.setStud_no(999910955);
		vo2.setStud_pw(pw);
		vo2.setStud_pn(String.valueOf(student.getStud_pn()));
		System.out.println(student.getStud_pn());
		
		vo2.setStud_ad(student.getStud_ad());
		System.out.println(student.getStud_ad());
		
		vo2.setSnths_scr(student.getSnths_scr());
		System.out.println(student.getSnths_scr());
		
		vo2.setGndr_nm(student.getGndr_nm());
		System.out.println(student.getGndr_nm());

		int result = dummyMapper.stud_join(vo2);
		
		System.out.println(result + ":" +vo2);

		UserVO userVO = new UserVO();
		userVO.setUser_id(student.getStud_no());
		userVO.setUser_pw(pw);
		userVO.setRole(student.getRole());
		userVO.setStud_no(student.getStud_no());
		//userVO에도 넣기
		dummyMapper.user_student(userVO);
		
		dumy(student);
		}
	}
	
	public void dumy(Student vo) {
		if(vo.getRole().equals("ROLE_ADMIN")) {
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			String pw =(bc.encode(vo.getPassword()));
			AdminVO vo1 = new AdminVO();
			vo1.setAdmin_no(vo.getStud_no());
			vo1.setAdmin_nm(vo.getFullName());
			vo1.setAdmin_pn(String.valueOf(vo.getStud_pn()));
			vo1.setRole(vo.getRole());
			vo1.setAdmin_pw(pw);
			dummyMapper.admin_join(vo1);

			UserVO userVO = new UserVO();
			userVO.setUser_id(vo1.getAdmin_no());
			userVO.setAdmin_no(vo1.getAdmin_no());
			userVO.setRole(vo1.getRole());
			userVO.setUser_pw(pw);
			//userVO에도 넣기
			dummyMapper.user_admin(userVO);
		}else if (vo.getRole().equals("ROLE_STUDENT")){
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			String pw =(bc.encode(vo.getPassword()));

			StudentVO vo2 = new StudentVO();

			vo2.setMj(vo.getMj());
			vo2.setRole(vo.getRole());
			vo2.setStud_no(vo.getStud_no());
			vo2.setStud_pw(pw);
			vo2.setStud_pn(String.valueOf(vo.getStud_pn()));

			dummyMapper.stud_join(vo2);

			UserVO userVO = new UserVO();
			userVO.setUser_id(vo.getStud_no());
			userVO.setUser_pw(pw);
			userVO.setRole(vo.getRole());
			userVO.setStud_no(vo.getStud_no());
			//userVO에도 넣기
			dummyMapper.user_student(userVO);
		}
	}
}

 class Student {

	private static int nextPhoneNO= 1090420175;
	private String mj;
	private String fullName;
	private String password;
	private String role;
	private int stud_no;
	private int stud_pn;
	private String stud_ad;
	private String gndr_nm;
	private float snths_scr;

	public Student(String mj, String fullName, String password ,String stud_ad ,float snths_scr , String gndr_nm , int stud_no) {
		this.mj = mj;
		this.fullName = fullName;
		this.password = password;
		this.role = "ROLE_STUDENT";
		this.stud_pn = nextPhoneNO++;
		this.stud_ad = stud_ad;
		this.snths_scr = snths_scr;
		this.gndr_nm = gndr_nm;
		this.stud_no = stud_no;
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
	public String getStud_ad() {
		return stud_ad;
	}

	public String getGndr_nm() {
		return gndr_nm;
	}

	public float getSnths_scr() {
		return snths_scr;
	}

	public void setStud_no(int stud_no) {
		this.stud_no = stud_no;
	}
	
	
}




