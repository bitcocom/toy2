<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
$(document).ready(function(){
   $('#myForm').submit(function(event) {
         event.preventDefault(); // Prevent the form from submitting normally
         let frmData={
            num:$("#num").val(),
            title:$("#title").val(),
            price:$("#price").val(),
            name:$("#name").val(),
            page:$("#page").val()
         };
         $.ajax({
             url: '/toy2/update',
             type: 'PUT',
             data: JSON.stringify(frmData), // JSON 문자열로 변경
             contentType: 'application/json;charset=utf-8',
             success: function(response) {
                 location.href="/toy2/list";
             },
             error: function(xhr, status, error) {
                alert("error");
             }
         });
     });
 });
  function goDel(num){
          // 삭제요청, URL돌려서요청, ajax요청
         location.href="/toy2/delete/"+num; // GET방식 요청
    }
</script>
</head>
<body>

    <div class="container">
        <h2>MVC Framework</h2>
        <div class="card">
            <div class="card-header">Book View(책 상세보기)</div>
            <div class="card-body">
               <!-- Bootstrap from-->                               <!-- 서버로 전송방법(get=QueryString , post)-->
                            <form id="myForm">
                                 <input type="hidden" id="num" value="${dto.num}"/>
                                 <div class="form-group">
                                   <label for="title">제목:</label>                                                                             <!-- 폼 파라메터 -->
                                   <input type="text" class="form-control" value="${dto.title}" id="title">
                                 </div>
                                 <div class="form-group">
                                   <label for="price">가격:</label>
                                   <input type="text" class="form-control" value="${dto.price}" id="price">
                                 </div>
                                <div class="form-group">
                                   <label for="name">저자:</label>
                                   <input type="text" class="form-control" id="name" value="${dto.name}" id="name">
                                 </div>
                                 <div class="form-group">
                                   <label for="page">페이지수:</label>
                                   <input type="text" class="form-control" value="${dto.page}" id="page">
                                 </div>
                                 <button type="submit" class="btn btn-primary btn-sm">수정</button>
                                 <button type="button" class="btn btn-success btn-sm" onclick="goDel(${dto.num})">삭제</button>
                                 <button type="button" class="btn btn-info btn-sm" onclick="location.href='/toy2/list'">목록</button>
                            </form>
            </div>
            <div class="card-footer">패스트캠퍼스_BE7_박매일</div>
        </div>
    </div>


</body>
</html>

