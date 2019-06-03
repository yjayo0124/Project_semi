package web.service.board.search;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.json.JSONParser;

import web.dto.Search;

public class SearchServiceImpl implements SearchService{

	private static String FIRST_URL = "http://api.data.go.kr/openapi/fshlc-info-std?";	
	private static String KEY = "serviceKey=xkoM0fFVJiv9hmvG8chBcmLjxoUgAY%2FayOgAS3tZL%2F%2BCqJ7XBPCVVS%2BZcz3L%2FK9BJo4Hg87FRHlEBZYMR9DDIg%3D%3D";

	
	@Override
	public Search result(HttpServletRequest req) {
		
		Search search = new Search(); //검색결과 넣을 객체 선언
		
		String strURL = null; //보낼 주소 URL
		String insttNm1 = null;  //시.도명
		String insttNm2 = null;  //군.구명
		String fshlcNm = null; //낚시터검색이름
		String kdfsh = null; //어종검색이름
		//변수선언

		strURL = FIRST_URL;
		strURL += KEY;
		strURL += "&pageNo=1";
		strURL += "&numOfRows=100";
		strURL += "&type=json";
		//strUR변수에 차례대로 값 담음.

		try {
			//파라미터로 각 값들 가져옴
			fshlcNm = URLEncoder.encode(req.getParameter("fshlcNm"), "UTF-8");
			kdfsh = URLEncoder.encode(req.getParameter("kdfsh"), "UTF-8");
			insttNm1 = URLEncoder.encode(req.getParameter("insttNm1"), "UTF-8");
			insttNm2 = URLEncoder.encode(req.getParameter("insttNm2"), "UTF-8");
		
			if( fshlcNm != null &&!"".equals(fshlcNm)) {
				strURL += "&fshlcNm="+fshlcNm;
			}
			
			if( kdfsh != null &&!"".equals(kdfsh)) {
				strURL += "&kdfsh="+kdfsh;
			}
		
			if( insttNm1 != null &&!"".equals(insttNm1)) {
				strURL += "&insttNm="+insttNm1+"%20"+insttNm2; //%20은 공백 유니코드
			}
			
			System.out.println(strURL);
			
			String jsonSouce = HtmlParser(strURL.toString());
			
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 

		return search;
	}


	@Override
	public String HtmlParser(String urlToRead) { //JSON형태를 읽어 오기위한 소스코드
	
		StringBuffer result = new StringBuffer();
		try {
			URL url = new URL(urlToRead);
	        InputStream is = url.openStream();
	        int ch;
            while ((ch = is.read()) != -1) {
            //System.out.print((char) ch);
            result.append((char) ch);

            }
	        
		} catch (MalformedURLException e) {
			e.printStackTrace();    
		} catch (IOException e) {
            e.printStackTrace();
        }

		return result.toString();

	}

	
	
	
}
