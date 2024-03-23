package com.project.domitory.Board.service;

import com.project.domitory.util.Criteria;
import com.project.domitory.command.BoardUploadVO;
import com.project.domitory.command.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface BoardService {
    public int regist(BoardVO vo, List<MultipartFile> list ); //insert(vo, 파일데이터)
    public ArrayList<BoardVO> getList(Criteria cri, String user_id); //select
    public int getTotal(Criteria cri, String user_id); //전체게시글 수
    public BoardVO getDetail(int user_id);
    public ArrayList<BoardUploadVO> getImgs(int user_id);
    public int update(BoardVO vo);
    public void delete(int sub_sn);

}
