package com.recw.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.recw.board.dao.IBoardDAO;
import com.recw.board.vo.BoardVO;

@Service
public class BoardService implements IBoardService {

	@Inject
	private IBoardDAO dao;

	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
	}

	@Override
	public BoardVO read(Integer board_num) throws Exception {
		return dao.read(board_num);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer board_num) throws Exception {
		dao.delete(board_num);
	}

	@Override
	public List<BoardVO> getBoardList() throws Exception {

		return dao.getBoardList();
	}

}
