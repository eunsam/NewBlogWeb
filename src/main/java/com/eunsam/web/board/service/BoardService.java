package com.eunsam.web.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.eunsam.web.board.model.BoardVO;

public interface BoardService {
	
	//����Ʈ ȣ��
	public List<BoardVO> getBoardList() throws Exception;
	
	//�۾��� ������
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	//�� ����
	public BoardVO getBoardContent(int bid) throws Exception;
	
	//���� ����
	public void updateBoard(BoardVO boardVO) throws Exception;

	//�Խñ� ����
	public void deleteBoard(int bid) throws Exception;
}
