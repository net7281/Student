package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import dao.StudentDAO;
import util.FileIO;

public class MainClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();
		FileIO fileio = new FileIO("student");
		fileio.create();
		
		while (true) {
			System.out.println();
			System.out.println("=== 학생정보 프로그램 ===");
			System.out.println();
			System.out.println("1. 학생정보입력");
			System.out.println("2. 학생정보삭제");
			System.out.println("3. 학생정보검색");
			System.out.println("4. 학생정보수정");
			System.out.println("5. 학생정보전체출력");
			System.out.println("6. 파일저장");
			System.out.println("7. 파일불러오기");
			System.out.println("-------------");
			System.out.println("8. 성적관리프로그램");
			System.out.println();
			System.out.print("원하시는 메뉴의 번호를 입력하세요 >> ");
			
			int menuNum = 0;
			try {
				menuNum = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
				scanner.next(); //버퍼에 남아있는 잘못된 입력제거
				continue;
			}
			
			
			switch (menuNum) {
			case 1: //학생정보입력
				dao.insert();
				dao.allData();
				break;
			case 2: //학생정보삭제
				dao.delete();
				dao.allData();
				break;
			case 3: //학생정보검색
				dao.select();
				dao.allData();
				break;
			case 4: //학생정보수정
				dao.update();
				dao.allData();
				break;
			case 5: //학생정보 모두출력
				dao.allData();
				break;
			case 6: //학생정보 모두출력
				fileio.writeFile(dao.dtoSelect());
				break;
			case 7:
				System.out.println("기존의 데이터가 날아갈 수 있습니다. 계속하시겠습니까? (0입력시 취소)");
				char flag = scanner.next().charAt(0);
				if(flag == '0') {
					break;
				}else {
					dao.dtoUpdate(fileio.readFile());
					dao.allData();
					break;
				}
			case 8:
				System.out.println();
				System.out.println("----성적관리프로그램----");
				System.out.println("1. 학생 성적 조회");
				System.out.println("2. 과목별 최고점, 최저점 학생 출력");
				System.out.println("3. 평균별 학생 등수");
				System.out.println();
				
				char scoreManu = scanner.next().charAt(0);
				switch(scoreManu){
					case '1' :
						dao.selectOneScore();
						break;
						
					case '3':
						dao.selectAllScore();
						break;
					default:
						System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
						break;
				}
				
				break;
			default:
				break;
			}
		}
		
		
		
	}
}
