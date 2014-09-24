package model.dto;

public class PrescriptionDTO {
	private int mrNo;
	private String medicine;
	private int times;
	private int days;

	public PrescriptionDTO() {
	}

	public PrescriptionDTO(int mrNo, String medicine, int times, int days) {
		this.mrNo = mrNo;
		this.medicine = medicine;
		this.times = times;
		this.days = days;
	}

	public int getMrNo() {
		return mrNo;
	}

	public void setMrNo(int mrNo) {
		this.mrNo = mrNo;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(mrNo);
		builder.append("\t | ");
		builder.append(medicine);
		builder.append("\t | ");
		builder.append(times);
		builder.append("\t | ");
		builder.append(days);
		return builder.toString();
	}
}