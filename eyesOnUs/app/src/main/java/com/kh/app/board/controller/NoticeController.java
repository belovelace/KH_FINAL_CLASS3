package com.kh.app.board.controller;

import com.kh.app.adminHr.vo.AdminHrVo;
import com.kh.app.board.service.NoticeService;
import com.kh.app.board.vo.NoticeVo;
import com.kh.app.board.vo.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService service;

    // 작성하기
    @GetMapping("write")
    public String write(){
        return "board/notice/write";
    }

    @PostMapping("write")
    @ResponseBody
    public HashMap<String, String > write(NoticeVo vo, HttpSession session){
        AdminHrVo adminHrLoginVo = (AdminHrVo) session.getAttribute("adminHrLoginVo");

        int result = service.write(vo);

        HashMap<String, String > map = new HashMap<>();
        if( adminHrLoginVo == null ){
            map.put("msg", "관리자 로그인 필요");
            return map;
        }

        map.put("msg", "작성 성공");
        if( result != 1){
            map.put("msg", "작성 실패");
        }
        return map;
    }

    // 목록
    @GetMapping("list")
    public String list(){
        return "board/notice/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public HashMap<String, Object> listData(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){

        int paginationCount = 5;

        List<NoticeVo> voList = service.listData(page, size);
        PageVo pageVo = service.getPageCount(page, size, paginationCount);

        HashMap<String ,Object> result = new HashMap<>();
        result.put("voList", voList);
        result.put("pageVo", pageVo);

        return result;
    }

    // 상세조회
    @GetMapping("detail")
    public String noticeByNo(){
        return "board/notice/detail";
    }

    @GetMapping("detailData")
    @ResponseBody
    public NoticeVo noticeByNoData(NoticeVo vo){
        return service.noticeByNo(vo.getNo());
    }

    // 수정하기
    @GetMapping("modify")
    public String modify(){
        return "board/notice/modify";
    }

    @PostMapping("modify")
    @ResponseBody
    public ResponseEntity<HashMap<String, String>> modify(NoticeVo vo){
        int result = service.modify(vo);

        HashMap<String, String> map = new HashMap<>();

        if( result == 1 ){
            map.put("msg", "작성성공");
            return ResponseEntity.ok(map);
        }else{
            map.put("msg", "작성실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    // 삭제하기
    @DeleteMapping("delete")
    @ResponseBody
    public ResponseEntity<HashMap<String, String>> delete(String no){
        int result = service.delete(no);

        HashMap<String, String> map = new HashMap<>();
        if( result == 1 ){
            map.put("msg", "삭제성공");
            return ResponseEntity.ok(map);
        } else{
            map.put("msg", "삭제 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    // 검색
    @GetMapping("search")
    @ResponseBody
    public List<NoticeVo> search(NoticeVo vo){
        List<NoticeVo> voList = service.search(vo);
        return voList;
    }



//////////홈 공지사항 조회///////////////

    // 목록
    @GetMapping("homeList")
    public String homeList(){
        return "board/notice/homeList";
    }


}
