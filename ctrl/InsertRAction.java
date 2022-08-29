package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;
import board.ReplyVO;

public class InsertRAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao=new BoardDAO();
		ReplyVO vo=new ReplyVO();
		BoardVO bvo=new BoardVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		vo.setMid(request.getParameter("mid"));
		vo.setRmsg(request.getParameter("rmsg"));
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		dao.insertR(vo);
		dao.update_r(bvo);
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		request.setAttribute("cnt",request.getParameter("cnt"));
		return forward;
	}

}
