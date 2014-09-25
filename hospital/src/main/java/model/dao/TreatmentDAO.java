package model.dao;

import java.util.List;

import model.domain.TreatmentDTO;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class TreatmentDAO {
	
	static public List<TreatmentDTO> seleteAllTreatment() {
		SqlSession session = DBUtil.getSqlSession();
		List<TreatmentDTO> tmList = null;
		try {
			tmList = session.selectList("Treatment.seleteAllTreatment");
		} finally {
			session.close();
		}
		return tmList;
	}

	static public int insertTreatment(TreatmentDTO tm) {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.insert("Treatment.insertTreatment", tm);
		} finally {
			session.close();
		}
		return result;
	}

	static public int updateTreatment(TreatmentDTO tm) {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.update("Treatment.updateTreatment", tm);
		} finally {
			session.close();
		}
		return result;
	}

	static public int deleteAllTreatment() {
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try {
			result = session.delete("Treatment.deleteAllTreatment");
		} finally {
			session.close();
		}
		return result;
	}
}