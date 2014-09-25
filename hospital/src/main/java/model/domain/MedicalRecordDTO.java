package model.domain;

public class MedicalRecordDTO {
	private int no;
	private int ptNo;
	private String diagnosis;
	private String date;

	public MedicalRecordDTO() {	}

	public MedicalRecordDTO(int ptNo, String diagnosis, String date) {
		this.ptNo = ptNo;
		this.diagnosis = diagnosis;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPtNo() {
		return ptNo;
	}

	public void setPtNo(int ptNo) {
		this.ptNo = ptNo;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(no);
		builder.append(" | ");
		builder.append(ptNo);
		builder.append("\t | ");
		builder.append(diagnosis);
		builder.append("\t | ");
		builder.append(date);
		return builder.toString();
	}

}