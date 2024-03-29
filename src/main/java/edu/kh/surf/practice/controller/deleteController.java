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

@WebServlet("/delete")
public class deleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String practiceNo = req.getParameter("practcieNo");
			
			PracticeService service = new PracticeService();
			
			int result = service.delete(practiceNo);
			
			HttpSession session = req.getSession();
			
			Member member = (Member)session.getAttribute("loginMember");
			
				if(result>0){
					
					List<Practice> practiceList = service.selectAll(member.getMemberNo());
					session.setAttribute("practiceList", practiceList);
				
				}else {
				
					session.setAttribute("message", "삭제 실패~");
				
				}
				
			resp.sendRedirect("/");
			
		}catch(Exception e) {
			
			System.out.println("삭제중 예외~");
			e.printStackTrace();
			
		}
	}
	
}
