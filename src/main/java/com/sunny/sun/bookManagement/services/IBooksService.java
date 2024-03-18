package com.sunny.sun.bookManagement.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.sunny.sun.bookManagement.model.Book;

public interface IBooksService {
    List<Book> selectAll(Integer page,Integer limit,Book book) throws DataAccessException;
    int selectCount(Book book) throws DataAccessException;
    Book selectBookById(Integer id) throws DataAccessException;
    List<Book> selectBooksByTitle(String title) throws DataAccessException;

    int insertBook(Book book) throws DataAccessException;
    int updateBookById(Book book) throws DataAccessException;
    int deleteBookById(@Param("id") Integer id) throws DataAccessException;
}
