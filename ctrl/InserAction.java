package ctrl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;



public class InserAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo.setMname(request.getParameter("mname"));
		boolean flag=true;
		ActionForward forward=new ActionForward();
		if(dao.insert(vo)){			
			request.setAttribute("flag", flag);
			forward.setPath("/signup.jsp");
			forward.setRedirect(false);
			return forward;
		}
		else{
			flag=false;
			request.setAttribute("flag", flag);
			forward.setPath("/signup.jsp");
			forward.setRedirect(false);
			return forward;
		}
	}

}
