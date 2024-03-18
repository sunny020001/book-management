package com.sunny.sun.bookManagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.sunny.sun.bookManagement.model.Book;

import java.util.List;
import java.util.Map;

@Mapper
public interface IBooksMapper {

    List<Book> selectAll(Map<String,Object> params) throws DataAccessException;
    int selectCount(Book book) throws DataAccessException;
    Book selectBookById(@Param("id") Integer id) throws DataAccessException;

    List<Book> selectBooksByTitle(String title) throws DataAccessException;

    int insertBook(Book book) throws DataAccessException;
    int updateBookById(Book book) throws DataAccessException;
    int deleteBookById(@Param("id") Integer id) throws DataAccessException;
}
