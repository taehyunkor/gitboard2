package co.kr.git;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.git.service.BoardService;


@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
	
    @RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		return "write";
	}


	//글쓰기 버튼을 눌렀을 때를 처리하는 메소드
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(HttpServletRequest request) {
		boardService.insert(request);
		return "redirect:list";
	}
	// 목록보기를 눌렀을 때를 처리하는 메소드
		@RequestMapping(value = "list", method = RequestMethod.GET)
		public String list(Model model) {
			model.addAttribute("list", boardService.list());
			return "list";
		}
    
    
}
