package view;

import java.util.List;

import model.dao.MedicalRecordDAO;
import model.dao.PatientDAO;
import model.dao.PrescriptionDAO;
import model.dao.TreatmentDAO;
import model.domain.PatientDTO;
import model.domain.PrescriptionDTO;
import model.domain.TreatmentDTO;

public class StartView {
	public static void main(String[] args) {
		PrescriptionDAO.deleteAllPrescription();
		MedicalRecordDAO.deleteAllMedicalRecord();
		TreatmentDAO.deleteAllTreatment();
		PatientDAO.deleteAllPatient();

		// PatientDAO.insertPatient(new PatientDTO("이름", "주민번호3", "주소", "전화번호"));
		// PatientDAO.deleteAllPatient();

		// 환자 전체 목록 검색
		List<PatientDTO> ptList = PatientDAO.selectAllPatient();
		for (PatientDTO data : ptList) {
			System.out.println(data);
		}

		// 진료 상태 목록
		List<PrescriptionDTO> pList = PrescriptionDAO.selectAllPrescription();
		for (PrescriptionDTO data : pList) {
			System.out.println(data);
		}
		
		List<TreatmentDTO> tmList = TreatmentDAO.selectAllTreatment();
		for (TreatmentDTO data : tmList) {
			System.out.println(data);
		}
	}
}
