package co.kr.git.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.git.dao.UserDao;
import co.kr.git.domain.PortfolioMember;

@Service
public class UserServiceImpl implements UserService {
 @Autowired
 private UserDao userDao;

@Override
//
public PortfolioMember login(PortfolioMember member) {
	return userDao.login(member);
}

@Override
public String emailcheck(String email) {
	
	return userDao.emailcheck(email);
}

@Override
public String nicknamecheck(String nickname) {
	
	return userDao.nickname(nickname);
}
 
}
