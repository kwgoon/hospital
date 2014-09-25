package model.dao;

import java.util.List;

import model.domain.PatientDTO;
import model.domain.PrescriptionDTO;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class PrescriptionDAO {

	static public List<PrescriptionDTO> seleteAllPrescription() {
		SqlSession session = DBUtil.getSqlSession();
		List<PrescriptionDTO> psList = null;
		try {
			psList = session.selectList("Prescription.seleteAllPrescription");
		} finally {
			session.close();
		}
		return psList;
	}

	static public int insertPrescription(List<PrescriptionDTO> psList) {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.insert("Prescription.insertPrescription", psList);
		} finally {
			session.close();
		}
		return result;
	}

	static public int deleteAllPrescription() {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.delete("Prescription.deleteAllPrescription");
		} finally {
			session.close();
		}
		return result;
	}
}