package web.dao.board.festival;

import java.util.List;

import web.util.festival.FestivalPaging;


public interface FestivalDao {
	
	public List selectAll(FestivalPaging paging);
	
	public int selectCntAll();

}
