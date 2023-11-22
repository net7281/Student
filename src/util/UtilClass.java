package util;

import dto.StudentDTO;

public class UtilClass {
	
	//이름이 같은사람 찾기
	public int searchName(String name, StudentDTO studenDtos[]) {
		int index = -1;
		for (int i = 0; i < studenDtos.length; i++) {
			if(studenDtos[i] != null && name.equals(studenDtos[i].getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	//총점
	public int sumScore(StudentDTO dto) {
		return dto.getKor()+dto.getEng()+dto.getMath();
		
	}
	
	//평균
	public double avgScore(StudentDTO dto) {
		return (double)sumScore(dto)/3;
		
	}
	
	//전체 평균, 총점
	
}
