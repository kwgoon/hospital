package model.dto;

public class TreatmentDTO {
	private int ptNo;
	private int state;

	public TreatmentDTO() {
	}

	public TreatmentDTO(int ptNo, int state) {
		this.ptNo = ptNo;
		this.state = state;
	}

	public int getPtNo() {
		return ptNo;
	}

	public void setPtNo(int ptNo) {
		this.ptNo = ptNo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(ptNo);
		builder.append("\t | ");
		builder.append(state);
		return builder.toString();
	}
}