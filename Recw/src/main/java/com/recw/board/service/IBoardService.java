package com.recw.board.service;

import java.util.List;

import com.recw.board.vo.BoardVO;


public interface IBoardService {

  public void regist(BoardVO board) throws Exception;

  public BoardVO read(Integer board_num) throws Exception;

  public void modify(BoardVO board) throws Exception;

  public void remove(Integer board_num) throws Exception;

  public List<BoardVO> getBoardList() throws Exception;
  
  
	/*
	 * public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	 * 
	 * public int listCountCriteria(Criteria cri) throws Exception;
	 * 
	 * public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	 * 
	 * public int listSearchCount(SearchCriteria cri) throws Exception;
	 */

}
