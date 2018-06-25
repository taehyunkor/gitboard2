package co.kr.git.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	//글쓰기를 위한 메소드
	//ip 주소는 입력받을 수 없기 때문에 request 객체를 이용해서
	//읽어내야 하기 때문입니다.
	public void insert(HttpServletRequest request);
	
	
	public List<Map<String,Object>> list();
}
