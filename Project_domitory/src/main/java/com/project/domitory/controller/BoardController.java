package com.project.domitory.controller;

import com.project.domitory.Board.service.BoardService;
import com.project.domitory.util.Criteria;
import com.project.domitory.command.BoardUploadVO;
import com.project.domitory.command.BoardVO;
import com.project.domitory.command.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    @Qualifier("boardService")
    private BoardService boardService;

    @Value("${project.upload.path}")
    private String uploadPath;


@GetMapping("/board")
public String list(Model model,Criteria cri, HttpSession session) {
    String user_id = (String)session.getAttribute("user_id");
    //목록을 가지고 나와서 데이터를 담고 나감
    ArrayList<BoardVO> list = boardService.getList(cri,user_id); //데이터
    int total=boardService.getTotal(cri,user_id);
    PageVO pageVO = new PageVO(cri, total); //페이지네이션
    model.addAttribute("list", list);
    model.addAttribute("pageVO", pageVO);

    return "board/board";
}
    @GetMapping("/boardReg")
    public String reg() {
        System.out.println("그럼 이건 타?");
        return "board/boardReg";
    }

    // 상품등록요청
    @PostMapping("/boardForm")
    public String boardForm(BoardVO vo,
                            RedirectAttributes ra,
                            @RequestParam("file") List<MultipartFile> list,
                            HttpSession session) {

        //vo.setSTUD_NO((String)session.getAttribute("user_id"));
        vo.setSTUD_NO("admin");
        // 공백인 이미지는 제거
        list = list.stream().filter(m -> !m.isEmpty()).collect(Collectors.toList());
        // 이미지 타입인지 검사

        // 3. 이미지를 올린 경우는 서비스로 위임
        int result = boardService.regist(vo, list); // vo는 상품데이터, list에 파일 데이터
        if (result == 1) { // 성공
            ra.addFlashAttribute("msg", "등록 완료"); // 리다이렉트 시에 1회성 데이터
        } else { // 실패
            ra.addFlashAttribute("msg", "등록 실패");
        }

        return "redirect:/board/board";
    }
    @GetMapping("/boardDetail")
    public String detail(@RequestParam("sub_sn") int user_id,
                         Model model
                         ) {
    	System.out.println(user_id +"뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡뿡");
        BoardVO vo = boardService.getDetail(user_id); //게시글 내용

        ArrayList<BoardUploadVO> imgs = boardService.getImgs(user_id); //이미지들
        for(BoardUploadVO vo2 : imgs) {
            System.out.println(vo2.toString());
        }
        model.addAttribute("vo", vo);
        model.addAttribute("imgs", imgs);
      

        return "/board/boardDetail";
    }

    @GetMapping("/display")
    public @ResponseBody ResponseEntity<byte[]> display(@RequestParam("filename") String filename, @RequestParam("filepath") String filepath,
                                                        @RequestParam("fileuuid") String fileuuid){
        String path = uploadPath + "/" + filepath + "/" + fileuuid + "_" + filename;
        File file = new File(path);

        byte[] arr = null;

        try {
            arr = FileCopyUtils.copyToByteArray(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(arr, HttpStatus.OK);
    }

    @GetMapping("updateBoard")
    public String updateBoard(Model model, HttpSession session){
        Model savedModel = (Model)session.getAttribute("modelData");
        if(savedModel !=null){
            model.addAllAttributes(savedModel.asMap());
        }
        return "/board/boardUpdate";
    }



    //업데이트요청
    @PostMapping("/updateForm")
    public String updateForm(BoardVO vo,
                             RedirectAttributes ra) {
        System.out.println(vo.toString());
        int result = boardService.update(vo);
        if (result == 1) {
            ra.addFlashAttribute("msg", "정상 처리되었습니다");
        } else {
            ra.addFlashAttribute("msg", "수정에 실패했습니다");
        }
        ra.addAttribute("sub_sn",vo.getSUB_SN());
        return "redirect:boardDetail";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam("sub_sn") String sub){
        int sub_sn = Integer.parseInt(sub);
        boardService.delete(sub_sn);
        return "redirect:/board/board";
    }

    @GetMapping("/fileDownload")
    public ResponseEntity<Resource> fileDownload(@RequestParam("filename") String filename, @RequestParam("filepath") String filepath,
                                                 @RequestParam("uuid") String uuid){

        String path = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
        Path filePaths = Paths.get(path);
        File file = new File(path);
        try{
            Resource resource = new UrlResource(filePaths.toUri());
            if(resource.exists()==false || resource.isFile()==false){
                throw new RuntimeException("file not found");
            }
            String fileName = URLEncoder.encode(file.getName(),"UTF-8");
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; fileName=\""+fileName+"\";")
                    .header(HttpHeaders.CONTENT_LENGTH,file.length()+"")
                    .body(resource);
        } catch(MalformedURLException e){
            throw new RuntimeException("file not found");
        } catch(UnsupportedEncodingException e2){
            throw new RuntimeException("filename encoding failed");
        }


    }

}

