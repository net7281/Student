package dto;

public class ScoreDTO {
	private String name;
	private int sum;
	private double avg;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "이름 : " + name + ", 총합 : " + sum + ", 평균 : " + avg;
	}
	
	
}
