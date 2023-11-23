package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dto.StudentDTO;

public class FileIO {
	
	
	private String fileName;
	private File file;
	
	public FileIO(String fileName) {
		this.fileName = fileName;
		file = new File( "C:\\tmp\\" + fileName+".txt");
	}
	
	//파일 생성
	public void create() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공");
			}else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//파일 저장
	public void writeFile(String strArr[]) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for(String str : strArr) {
				pw.println(str);
			}
			pw.close();
			System.out.println("파일을 출력하였습니다.");
			
		} catch (IOException e) {
			System.out.println("입력에 실패하였습니다");
		}
	}
	
	
	//파일불러오기
	public StudentDTO[] readFile() {
		
		StudentDTO studenDtos[] = new StudentDTO[10];
		
		String str = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			if(file.exists() && file.isFile() && file.canRead()) {
				
				int lintCount = 0;
				while ((str = br.readLine()) != null) {
//					System.out.println(str);
					String info[] = str.split("-");
					
					studenDtos[lintCount] = new StudentDTO();
					
					studenDtos[lintCount].setName(info[0]); //이름
					studenDtos[lintCount].setAge(Integer.parseInt(info[1])); //나이
					studenDtos[lintCount].setHeight(Double.parseDouble(info[2])); //키
					studenDtos[lintCount].setAddress(info[3]); //주소
					studenDtos[lintCount].setKor(Integer.parseInt(info[4])); //국
					studenDtos[lintCount].setEng(Integer.parseInt(info[5])); //영
					studenDtos[lintCount].setMath(Integer.parseInt(info[6])); //수
					
					lintCount++;
				}
				br.close();
			}else {
				System.out.println("파일이 존재하지 않습니다.");
			}
			
		} catch (Exception e) {
			System.out.println("읽기에 실패하였습니다.");
		}
		return studenDtos;
	}
}
