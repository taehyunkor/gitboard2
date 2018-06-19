package co.kr.git.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.git.domain.PortfolioMember;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	//로그인을 처리하는 메소드
	public PortfolioMember login(PortfolioMember member) {
		return sqlSession.selectOne(
			"member.login", member);
	}

	//email 중복 체크를 위한 메소드
	public String emailcheck(String email) {
		return sqlSession.selectOne("member.emailcheck",email);
	}
	public String nickname(String nickname) {
		return sqlSession.selectOne("member.nickname",nickname);
	}
	
	
	
	
}
