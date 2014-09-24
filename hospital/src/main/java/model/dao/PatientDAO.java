package model.dao;

import model.dto.PatientDTO;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class PatientDAO {

	static public void insertPatient(PatientDTO pt){
		SqlSession session = DBUtil.getSqlSession(true);
		try {
			session.insert("Patient.insertInfo", pt);
		} finally {
			session.close();
		}
	}
}
