package edu.kh.surf.practice.model.service;

import static edu.kh.surf.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.surf.practice.model.DAO.PracticeDAO;
import edu.kh.surf.practice.model.dto.Practice;

public class PracticeService {

	PracticeDAO dao = new PracticeDAO();

	
	/** 로그인 한 회원의  practiceList 전체 조회
	 * @param memberNo
	 * @return practiceList
	 * @throws Exception
	 */
	public List<Practice> selectAll(int memberNo) throws Exception {
		Connection conn = getConnection();

		List<Practice> practiceList = dao.selectAll(conn, memberNo);
		
		close(conn);
		
		return practiceList;
	}


	public int insert(String title, String memo, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		int result = dao.insert(conn, title,memo, memberNo);
		
		if( result >0 ) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	public int delete(String practiceNo) throws Exception{
		
		Connection conn = getConnection();
		int result = dao.delete(conn, practiceNo);
		
		if(result >0 ) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}


	public Practice selectOne(String practiceNo, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		Practice practice = dao.selectOne(conn, practiceNo, memberNo);
		
		close(conn);
		
		return practice;
	}


	
	public int update(String title, String memo, int memberNo, String practiceNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.update(conn, title, memo, memberNo, practiceNo);
		
		
		if (result > 0) commit(conn);
		else			rollback(conn);
		close(conn);
		
		
		return result;
	}
}
