// http://localhost:8081/toy2/api/books 연동하는 자바스크립트'

function list(){
    //$.ajax(); jQuery API
    fetch("http://localhost:8081/toy2/api/books",{
         method : "GET"
      }).then(function(res){ // res -> JSON String -> JSON Object -> obj.
          // console.log(1, res);
          if(!res.ok){
               throw new Error("Network response was not ok"); // 에러?
          }
          return res.json(); // JSON Object -> [ {     }, {     }, {     }......   ]
       }).then(function(books){
           console.log(2, books); // [ {     }, {     }, {     }......   ]
           // 동적인 뷰를 생성하는 작업 : HTML
          var bookList=document.getElementById("bookList"); // <div>
          bookList.innerHTML=''; // clear

          books.forEach(function(book){
              var card=document.createElement("div");
              card.classList.add('col-md-3','mb-3');
              card.innerHTML=`
                     <div class="card">
                       <div class="card-body">
                           <h5 class="card-title">${book.title}</h5>
                          <p class="card-title">책번호: ${book.num}</p>
                          <p class="card-title">가격: ${book.price}</p>
                          <a href="#" class="btn btn-primary btn-sm">상세보기</a>
                       </div>
                      </div>
              `; // HTML+DATA출력(${ })
              bookList.appendChild(card)
          });
       });
}
