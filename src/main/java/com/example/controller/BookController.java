package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookMapper;
import com.example.service.BookService;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller // Spring에서 POJO를 나타내기위해서사용하는 어노테이션
public class BookController {   // new BookController() : Spring Container

    //@Autowired  // DI(의존성 주입)
    //private BookMapper mapper; // new SqlSessionFactoryBean()<--implements BookMapper
     // http://localhost:8081/shopping/list -> GET
    @Autowired
    private BookService service;
     @GetMapping("/list")
     public String list(Model model){ // HttpServletRequest req
         List<BookDTO> list=service.bookList();
         model.addAttribute("list", list);
         return "list"; // /WEB-INF/views/list.jsp <--- ${list}
     }
    @GetMapping("/delete/{num}") // /delete/5
    public String delete(@PathVariable int num){
        // int num=Integer.parseInt(req.getParameter("num"));
         int cnt=service.bookDelete(num);
         return "redirect:/list";
     }
     @GetMapping("/register") //GET
    public String registerGet(){
         return "register";
     }

    @PostMapping("/register") //POST                    { "title":"자바","price":30000,.....} -> JSON 문자열
    public String registerPost(BookDTO dto){ // 파라메터수집 완료
          int cnt=service.bookInsert(dto);
         return "redirect:/list";
    }

    @GetMapping("/ajaxList")
    public @ResponseBody List<BookDTO> ajaxList(){
           List<BookDTO> list=service.bookList();
           return list; // JSON 문자열 [{       },{      },.....]
    }

    @GetMapping("/view/{num}")
    public String view(Model model, @PathVariable int num){
          BookDTO dto=service.getByNum(num);
          model.addAttribute("dto", dto);
          return "view"; // view.jsp(상세보기 페이지)   -> ${dto~}
    }
    @PostMapping("/update")
    public String update(BookDTO dto){
       int cnt=service.bookUpdate(dto);
       return "redirect:/list";
    }

}

