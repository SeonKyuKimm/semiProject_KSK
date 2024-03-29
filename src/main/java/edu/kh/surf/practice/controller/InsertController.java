package edu.kh.surf.practice.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.surf.member.model.dto.Member;
import edu.kh.surf.practice.model.dto.Practice;
import edu.kh.surf.practice.model.service.PracticeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/insert")
public class InsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
			String title = req.getParameter("title");
			String memo = req.getParameter("memo");
			
			Member member = (Member)session.getAttribute("loginMember");
			
			PracticeService service = new PracticeService();
			
			int result = service.insert(title, memo, member.getMemberNo());
			
			if(result > 0) {
				session.setAttribute("message", "등록 완료~");
				
				List<Practice> practiceList = service.selectAll(member.getMemberNo());
				session.setAttribute("practiceList", practiceList);
				
				resp.sendRedirect("/");
			}else {
				session.setAttribute("message", "등록 실패 ~");
				resp.sendRedirect("referer");
			}
						
			
		}catch(Exception e) {
			System.out.println("insert 예외발생");
			e.printStackTrace();
		}
	}
}
