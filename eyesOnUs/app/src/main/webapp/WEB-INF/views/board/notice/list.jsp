<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
      @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
      @import url('https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&family=Jua&display=swap');
      @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap');
    </style>

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/footer.css">
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/popUpBoard.css">
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/sidebar.css">
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/teamRoom.css">
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/header.css">
      <link rel="stylesheet" type="text/css" href="/css/homeUtil/testPersonalPage.css">
      <link rel="stylesheet" type="text/css" href="/css/board/notice/list.css">
      <script defer src="../js/adminUtil.js"></script>
      <script defer src="../js/testMain/sidebar.js"></script>
      <script defer src="../js/testMain/calender.js"></script>
      <script defer src="../js/commute/write.js"></script>
      <script defer src="../js/commute/quit.js"></script>
      <script defer src="../js/board/notice/list.js"></script>
      <script defer src="../js/board/notice/detail.js"></script>
      <script defer src="../js/board/notice/search.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>

      <title>홈페이지</title>
    </head>

    <body id="container">
      <div id="warp">
        <%@ include file="/WEB-INF/views/homeUtil/header.jsp" %>
        <%@ include file="/WEB-INF/views/homeUtil/nav.jsp" %>
        <section>
          <div id="out">
            <h2>🔵 공지사항</h2>
            <hr>
            <div id="out2">
              <c:if test="${sessionScope.adminHrLoginVo != null }">
              <button id="writeBtn" onclick="location.href='http://127.0.0.1:8383/notice/write'">작성하기</button>
              </c:if>
              <div id="search">
                <span>게시글 검색</span>&nbsp;
                <select name="searchType" id="searchType">
                  <option value="title">제목</option>
                  <option value="content">게시글</option>
                </select>&nbsp;<input type="text" name="searchValue">
                <button style="cursor: pointer;" onclick="search();">검색🔍</button>
              </div>
            </div>

            <br><br>
            <div class="body">
              <div id="left">
                <span>게시판</span>
                <p>- 공지사항</p>
                <p>- 자유게시판</p>
                <p>- 건의게시판</p>

              </div>
              <div id="right">
                <table border="1" id="rightBox">
                  <tr id="listBox">
                    <th>No.</th>
                    <th>제목</th>
                    <th>등록일</th>
                    <th>등록자</th>
                    <th>조회수</th>
                  </tr>
                  <tbody class="box">

                  </tbody>
                </table>
                <div class="pageBox">
                  <div id="page">

                  </div>
                </div>
              </div>
            </div>
            <br>
          </div>
        </section>
        <%@ include file="/WEB-INF/views/homeUtil/footer.jsp" %>
      </div>
    </body>
</html>
