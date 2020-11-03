package com.recw.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.recw.board.vo.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "com.recw.mapper.BoardMapper";

  @Override
  public void create(BoardVO vo) throws Exception {
    session.insert(namespace + ".create", vo);
  }

  @Override
  public BoardVO read(Integer board_num) throws Exception {
    return session.selectOne(namespace + ".read", board_num);
  }

  @Override
  public void update(BoardVO vo) throws Exception {
    session.update(namespace + ".update", vo);
  }

  @Override
  public void delete(Integer board_num) throws Exception {
    session.delete(namespace + ".delete", board_num);
  }

  @Override
  public List<BoardVO> getBoardList() throws Exception {
	 // List<BoardVO> a = 
    return session.selectList(namespace + ".getBoardList");
  }

	/*
	 * @Override public List<BoardVO> listPage(int page) throws Exception {
	 * 
	 * if (page <= 0) { page = 1; }
	 * 
	 * page = (page - 1) * 10;
	 * 
	 * return session.selectList(namespace + ".listPage", page); }
	 */
}


 