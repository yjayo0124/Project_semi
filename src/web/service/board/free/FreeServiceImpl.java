package web.service.board.free;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.board.free.FreeDao;
import web.dao.board.free.FreeDaoImpl;
import web.dto.FreeBoard;
import web.util.Paging;

public class FreeServiceImpl implements FreeService{

	private FreeDao boardDao = new FreeDaoImpl();
	
	@Override
	public List getList(Paging paging) {
		return boardDao.selectAll(paging);
	}

	@Override
	public Paging getCurPage(HttpServletRequest req) {
		
		// 전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		// 전체 게시글 수
		int totalCount = boardDao.selectCntAll();
		
		// 페이징 객체 생성
		Paging paging = new Paging(totalCount, curPage);
//		System.out.println(paging); //TEST
		
		return paging;
	}

	@Override
	public FreeBoard getBoardno(HttpServletRequest req) {
		
		// 전달파라미터 boardno 파싱
		String param = req.getParameter("boardno");
		int boardno = 0;
		if( param!=null && !"".equals(param) ) {
			boardno = Integer.parseInt(param);
		}
		
		//Board 객체 생성
		FreeBoard board = new FreeBoard();
		board.setFree_board_no(boardno);
		
		return board;
	}

	@Override
	public FreeBoard view(FreeBoard viewBoard) {
		
		//게시글 조회수 +1
		boardDao.updateHit(viewBoard);
		
		//게시글 조회 반환
		return boardDao.selectBoardByBoardno(viewBoard);
	}

	
}
