package co.kr.git.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.git.dao.BoardDao;
import co.kr.git.domain.PortfolioBoard;
import co.kr.git.domain.PortfolioMember;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public void insert(HttpServletRequest request) {
		//가장 큰 글번호를 가지고 글번호를 만들기
				Integer num = boardDao.maxNum();
				if(num == null) {
					num = 0;
				}
				num = num + 1;
				
				//email 가져오기
				HttpSession session = request.getSession();
				PortfolioMember member = 
						(PortfolioMember)session.getAttribute("member");
				String email = member.getEmail();
				
				//파라미터 읽어오기
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				//오늘 날짜 만들기
				Date writeDate = new Date();
				
				//ip 주소 
				String ip = request.getRemoteAddr();
				
				//조회수
				int readcnt = 0;
				
				//삽입을 위한 메소드의 파라미터 만들기
				PortfolioBoard board = new PortfolioBoard();
				board.setNum(num);
				board.setEmail(email);
				board.setTitle(title);
				board.setContent(content);
				board.setWritedate(writeDate);
				board.setIp(ip);
				board.setReadcnt(readcnt);
				
				//글쓰기 메소드 호출
				boardDao.insert(board);

	}
	@Override
	public List<Map<String, Object>> list() {
        List<Map<String, Object>> list = boardDao.list();
		
		//오늘 날짜를 문자열로 만들기
		Calendar calendar = Calendar.getInstance();
		//sql의 Date는 toString을 하면 날짜만 리턴합니다.
		java.sql.Date today = 
			new java.sql.Date(calendar.getTimeInMillis());
		//작성일과 오늘날짜를 비교해서 동일하면 시간을 저장하고
		//그렇지 않으면 날짜를 저장
		for(Map map : list) {
			String writedate = map.get("WRITEDATE").toString();
			if(today.toString().equals(writedate.substring(0,10))) {
				map.put("WRITEDATE", writedate.substring(11));
			}
			else {
				map.put("WRITEDATE", writedate.substring(1,10));
			}
		}
		
		
		return list;
	}

}
