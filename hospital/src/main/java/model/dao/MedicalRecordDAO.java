package model.dao;

import java.util.List;

import model.domain.MedicalRecordDTO;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class MedicalRecordDAO {

	static public List<MedicalRecordDTO> seleteMedicalRecordByPtNo(String ptNo) {
		SqlSession session = DBUtil.getSqlSession();
		List<MedicalRecordDTO> mrList = null;
		try {
			mrList = session.selectList("MedicalRecord.seleteMedicalRecordByPtNo", ptNo);
		} finally {
			session.close();
		}
		return mrList;
	}

	static public MedicalRecordDTO seleteMedicalRecordByNo(String no) {
		SqlSession session = DBUtil.getSqlSession();
		MedicalRecordDTO mr = null;
		try {
			mr = session.selectOne("MedicalRecord.seleteMedicalRecordByNo", no);
		} finally {
			session.close();
		}
		return mr;
	}

	static public int insertMedicalRecord(MedicalRecordDTO mr) {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.insert("MedicalRecord.insertMedicalRecord", mr);
		} finally {
			session.close();
		}
		return result;
	}

	static public int updateMedicalRecord(MedicalRecordDTO mr) {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.update("MedicalRecord.updateMedicalRecord", mr);
		} finally {
			session.close();
		}
		return result;
	}

	static public int deleteMedicalRecordByNo(String no) {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.delete("MedicalRecord.deleteMedicalRecordByNo");
		} finally {
			session.close();
		}
		return result;
	}

	static public int deleteAllMedicalRecord() {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.delete("MedicalRecord.deleteAllMedicalRecord");
		} finally {
			session.close();
		}
		return result;
	}
}