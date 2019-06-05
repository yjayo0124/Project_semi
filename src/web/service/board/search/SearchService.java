package web.service.board.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SearchService {

	
	public List result(HttpServletRequest req, HttpServletResponse resp);
	
	
	public String count(HttpServletRequest req, HttpServletResponse resp);
	
}
