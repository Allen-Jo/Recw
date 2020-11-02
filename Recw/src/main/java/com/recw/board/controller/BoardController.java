package com.recw.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recw.board.service.BoardService;
import com.recw.board.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	private BoardService service;

	
	  @RequestMapping(value = "linser", method = RequestMethod.GET)
	  public String list() { 
		  System.out.println("BoardController.list()");

		  return "board/list"; 
	 }
	 

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

		service.regist(board);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {

		model.addAttribute("list", service.list());
	}

	// 읽기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("board_num") int board_num, Model model) throws Exception {

		model.addAttribute(service.read(board_num));
	}

	// 삭제
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

	// 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

		service.modify(board);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/list";
	}

}
