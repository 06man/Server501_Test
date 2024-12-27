package com.busanit501.boot501.controller;

import com.busanit501.boot501.dto.*;
import com.busanit501.boot501.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@Log4j2
@RequestMapping("/board")
@RequiredArgsConstructor
// http://localhost:8080/board, 시작하겠다.
public class BoardController {
    private final BoardService boardService;
    // http://localhost:8080/board/list
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model ) {
        // 서비스 이용해서, 데이터베이스 목록 페이징 처리해서 가져오기.
        // 앞단 화면에서, 검색어:keyword 내용, 페이징 내용(page = 1) 담아서 전달.
//        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        // 교체 작업, 수정1
//        PageResponseDTO<BoardListReplyCountDTO> responseDTO = boardService.listWithReplyCount(pageRequestDTO);
        // 교체 작업, 수정2, 게시글 + 댓글 갯수 + 첨부된 이미지들
        PageResponseDTO<BoardListAllDTO> responseDTO = boardService.listWithAll(pageRequestDTO);
        log.info("pageRequestDTO 의 getLink 조사 : " + pageRequestDTO.getLink());
        log.info("PageResponseDTO 의 responseDTO 조사 : " + responseDTO);
        model.addAttribute("responseDTO", responseDTO);
    }

    //등록 작업, 1) 등록화면 2) 로직처리
    @GetMapping("/register")
    public void register() {

    }
    @PostMapping("/register")
    // 일반글로 만 받을 때, DTO 클래스로 받고 있는데,
    // 화면에서, -> 파일 이미지들을 문자열 형태로 , 각각 따로 보내고 있음.
    // 받을 때 타입을 변경.
    public String registerPost(@Valid BoardDTO boardDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        log.info("BoardController register post 로직처리: ");
        log.info("BoardController register post  boardDTO : " + boardDTO);

        // 유효성 체크 -> 유효성 검증시, 통과 안된 원인이 있다면,
        if (bindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발생함.");
            // 1회용으로, 웹 브라우저에서, errors , 키로 조회 가능함. -> 뷰 ${errors}
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/register";
        }
        //검사가 통과가 되고, 정상 입력
        Long bno = boardService.register(boardDTO);

        // 글 정상 등록후, 화면에 result 값을 전달하기.
        // 1회용 사용하기.
        redirectAttributes.addFlashAttribute("result", bno);
        redirectAttributes.addFlashAttribute("resultType", "register");

        return "redirect:/board/list";

    }

    @GetMapping("/read")
    public void read(Long bno, PageRequestDTO pageRequestDTO,
                     Model model) {
        BoardDTO boardDTO = boardService.readOne(bno);
        model.addAttribute("dto", boardDTO);
    }

    @GetMapping("/update")
    public void update(Long bno, PageRequestDTO pageRequestDTO,
                     Model model) {
        BoardDTO boardDTO = boardService.readOne(bno);
        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/update")
    public String updatePost(@Valid BoardDTO boardDTO,
                               BindingResult bindingResult,
                               PageRequestDTO pageRequestDTO,
                               String keyword2,String page2, String type2,
                               RedirectAttributes redirectAttributes) {
        log.info("BoardController updatePost post 로직처리: ");
        log.info("BoardController updatePost post  boardDTO : " + boardDTO);

        log.info("BoardController updatePost post  pageRequestDTO : " + pageRequestDTO);

        //키워드 한글 처리.
        String encodedKeyword = URLEncoder.encode(keyword2, StandardCharsets.UTF_8);

        // 유효성 체크 -> 유효성 검증시, 통과 안된 원인이 있다면,
        if (bindingResult.hasErrors()) {
            log.info("has errors : 유효성 에러가 발생함.");
            // 1회용으로, 웹 브라우저에서, errors , 키로 조회 가능함. -> 뷰 ${errors}
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/update?bno="+boardDTO.getBno()+"&keyword="+encodedKeyword+"&page="+page2+"&type="+type2;
        }
        //검사가 통과가 되고, 정상 입력
        boardService.update(boardDTO);

        // 글 정상 등록후, 화면에 result 값을 전달하기.
        // 1회용 사용하기.
        redirectAttributes.addFlashAttribute("result", boardDTO.getBno());
        redirectAttributes.addFlashAttribute("resultType", "update");

        return "redirect:/board/read?bno="+boardDTO.getBno()+"&keyword="+encodedKeyword+"&page="+page2+"&type="+type2;

    }

    @PostMapping("/delete")
    // 삭제시,
    // 주의사항,
    // 1) 댓글 여부 2) 첨부 이미지, (물리서버, 디비서버 삭제 확인)
    // Long bno -> BoardDTO 형식으로 변경할 예정.
    public String delete(Long bno,
                         String keyword2,String page2, String type2,
                         RedirectAttributes redirectAttributes) {
        boardService.delete(bno);
        //키워드 한글 처리.
        String encodedKeyword = URLEncoder.encode(keyword2, StandardCharsets.UTF_8);

        redirectAttributes.addFlashAttribute("result", bno);
        redirectAttributes.addFlashAttribute("resultType", "delete");
        return "redirect:/board/list?"+"&keyword="+encodedKeyword+"&page="+page2+"&type="+type2;
    }

}
