package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;
import board.ReplyVO;

public class DeleteRAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao=new BoardDAO();
		ReplyVO vo=new ReplyVO();
		BoardVO bvo=new BoardVO();
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		vo.setRid(Integer.parseInt(request.getParameter("rid")));
		if(dao.deleteR(vo)) {
		dao.update_r(bvo);
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		request.setAttribute("cnt", request.getParameter("cnt"));
		return forward;
		
		}else {
			throw new Exception("deleteR 오류"); 
		}
	}

}
