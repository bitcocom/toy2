package com.example.controller;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import com.example.repository.BookMapper;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // JSON 응답 -> RESTful Service(GET, POST,PUT,DELETE)
@RequestMapping("/api")
public class SpringRestController {
    // GET :  http://localhost:8081/toy2/api/books -> 전체리스트
    // GET : http://localhost:8081/toy2/api/books/{id} -> 특정테이터 검색
    // POST : http://localhost:8081/toy2/api/books -> 등록(DTO)
    // PUT:  http://localhost:8081/toy2/api/books/{id} -> 수정(DTO) -> id=3, ..... 수정
    // DELETE :  http://localhost:8081/toy2/api/books/{id} -> 삭제
    @Autowired
    private BookService service;

    //@CrossOrigin
    @GetMapping("/books") // 전체리스트
    public  ResponseEntity<List<BookDTO>>   bookList(){
       List<BookDTO> list= service.bookList();
        //return list;  // JSON, 상태정보, 메세지
        return new ResponseEntity<>(service.bookList(), HttpStatus.OK); // 200 OK.
    }
    @GetMapping("/books/{num}") // 특정테이터 검색
    public ResponseEntity<BookDTO> view(@PathVariable int num){
        BookDTO dto=service.getByNum(num);
        //return dto;
        return new ResponseEntity<>(service.getByNum(num), HttpStatus.OK); // 200 OK.
    }

    @PostMapping("/books") // JSON 문자열
    public int register(@RequestBody BookDTO dto){
          return service.bookInsert(dto);
    }

    @PutMapping("/books/{num}")
    public int update(@PathVariable int num,  @RequestBody BookDTO dto){
          return service.bookUpdate(dto);
    }

    @DeleteMapping("/books/{num}")
    public int delete(@PathVariable int num){
        return service.bookDelete(num);
    }
}
