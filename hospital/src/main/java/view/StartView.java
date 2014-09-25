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

		 PatientDAO.insertPatient(new PatientDTO("name", "jumin", "adress", "phone"));

		// Patient all Print
		List<PatientDTO> ptList = PatientDAO.selectAllPatient();
		for (PatientDTO data : ptList) {
			System.out.println(data);
		}

		// Prescription List Print
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
