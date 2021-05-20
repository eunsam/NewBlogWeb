package com.eunsam.web.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eunsam.web.board.model.BoardVO;
import com.eunsam.web.board.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	//리스트 호출
	@RequestMapping(value="/getBoardList", method=RequestMethod.GET)
	public String getBoardList(Model model) throws Exception {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/index";
	}
	
	//글쓰기 페이지
	@RequestMapping(value="/boardForm")
	public String boardForm(@ModelAttribute("boardVO") BoardVO vo, Model model) {
		return "board/boardForm";
	}
	
	//글 저장(수정내용 저장)
	@RequestMapping(value="/saveBoard", method=RequestMethod.POST)
	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO
			,@RequestParam("mode") String mode
			,RedirectAttributes rttr) throws Exception {
		if (mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		} else {
		boardService.insertBoard(boardVO);
		}
		return "redirect:/board/getBoardList";
	}
	
	//상세 내용
	@RequestMapping(value="/getBoardContent", method=RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		return "board/boardContent";
	}
	
	//내용 수정
	@RequestMapping(value="/editForm", method=RequestMethod.GET)
	public String editForm(@RequestParam("bid") int bid, 
			@RequestParam("mode") String mode, Model model) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());
		return "board/boardForm";
		}

	//게시글 삭제
	@RequestMapping(value="/deleteBoard", method=RequestMethod.GET)
	public String deleteBoard(RedirectAttributes rttr,
			@RequestParam("bid") int bid) throws Exception {
		boardService.deleteBoard(bid);
		return "redirect:/board/getBoardList";
	}
}
