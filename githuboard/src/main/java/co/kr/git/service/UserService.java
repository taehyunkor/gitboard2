package co.kr.git.service;

import co.kr.git.domain.PortfolioMember;

public interface UserService {
	
	//로그인을 처리해주는 메소드
	public PortfolioMember login(PortfolioMember member);
	
	public String emailcheck(String email);
	public String nicknamecheck(String nickname);
	
	
}
