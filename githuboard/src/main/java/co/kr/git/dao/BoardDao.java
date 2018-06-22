package co.kr.git.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.git.domain.PortfolioBoard;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	//가장 큰 글번호를 가져오는 SQL
	public Integer maxNum() {
		return sqlSession.selectOne("board.maxnum");
	}
	
	//글을 저장하기 위한 SQL
	//글쓰기는 실패가 없다고 간주함
	//성공여부를 확인하고자 하면 int를 리턴하면 됩니다.
	public void insert(PortfolioBoard board) {
		sqlSession.insert("board.insert", board);
	}
	
}
