package co.kr.git;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    
    
    
}
