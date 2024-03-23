package com.zerock.dao;

import java.util.ArrayList;

public interface BoardDAO {

	public void boardRegist(BoardVO vo); //board 등록 메서드
	public ArrayList<BoardVO> getList(); //모든 게시물 가져오기
	public void boardDelete(int num); //게시글 삭제 메서드
	
	//위 메서드를 구현하는 마이바티스xml을 생성하기
	
}
