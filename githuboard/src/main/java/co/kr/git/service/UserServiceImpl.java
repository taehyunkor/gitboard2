package co.kr.git.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

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

@Override
public void register(PortfolioMember member) {
	userDao.register(member);
	
}

@Override
public Map<String, Object> traffic() {
	Map<String, Object> map = new HashMap<String, Object>();
	try {
		// 텍스트 파일의 내용 읽기 - BufferedReader
		BufferedReader br = new BufferedReader(
			new FileReader(
				"D:\\Java\\log.txt"));
		//파일의 내용을 전부 읽어서 출력
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			//공백을 가지고 문자열을 분할해서 ar에 저장
			String [] ar = line.split(" ");
			Object traffic = map.get(ar[0]);
			//ip 가 존재하지 않는 경우
			if(traffic == null && !ar[9].equals("-")){
				//저장: 없을 때는 값을 정수로 변환해서 저장
				map.put(ar[0], Integer.parseInt(ar[9]));
			}
			//ip가 존재하는 경우
			else if(!ar[9].equals("-")) {
				Integer imsi = (Integer)traffic;
				imsi = imsi + Integer.parseInt(ar[9]);
				map.put(ar[0], imsi);
			}
		}
		br.close();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}

	return map;
}
 
}
