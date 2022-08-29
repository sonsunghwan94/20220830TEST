package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class DeleteMAction implements Action{

	@Override
public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		vo.setMid((String)request.getSession().getAttribute("mid"));
		
		if(dao.delete(vo)) { // 회원 탈퇴를 성공적으로 수행한 경우
			System.out.println("deleteM 성공 로그");
			HttpSession session = request.getSession(); // 세션 객체 생성
			session.invalidate(); // 세션의 정보를 모두 지워줘
			
			ActionForward forward = new ActionForward();
			forward.setPath("main.do"); // main.do 경로로 저장
			forward.setRedirect(true); // redirect 방식으로 저장
			
			return forward;
		}
		else{ // 회원 탈퇴를 실패한 경우
			
			ActionForward forward = new ActionForward();
			forward.setPath("error/errorDelete.jsp"); // error 페이지 경로로 저장
			forward.setRedirect(true); // redirect 방식으로 저장
			
			return forward;
		}


	}
}
