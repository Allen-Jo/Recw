package com.recw.board.dao;

import java.util.List;



import com.recw.board.vo.BoardVO;

public interface IBoardDAO {

  public void create(BoardVO vo) throws Exception;

  public BoardVO read(Integer board_num) throws Exception;

  public void update(BoardVO vo) throws Exception;

  public void delete(Integer board_num) throws Exception;

  public List<BoardVO> getBoardList() throws Exception;

//  public List<BoardVO> listPage(int page) throws Exception;

	/*
	 * public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	 * 
	 * public int countPaging(Criteria cri) throws Exception;
	 * 
	 * //use for dynamic sql
	 * 
	 * public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
	 * 
	 * public int listSearchCount(SearchCriteria cri)throws Exception;
	 */
}
