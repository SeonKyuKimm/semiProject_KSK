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

@WebServlet("/update")
public class UpdateController extends HttpServlet {

	private PracticeService service = new PracticeService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
		
			Member member = (Member)session.getAttribute("loginMember");
									
			Practice practice = service.selectOne(req.getParameter("practiceNo"), member.getMemberNo());
			
			req.setAttribute("practice", practice);
			
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
			
		}catch(Exception e) {
			
			System.out.println("수정할 연습목록 조회 중 예외~");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			Member member = (Member)session.getAttribute("loginMember");
			
			String title = req.getParameter("title");
			String memo = req.getParameter("memo");
			String practiceNo = req.getParameter("practiceNo");
			
			int result = service.update (title, memo, member.getMemberNo(), practiceNo  );
			
			if (result > 0) {
				session.setAttribute("message", "수정 완료");
				
				List<Practice> practiceList = service.selectAll(member.getMemberNo());
				session.setAttribute("practiceList", practiceList);
				
				resp.sendRedirect("/");
				
			}else {
				session.setAttribute("message", "수정 실패~");
			
				resp.sendRedirect(req.getHeader("referer"));
			}
			
			
		}catch(Exception e){
			
			System.out.println("수정 중 예외 발생~");
			e.printStackTrace();
			
		}
		
		
	}
}
