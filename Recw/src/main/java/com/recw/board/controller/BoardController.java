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
	
	//�Խ��� �Խù� �Է� ������ �̵�
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String write(Model model) {
		
		return "board/boardWrite";
	}
	//�Խ��� �Խù� DB �Է�
	@RequestMapping(value = "/boardInsert", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

		service.regist(board);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/list";
	}
	
	/*
	 * //�Խ��� �Խù� ��� ������ �̵�
	 * 
	 * @RequestMapping(value = "/boardList", method = RequestMethod.GET) public
	 * String listProc(Model model) {
	 * 
	 * return "board/boardList"; }
	 */
	//�Խù� ��� ������ ���
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public void list(Model model) throws Exception {

		model.addAttribute("getBoardList", service.getBoardList());
		
	}

	//�Խù� �б�
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("board_num") int board_num, Model model) throws Exception {

		model.addAttribute(service.read(board_num));
	}

	//�Խù� ����
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("board_num") int board_num, RedirectAttributes rttr) throws Exception {

		service.remove(board_num);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/list";
	}

	// ������ ��ȣ
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int board_num, Model model) throws Exception {

		model.addAttribute(service.read(board_num));
	}

	//�Խù� ����
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

		service.modify(board);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/list";
	}

}
