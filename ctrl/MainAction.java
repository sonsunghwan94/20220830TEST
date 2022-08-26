package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardSet;
import board.BoardVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao=new BoardDAO();
		BoardVO vo=new BoardVO();
		int cnt;
		boolean flag=true;
		if(request.getParameter("cnt")==null){ // main페이지 첫 진입
			cnt=2; // 초기 상태에서 보여줄 게시물의 갯수
			vo.setCnt(cnt);
		}else{ // main페이지에서 더보기 요청
			cnt=Integer.parseInt(request.getParameter("cnt"));
			vo.setCnt(cnt);
		}
		
		ArrayList<BoardSet> datas=dao.selectAll(vo);
		vo.setCnt(cnt+1);
		ArrayList<BoardSet> datasNext=dao.selectAll(vo);
		request.setAttribute("datas", datas);
		request.setAttribute("cnt", cnt);
		if(datas.size()!=datasNext.size()){
			// cnt+1의 데이터 길이가 현재 cnt 데이터 길이와 다르다면
			// ->다음 데이터가 있음
		request.setAttribute("more", flag); // true->더보기 활성화
		}else{ // cnt+1의 데이터 길이가 현재 cnt 데이터 길이와 같다면
				// ->다음 데이터 없음
			flag=false; // 더보기 비활성화
			request.setAttribute("more",flag);
		}
		ActionForward forward=new ActionForward();
		forward.setPath("/main.jsp");
		forward.setRedirect(false);
		return forward;
	}
	
}


 
 

