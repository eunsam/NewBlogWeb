package com.eunsam.web.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.eunsam.web.board.dao.BoardDAO;
import com.eunsam.web.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;
	
	//리스트 호출
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
		}
	
	//글쓰기 페이지
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	
	//상세 내용
	public BoardVO getBoardContent(int bid) throws Exception {
		boardDAO.updateViewCnt(bid);
		return boardDAO.getBoardContent(bid);
	}
	
	//내용 수정
	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}

	//게시글 삭제
	@Override
	public void deleteBoard(int bid) throws Exception {
		boardDAO.deleteBoard(bid);
	}
}
