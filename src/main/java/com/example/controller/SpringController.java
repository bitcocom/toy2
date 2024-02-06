package com.example.controller;


import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class SpringController { // View페이지로 이동하는 컨트롤러 역학

    //@Autowired
    //private BookService bookService; // BookService(interface)-->BookServiceImpl
    @RequestMapping("/list") // http://localhost:8081/toy2/ui/list
    public String list(){  //                                                    javascript(ajax, fetch) -> jQuery(API), 바닐라자바스크립트
        return "list"; // /WEB-INF/books/list.jsp --> [Restful API 요청 -> 책리스트를 가지고와서 -> 동적View생성]
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
