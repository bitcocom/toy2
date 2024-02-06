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
<script src="/toy2/resources/js/register.js"></script>
</head>
<body>

    <div class="container">
        <h2>MVC Framework</h2>
        <div class="card">
            <div class="card-header">Header</div>
            <div class="card-body">
              <form id="bookForm">
                   <div class="form-group">
                        <label for="title">책제목 :</label>
                        <input type="text" class="form-control" id="title" name="title"/>
                   </div>
                 <div class="form-group">
                          <label for="price">책가격 :</label>
                           <input type="text" class="form-control" id="price" name="price"/>
                  </div>
                <div class="form-group">
                             <label for="name">책저자 :</label>
                              <input type="text" class="form-control" id="name" name="name"/>
                </div>
               <div class="form-group">
                            <label for="page">책페이지 :</label>
                            <input type="text" class="form-control" id="page" name="page"/>
                 </div>
                 <button type="button" onclick="goRegister()" class="btn btn-primary btn-sm">등록</button>
               </form>
            </div>
            <div class="card-footer">패스트캠퍼스_BE7_박매일</div>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

