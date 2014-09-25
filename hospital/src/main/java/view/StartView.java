package view;

import model.dao.MedicalRecordDAO;
import model.dao.PatientDAO;
import model.dao.PrescriptionDAO;
import model.dao.TreatmentDAO;
import model.domain.PatientDTO;

public class StartView {
	public static void main(String[] args) {
		PrescriptionDAO.deleteAllPrescription();
		MedicalRecordDAO.deleteAllMedicalRecord();
		TreatmentDAO.deleteAllTreatment();
		PatientDAO.deleteAllPatient();
	}
}
