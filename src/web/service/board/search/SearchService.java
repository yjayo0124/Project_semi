package web.service.board.search;

import javax.servlet.http.HttpServletRequest;

import web.dto.Search;

public interface SearchService {

	
	public Search result(HttpServletRequest req);
	
	public String HtmlParser(String urlToRead);
}
