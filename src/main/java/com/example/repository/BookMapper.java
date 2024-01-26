package com.example.repository;

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;

import java.util.List;

//@Mapper
//@Repository
public interface BookMapper { // SqlSessionFactoryBean
    public List<BookDTO> bookList();
    public int bookInsert(BookDTO book);
    public UserDTO userLogin(UserDTO dto);
    public int bookDelete(int num);
    public BookDTO getByNum(int num);
    public int bookUpdate(BookDTO dto);
}

