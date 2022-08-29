package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;

public class FavAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao=new BoardDAO();
		BoardVO vo=new BoardVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		dao.update(vo);
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		request.setAttribute("cnt", request.getParameter("cnt"));
		return forward;
	}

}
