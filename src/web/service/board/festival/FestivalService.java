package web.service.board.festival;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.festival.FestivalBoard;
import web.util.festival.FestivalPaging;


public interface FestivalService {

	public List getList(FestivalPaging paging);

	public FestivalPaging getCurpage(HttpServletRequest req);

	public FestivalBoard getBoardno(HttpServletRequest req);

	public FestivalBoard view(FestivalBoard board);

}
