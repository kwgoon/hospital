package model.dao;

import java.util.List;

import model.domain.PatientDTO;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class PatientDAO {

	static public PatientDTO seletePatient(String residentNo) {
		SqlSession session = DBUtil.getSqlSession();
		PatientDTO pt = null;
		try {
			pt = session.selectOne("Patient.seletePatient", residentNo);
		} finally {
			session.close();
		}
		return pt;
	}

	static public List<PatientDTO> seleteAllPatient() {
		SqlSession session = DBUtil.getSqlSession();
		List<PatientDTO> ptList = null;
		try {
			ptList = session.selectList("Patient.seleteAllPatient");
		} finally {
			session.close();
		}
		return ptList;
	}

	static public int insertPatient(PatientDTO pt) {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.insert("Patient.insertPatientInfo", pt);
		} finally {
			session.close();
		}
		return result;
	}

	static public int updatePatient(PatientDTO pt) {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.update("Patient.updatePatient", pt);
		} finally {
			session.close();
		}
		return result;
	}

	static public int deletePatientByResidentNo(String residentNo) {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.delete("Patient.deletePatientByResidentNo");
		} finally {
			session.close();
		}
		return result;
	}

	static public int deleteAllPatient() {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.delete("Patient.deleteAllPatient");
		} finally {
			session.close();
		}
		return result;
	}
}