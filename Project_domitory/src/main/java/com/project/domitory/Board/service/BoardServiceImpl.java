package com.project.domitory.Board.service;


import com.project.domitory.util.Criteria;
import com.project.domitory.command.BoardUploadVO;
import com.project.domitory.command.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("boardService")
public class  BoardServiceImpl implements BoardService {
	
    @Autowired
    private BoardMapper boardMapper;

    @Override
    public ArrayList<BoardVO> getList(Criteria cri, String user_id) {

        ArrayList<BoardVO> al = boardMapper.getList(cri,user_id);
        System.out.println(al.toString());
        return al;
    }
    @Override
    public int getTotal(Criteria cri, String user_id) {
        System.out.println("이건되나요?2");
        return boardMapper.getTotal(cri, user_id);
    }

    //업로드경로
    @Value("C:\\Users\\user\\Desktop\\ProjectTeam3\\TeamProject_System\\upload")
    private String uploadPath;

    //날짜폴더만드는 함수
    public String makeFolder() {
        String filepath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        File file = new File(uploadPath + "/" + filepath);
        if(file.exists() == false) { //해당 파일이 있으면 true, 없으면 false
            file.mkdirs();
        }

        return filepath;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int regist(BoardVO vo, List<MultipartFile> list ) {
        //파일업로드 처리
        int result = boardMapper.regist(vo); //

        //업로드작업처리
        for(MultipartFile file : list) {
            // 파일명
            String filename = file.getOriginalFilename();
            filename = filename.substring( filename.lastIndexOf("\\") + 1 );
            // 랜덤 이름으로 파일명 바꾸기
            String uuid = UUID.randomUUID().toString();
            // 날짜별로 폴더생성
            String filepath = makeFolder(); //yyyyMMdd
            // 업로드할 경로
            String savePath = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;

            try {
                File saveFile = new File(savePath);
                file.transferTo(saveFile); //업로드

            } catch (Exception e) {
                e.printStackTrace();
            }

            //업로드이후에는 데이터베이스에 경로를 저장
            boardMapper.registFile(BoardUploadVO.builder()
                    .SU_FILE_NAME(filename)
                    .SU_FILE_PATH(filepath)
                    .SU_FILE_UUID(uuid)
                    .SUB_SN(vo.getSUB_SN()) //FK
                    .STUD_NO( vo.getSTUD_NO() )
                    .build()
            );

        }
        System.out.println(vo.getSUB_SN());
        System.out.println("실행됩니다");
        System.out.println(result);
        return result;
    }

    @Override
    public BoardVO getDetail(int user_id) {
        return boardMapper.getDetail(user_id);
    }

    @Override
    public ArrayList<BoardUploadVO> getImgs(int user_id) {
        return boardMapper.getImgs(user_id);
    }

    @Override
    public int update(BoardVO vo) {
        return boardMapper.update(vo);
    }

    @Override
    public void delete(int sub_sn) {
        boardMapper.delete(sub_sn);
    }

}
