package com.eunsam.web.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.eunsam.web.board.model.BoardVO;

public interface BoardService {
	
	//리스트 호출
	public List<BoardVO> getBoardList() throws Exception;
	
	//글쓰기 페이지
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	//상세 내용
	public BoardVO getBoardContent(int bid) throws Exception;
	
	//내용 수정
	public void updateBoard(BoardVO boardVO) throws Exception;

	//게시글 삭제
	public void deleteBoard(int bid) throws Exception;
}
