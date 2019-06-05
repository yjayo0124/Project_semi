package web.service.board.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import web.dto.Search;

public class SearchServiceImpl implements SearchService{

	private static String FIRST_URL = "http://api.data.go.kr/openapi/fshlc-info-std?";	
	private static String KEY = "serviceKey=xkoM0fFVJiv9hmvG8chBcmLjxoUgAY%2FayOgAS3tZL%2F%2BCqJ7XBPCVVS%2BZcz3L%2FK9BJo4Hg87FRHlEBZYMR9DDIg%3D%3D";
	
	@Override
	public List result(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html; charset=utf-8"); 	
		resp.setCharacterEncoding("UTF-8");
		
		List list = new ArrayList();
		
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

//--------------------------------여기까진 사용자가 입력한 값을 파라미터를 통해 받은 부분을 url화 시킴--------------------------			
			
			try {
				URL url = new URL(strURL); //url로 이동해서 
//				System.out.println("strURL: "+strURL);
				
				BufferedReader bf;
				String line = "";
				String result = "";
				
				bf = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
				//스트림을 통해 JSON데이터를 가져온다.
				while((line=bf.readLine())!=null){
					result = result.concat(line); //url상 화면에 나오는 문자열이 result에 string타입으로 다 담김 	

			//		System.out.println("스트림으로 불러온 값: "+result);

				}
				
				JSONParser parser = new JSONParser(); 
				//json데이터 받을 객체 선언하고
				
				//JSON타입으로 읽을 수 있도록 변환해줌
				JSONObject obj = (JSONObject) parser.parse(result); 
				JSONObject parse_response = (JSONObject) obj.get("response");
				JSONObject parse_header = (JSONObject) parse_response.get("header");

				String resultCode = (String) parse_header.get("resultCode");
				
				if( resultCode.equals("00") ) {
				
					//System.out.println("정상 응답");
					//응답이 정상인 경우(또는 데이터가 존재할때 ) 
					JSONObject parse_body = (JSONObject) parse_response.get("body");
					
					//items는 '배열'로 담겨있기 때문에 JSONArray로 담아서 가져와야한다. 
					JSONArray parse_items = (JSONArray) parse_body.get("items");
					
					JSONObject res; //필요한 데이터만 가져올 객체 선언
						
					//만약 조회 결과가 많다면 한 줄 한 줄 읽어옮. (필요한 개체만 가져오도록함)
					for(int i = 0; i<parse_items.size(); i++) {
						
						Search search = new Search();
						//만들어 두었던 search dto 
						
						res = (JSONObject) parse_items.get(i);
						//결과를 담을 JSONObject에서 url로 얻은 json데이터의 items만을 담는다. 
						//이후 !!!items값만!!!! 꺼내와서 search객체에 담고 사용자에게 보냄
						
						search.setFshlcNm((String) res.get("fshlcNm")); //낚시터 명
						search.setLnmadr((String) res.get("lnmadr"));
						search.setRdnmadr((String) res.get("rdnmadr")); //도로명 주소
						search.setFshlcPhoneNumber((String) res.get("fshlcPhoneNumber")); //낚시터전화번호
						search.setKdfsh((String) res.get("kdfsh")); //주요어종
						search.setUseCharge((String) res.get("useCharge")); //이용요금
						search.setCvntl((String) res.get("cvntl")); //편익시설현황
						search.setCfrTrrsrt((String) res.get("cfrTrrsrt")); //주변관광지 
						search.setInsttNm("["+(String) res.get("insttNm")+"]");
						
						list.add(search);
						
						}
					
				}else if( !resultCode.equals("00")  ) {
					//System.out.println("에러코드 : "+resultCode);
					
					Search search = new Search();
					
					search.setResultCode("검색 결과가 없습니다.");
					
					list.add(search);
				}
		
			} catch (MalformedURLException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 

	
		return list;
		
	}

	@Override
	public String count(HttpServletRequest req, HttpServletResponse resp) {
		
		String res = null;
		
		resp.setContentType("text/html; charset=utf-8"); 	
		resp.setCharacterEncoding("UTF-8");
	
		
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

//--------------------------------여기까진 사용자가 입력한 값을 파라미터를 통해 받은 부분을 url화 시킴--------------------------			
			
			try {
				URL url = new URL(strURL); //url로 이동해서 
//				System.out.println("strURL: "+strURL);
				
				BufferedReader bf;
				String line = "";
				String result = "";
				
				bf = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
				//스트림을 통해 JSON데이터를 가져온다.
				while((line=bf.readLine())!=null){
					result = result.concat(line); //url상 화면에 나오는 문자열이 result에 string타입으로 다 담김 	
//					System.out.println("스트림으로 불러온 값: "+result);
				}
				
				JSONParser parser = new JSONParser(); 
				//json데이터 받을 객체 선언하고
				
				//JSON타입으로 읽을 수 있도록 변환해줌
				JSONObject obj = (JSONObject) parser.parse(result); 
				JSONObject parse_response = (JSONObject) obj.get("response");
				JSONObject parse_header = (JSONObject) parse_response.get("header");

				String resultCode = (String) parse_header.get("resultCode");
				
				if( resultCode.equals("00") ) {
				
					System.out.println("정상 응답 resultCode : "+resultCode);
					//응답이 정상인 경우(또는 데이터가 존재할때 ) 
					JSONObject parse_body = (JSONObject) parse_response.get("body");
					
					//items는 '배열'로 담겨있기 때문에 JSONArray로 담아서 가져와야한다. 
					String parse_totalCount =  (String) parse_body.get("totalCount");
					
					res = parse_totalCount;
					
			
					
				}else if( !resultCode.equals("00")  ) {
					System.out.println("에러코드 : "+resultCode);
					
					Search search = new Search();
					
					if( resultCode.equals("03")) {
						System.out.println("데이터 없음");
					}
					
					
					res = "0";
					
			
				}
		
			} catch (MalformedURLException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
		
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 

		
	
		return res;
		
		
		
	}
	
	
}
