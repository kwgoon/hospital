package model.dto;

public class PatientDTO {
	private int no;
	private String name;
	private String residentNo;
	private String address;
	private String phone;

	public PatientDTO() {
	}

	public PatientDTO(String name, String residentNo, String address, String phone) {
		this.name = name;
		this.residentNo = residentNo;
		this.address = address;
		this.phone = phone;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResidentNo() {
		return residentNo;
	}

	public void setResidentNo(String residentNo) {
		this.residentNo = residentNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(no);
		builder.append(" | ");
		builder.append(name);
		builder.append("\t | ");
		builder.append(residentNo);
		builder.append("\t | ");
		builder.append(address);
		builder.append("\t | ");
		builder.append(phone);
		return builder.toString();
	}
}