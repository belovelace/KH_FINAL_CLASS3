package com.kh.app.board.dao;

import com.kh.app.board.mapper.NoticeMapepr;
import com.kh.app.board.vo.NoticeVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeDao {

    private final NoticeMapepr mapper;

    // 작성하기
    public int write(NoticeVo vo) {
        return mapper.write(vo);
    }

    // 목록
    public List<NoticeVo> listData(int offset, int limit) {
        RowBounds rowBounds = new RowBounds(offset, limit);
        return mapper.listData(rowBounds);
    }

    // 페이지 처리
    public int getPageCount(){
        return mapper.getPageCount();
    }

    // 상세조회
    public NoticeVo noticeByNo(String no) {
        return mapper.noticeByNo(no);
    }

    // 수정하기
    public int modify(NoticeVo vo) {
        return mapper.modify(vo);
    }

    // 삭제하기
    public int delete(String no) {
        return mapper.delete(no);
    }

    // 검색
    public List<NoticeVo> search(NoticeVo vo) {
        return mapper.search(vo);
    }

}
