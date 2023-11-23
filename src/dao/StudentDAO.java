package dao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import dto.ScoreDTO;
import dto.StudentDTO;
import util.UtilClass;

// Data Access Object :  데이터를 취급하는 클래스
public class StudentDAO {
	Scanner scanner = new Scanner(System.in);
	UtilClass utils = new UtilClass();
	
	//학생 데이터 관리 배열
	private StudentDTO studenDtos[];
	
	private int count;
	
	public StudentDAO() {
		count = 0;
		studenDtos = new StudentDTO[10]; //변수만 생성
		
		
		//dto를 생성
//		for(int i=0; i<studenDtos.length; i++) {
//			studenDtos[i] = new StudentDAO();
//		}
	}
	
	// 추가, 삭제, 검색, 수정 <- CRUD
	
	public void insert() {
		if(count < 10) {
			System.out.println();
			System.out.println("학생정보 입력 ==========");
			System.out.println();
			
			System.out.print("이름 >> ");
			String name = scanner.next();
			//중복처리
			int index = utils.searchName(name, studenDtos);
			if(index != -1) {
				System.out.println(name + "는 이미 존재하는 이름입니다.");
				return;
			}
			
			int age=0, kor=0, eng=0, math =0;
			double height=0;
			String address="";
			try {
				System.out.print("나이 >> ");
				age = scanner.nextInt();
				System.out.print("키 >> ");
				height = scanner.nextDouble();
				System.out.print("주소 >> ");
				address = scanner.next();
				
				System.out.print("국어 >> ");
				kor = scanner.nextInt();
				System.out.print("영어 >> ");
				eng = scanner.nextInt();
				System.out.print("수학 >> ");
				math = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못입력하셨습니다. 메뉴를 다시 선택해주세요.");
				scanner.next();
				return;
			}
			
			System.out.println();
			studenDtos[count] = new StudentDTO(name, age, height, address, kor, eng, math);
			count++;
		}else {
			System.out.println("죄송합니다. 학생정보가 가득 찼습니다.");
		}
	}
	
	public void delete() {
		//이름을 입력받고 int는 0, String은 ""
		
		System.out.println();
		System.out.println("학생정보 삭제 ==========");
		System.out.println();
		
		System.out.print("삭제하실 학생의 이름을 입력하세요 >> ");
		String name = scanner.next();
		
		//선생님은 찾았을때의 번호를 받아와서 처리하심
		int index = utils.searchName(name, studenDtos);
		if(index != -1) {
			studenDtos[index].setName("");
			studenDtos[index].setAge(0);
			studenDtos[index].setHeight(0);
			studenDtos[index].setAddress("");
			studenDtos[index].setKor(0);
			studenDtos[index].setEng(0);
			studenDtos[index].setMath(0);
			System.out.println(name + "학생의 정보를 삭제하였습니다.");
			return;
		}else {
			System.out.println(name + "학생을 찾지 못했습니다.");
			return;
		}
	}
	
	public void select() {
		//이름을 입력받고 그 학생의 모든 정보를 출력
		System.out.println();
		System.out.println("학생정보 조회 ==========");
		System.out.println();
		
		System.out.print("조회하실 학생의 이름을 입력하세요 >> ");
		String name = scanner.next();
		
		int index = utils.searchName(name, studenDtos);
		if(index != -1) {
			System.out.println();
			System.out.println("이름 : " + studenDtos[index].getName());
			System.out.println("나이 : " + studenDtos[index].getAge());
			System.out.println("키 : " + studenDtos[index].getHeight());
			System.out.println("주소 : " + studenDtos[index].getAddress());
			System.out.println("국어 : " + studenDtos[index].getKor());
			System.out.println("영어 : " + studenDtos[index].getEng());
			System.out.println("수학 : " + studenDtos[index].getMath());
			return;
		}else {
			System.out.println(name + "학생을 찾지 못했습니다.");
			return;
		}
	}
	
	public void update() {
		//이름을 입력받고 그 학생의 국수영 정보를 수정
		
		System.out.println();
		System.out.println("학생정보 수정 ==========");
		System.out.println();
		
		System.out.print("수정하실 학생의 이름을 입력하세요 >> ");
		String name = scanner.next();
		
		int index = utils.searchName(name, studenDtos);
		if(index != -1) {
			
			System.out.print("국어 >> ");
			int kor = scanner.nextInt();
			System.out.print("영어 >> ");
			int eng = scanner.nextInt();
			System.out.print("수학 >> ");
			int math = scanner.nextInt();
			
			studenDtos[index].setKor(kor);
			studenDtos[index].setEng(eng);
			studenDtos[index].setMath(math);
			System.out.println();
			System.out.println(name + "학생의 정보를 수정하였습니다.");
			return;
		}else {
			System.out.println(name + "학생을 찾지 못했습니다.");
			return;
		}
	}
	
	public void allData() {
		for(StudentDTO dto : studenDtos) {
			if(dto != null) {
				System.out.println(dto.toString());
			}
		}
	}
	
	//file----------------------------------------------------------
	
	//파일 저장용
	public String[] dtoSelect() {
		String str[] = new String[count];
		
		int i=0;
		for(StudentDTO dto : studenDtos) {
			if(dto != null && !dto.getName().isBlank()) {
				str[i] = dto.toString();
				i++;
			}
		}
		return str;
	}
	
	//파일 불러오기용
	public void dtoUpdate(StudentDTO studenDtos[]) {
		int count =0;
		for(StudentDTO dto : studenDtos) {
			if(dto != null) {
				count++;
			}
		}
		
		this.count = count;
		this.studenDtos = studenDtos;
	}
	
	
	
	// score---------------------------------------------------------
	
	//한 학생의 성적조회
	public void selectOneScore() {
		System.out.println();
		System.out.println("학생성적 조회 ==========");
		System.out.println();
		
		System.out.print("성적을 조회하실 학생의 이름을 입력하세요 >> ");
		String name = scanner.next();
		
		int index = utils.searchName(name, studenDtos);
		if(index != -1) {
			int sum = utils.sumScore(studenDtos[index]);
			double avg = utils.avgScore(studenDtos[index]);
			System.out.printf("%s학생의 총점 : %d, 평균 : %.2f",name,sum,avg);
		}else {
			System.out.println(name + "학생을 찾지 못했습니다.");
			return;
		}
	}
	
	
	public void selectAllScore() {
		System.out.println();
		System.out.println("평균별 학생 등수 ==========");
		System.out.println();
		
		ScoreDTO scoreDTOs[] = new ScoreDTO[count];
		
		for(int i = 0 ; i< studenDtos.length; i++) {
			if(studenDtos[i] != null) {
				scoreDTOs[i] = new ScoreDTO();
				scoreDTOs[i].setName(studenDtos[i].getName());
				scoreDTOs[i].setSum(utils.sumScore(studenDtos[i]));
				scoreDTOs[i].setAvg(utils.avgScore(studenDtos[i]));
			}
		}
		
		Arrays.sort(scoreDTOs, new Comparator<ScoreDTO>() {
            @Override
            public int compare(ScoreDTO s1, ScoreDTO s2) {
                double avg1 = s1.getAvg();
                double avg2 = s2.getAvg();

             // 평균값을 기준으로 내림차순 정렬
                return Double.compare(avg2, avg1);
            }
        });
		
		for(int i = 0; i<scoreDTOs.length;i++) {
			System.out.println((i+1)+"등 "+scoreDTOs[i].toString());
		}
	}
	
}