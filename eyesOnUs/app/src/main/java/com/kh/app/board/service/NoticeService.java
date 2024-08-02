package com.kh.app.board.service;

import com.kh.app.board.dao.NoticeDao;
import com.kh.app.board.vo.NoticeVo;
import com.kh.app.board.vo.PageVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {

    private final NoticeDao dao;

    // 작성하기
    public int write(NoticeVo vo) {
        return dao.write(vo);
    }

    // 목록
    public List<NoticeVo> listData(int page, int contentPageCnt) {
        int offset = (page - 1) * contentPageCnt;
        return dao.listData(offset, contentPageCnt);
    }

    // 페이지 처리
    public PageVo getPageCount(int currentPage, int contentPageCnt, int paginationCount){
        int totalContentCount = dao.getPageCount();
        return new PageVo(totalContentCount, currentPage, contentPageCnt, paginationCount);
    }

    // 상세조회
    public NoticeVo noticeByNo(String no) {
        return dao.noticeByNo(no);
    }

    // 수정하기
    public int modify(NoticeVo vo) {
        return dao.modify(vo);
    }

    // 삭제하기
    public int delete(String no) {
        return dao.delete(no);
    }

    // 검색
    public List<NoticeVo> search(NoticeVo vo) {
        return dao.search(vo);
    }


}
