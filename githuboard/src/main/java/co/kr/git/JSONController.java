package co.kr.git;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.kr.git.service.UserService;

@RestController
public class JSONController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "emailcheck")
	public Map<String,Object> emailcheck(String email) {
		String result = userService.emailcheck(email);
				Map<String,Object> map = new HashMap<String,Object>();
		    if(result ==null) map.put("result","null");
		    else map.put("result","email");
				
			return map;
	}
	@RequestMapping(value = "nicknamecheck")
	public Map<String,Object> nicknamecheck(String nickname) {
		String result = userService.emailcheck(nickname);
				Map<String,Object> map = new HashMap<String,Object>();
		    if(result ==null) map.put("result","null");
		    else map.put("result","nickname");
				
			return map;
	}
	
	@RequestMapping("traffic")
	public Map<String, Object> traffic(){
		return userService.traffic();
	}
	
}
