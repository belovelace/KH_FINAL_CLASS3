package com.kh.app.board.mapper;

import com.kh.app.board.vo.NoticeVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface NoticeMapepr {

    // 작성하기
    @Insert("""
            INSERT INTO NOTICE_BOARD(
                NO
                , WRITER_NO
                , TITLE
                , CONTENT
                , ENROLL_DATE
            )
            VALUES (
                SEQ_NOTICE_BOARD.NEXTVAL
                , 0
                , #{title}
                , #{content}
                , SYSDATE
            )
            """)
    int write(NoticeVo vo);

    // 목록조회
    @Select("""
            SELECT\s
                N.NO
                , E.NAME AS WRITER_NO
                , N.TITLE
                , N.CONTENT
                , N.HIT
                , N.ENROLL_DATE
            FROM NOTICE_BOARD N
            JOIN EMPLOYEE E
            ON N.WRITER_NO = E.NO
            ORDER BY N.NO DESC
            """)
    List<NoticeVo> listData(RowBounds rowBounds);

    // 페이지 수 가져오기
    @Select("""
            SELECT COUNT(*)
            FROM NOTICE_BOARD
            """)
    int getPageCount();

    // 상세조회
    @Select("""
            SELECT
                N.NO
                , E.NAME AS WRITER_NO
                , N.TITLE
                , N.CONTENT
                , N.HIT
                , N.ENROLL_DATE
            FROM NOTICE_BOARD N
            JOIN EMPLOYEE E
            ON N.WRITER_NO = E.NO
            WHERE N.NO = #{no}
            """)
    NoticeVo noticeByNo(String no);

    // 수정하기
    @Update("""
            UPDATE NOTICE_BOARD 
            SET TITLE = #{title} , CONTENT = #{content} WHERE NO = #{no}
            """)
    int modify(NoticeVo vo);

    // 삭제하기
    @Delete("DELETE FROM NOTICE_BOARD WHERE NO = #{no}")
    int delete(String no);

    // 검색
    @Select("""
        <script>
        SELECT\s
            N.NO
            , E.NAME AS WRITER_NO
            , N.TITLE
            , N.CONTENT
            , N.HIT
            , N.ENROLL_DATE
        FROM NOTICE_BOARD N
        JOIN EMPLOYEE E
        ON N.WRITER_NO = E.NO
        <where>
            <if test="title != null">
                TITLE LIKE '%' ||#{title}|| '%'
            </if>
            <if test="content != null">
                CONTENT LIKE '%' ||#{content}|| '%'
            </if>
        </where>
        </script>
        """)
    List<NoticeVo> search(NoticeVo vo);


}

