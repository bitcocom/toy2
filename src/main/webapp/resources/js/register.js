// http://localhost:8081/toy2/api/books 연동하는 자바스크립트'
function goRegister(){
    // 폼데이터를 가지오는 부분 코드
      var title = document.getElementById('title').value;
      var price = parseInt(document.getElementById('price').value);
      var name = document.getElementById('name').value;
      var page = parseInt(document.getElementById('page').value);
      var formData = {
                  title: title,
                  price: price,
                  name: name,
                  page: page
       };
    fetch("http://localhost:8081/toy2/api/books",{
         method : "POST",
         headers : {  "Content-Type" : "application/json"   },
         body : JSON.stringify(formData)
      }).then(function(res){
          if(!res.ok){
               throw new Error("Network response was not ok"); // 에러?
          }
          // 에러가 없으면 리스트로 이동
          location.href="/toy2/ui/list";
       }).catch(function(error){   // Handle error
           console.error(error); // 에러 출력
       });
}
