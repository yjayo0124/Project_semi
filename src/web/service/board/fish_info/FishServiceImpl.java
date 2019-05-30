package web.service.board.fish_info;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.board.fish_info.FishDao;
import web.dao.board.fish_info.FishDaoImpl;
import web.util.Fish_Paging;
import web.util.Paging;

public class FishServiceImpl implements FishService {

	private FishDao fishDao = new FishDaoImpl() ;
	
	@Override
	public List getList(Fish_Paging paging) {
		return fishDao.selectAll(paging) ;
	}

	@Override
	public Fish_Paging getCurPage(HttpServletRequest req) {
		// 전달파라미터 curPage 파싱
				String param = req.getParameter("curPage");
				int curPage = 0;
				if( param!=null && !"".equals(param) ) {
					curPage = Integer.parseInt(param);
				}
				
				// 전체 게시글 수
				int totalCount = fishDao.selectCntAll();
				
				// 페이징 객체 생성
				Fish_Paging paging = new Fish_Paging(totalCount, curPage);
//				System.out.println(paging); //TEST
				
				return paging;
	}

}
