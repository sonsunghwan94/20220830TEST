package ctrl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		HttpSession session=request.getSession();
		MemberVO mVO=dao.selectOne(vo);
		if(mVO!=null){
			session.setAttribute("mid", mVO.getMid());
			ActionForward forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
			return forward;
		}
		else{
			throw new Exception("login 오류");
		}
		
	}

}
