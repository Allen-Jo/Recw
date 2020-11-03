package com.recw.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recw.board.service.IBoardService;
import com.recw.board.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private IBoardService service;
	
	//게시판 게시물 입력 페이지 이동
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String write(Model model) {
		
		return "board/boardWrite";
	}
	//게시판 게시물 DB 입력
	@RequestMapping(value = "/boardInsert", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

		service.regist(board);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/list";
	}
	
	/*
	 * //게시판 게시물 목록 페이지 이동
	 * 
	 * @RequestMapping(value = "/boardList", method = RequestMethod.GET) public
	 * String listProc(Model model) {
	 * 
	 * return "board/boardList"; }
	 */
	//게시물 목록 페이지 출력
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public void list(Model model) throws Exception {

		model.addAttribute("getBoardList", service.getBoardList());
		
	}

	//게시물 읽기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("board_num") int board_num, Model model) throws Exception {

		model.addAttribute(service.read(board_num));
	}

	//게시물 삭제
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("board_num") int board_num, RedirectAttributes rttr) throws Exception {

		service.remove(board_num);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/list";
	}

	// 수정전 번호
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int board_num, Model model) throws Exception {

		model.addAttribute(service.read(board_num));
	}

	//게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

		service.modify(board);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/list";
	}

}
