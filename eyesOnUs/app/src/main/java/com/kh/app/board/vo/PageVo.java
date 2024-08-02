package com.kh.app.board.vo;

import lombok.Data;

@Data
public class PageVo {

    // 최소 페이지
    private int min;
    // 최대 페이지
    private int max;

    // 이전 버튼의 페이지 번호
    private int prevPage;
    // 다음 버튼의 페이지 번호
    private int nextPage;

    // 전체 페이지 개수
    private int pageCnt;
    // 현재 페이지 번호
    private int currentPage;

    public PageVo(int contentCnt, int currenPage, int contentPageCnt, int paginationCnt){
        // 현재 페이지 번호
        this.currentPage = currenPage;

        // 전체 페이지 개수 (전체 글 개수/ 페이지 당 글 개수)
        pageCnt = contentCnt / contentPageCnt;
        if(contentCnt % contentPageCnt > 0){
            pageCnt++;
        }

        // 최소값 = ((현재 페이지 번호 -1 ) / 페이지 당 글의 개수) * 페이지 당 글의 개수 + 1
        min = ((currenPage - 1) / paginationCnt) * paginationCnt + 1;

        // 최대값 = min + 페이지 버튼의 개수
        max = min + paginationCnt - 1;

        if( max > pageCnt ){
            max = pageCnt;
        }

        // 이전페이지 누를 경우
//        prevPage = min - 1;

        //마지막 페이지 넘어가지 않도록
        if( nextPage > pageCnt ){
            nextPage = pageCnt;
        }

        // 이전 페이지 번호
        prevPage = (currentPage > 1 ) ? currenPage -1 : 0;

        // 다음 페이지 번호
        nextPage = (currenPage < pageCnt) ? currenPage + 1 : 0;
    }


}
