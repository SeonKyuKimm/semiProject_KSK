package edu.kh.surf.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.surf.member.model.DAO.MemberDAO;
import edu.kh.surf.member.model.dto.Member;
import edu.kh.surf.member.model.service.MemberService;
import edu.kh.surf.practice.model.dto.Practice;
import edu.kh.surf.practice.model.service.PracticeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");

		
			
			MemberService service = new MemberService();
			
			Member loginMember = service.login(inputId,inputPw);
			
			HttpSession session = req.getSession();

			
			if(loginMember != null ) {
				
				session.setAttribute("loginMember", loginMember);
				
				
				PracticeService practiceService = new PracticeService();
					
				
				List<Practice> practiceList = practiceService.selectAll(loginMember.getMemberNo());
				
				session.setAttribute("practiceList", practiceList);
				
				resp.sendRedirect("/");
				
			}else {
				
				session.setAttribute("message", "아이디 또는 비밀번호를 확인하셈");
				String referer = req.getHeader("referer");
			
				resp.sendRedirect(referer);
			}
			
			
		}catch(Exception e) {
			
			System.out.println("로그인 예외 발생");
			e.printStackTrace();
		}
	}
	
}
