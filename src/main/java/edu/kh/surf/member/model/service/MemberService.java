package edu.kh.surf.member.model.service;

import static edu.kh.surf.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.surf.common.JDBCTemplate;
import edu.kh.surf.member.model.DAO.MemberDAO;
import edu.kh.surf.member.model.dto.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();
	
	
	
	/** login
	 * @param inputId
	 * @param inputPw
	 * @return login service
	 */
	public Member login(String inputId, String inputPw) throws Exception {
		
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, inputId, inputPw);
		
		close(conn);
		
		return loginMember;
	}



	public int signup(Member member) throws Exception {

		Connection conn = getConnection();
		
		int result = dao.signup(conn, member);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		return result;
	}

}
