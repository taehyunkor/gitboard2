package co.kr.git;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.git.domain.PortfolioMember;
import co.kr.git.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
     @Autowired
     private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}


	
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(PortfolioMember member, 
			RedirectAttributes attr,
			HttpSession session) {
		//로그인 성공 여부를 구분
		PortfolioMember m = userService.login(member);
		//로그인 실패
		if(m == null) {
			attr.addFlashAttribute(
				"msg", "없는 아이디 이거나 잘못된 비밀번호입니다.");
			//로그인을 실패 후 리다이렉트로 login 페이지로 이동
			return "redirect:login";
		}
		//로그인 성공
		else {
			//로그인에 성공한 경우에는 로그인 정보를 세션에 저장
			//로그인 정보는 member라는 이름으로 저장
			session.setAttribute("member", m);
			return "redirect:./";
		}
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session,RedirectAttributes attr) {
		session.invalidate();
		attr.addAttribute("msg","로그아웃 하셧습니다");
		
		return "redirect:./";
	}

	
	
}
