package com.sunny.sun.bookManagement.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sunny.sun.bookManagement.mapper.IBooksMapper;
import com.sunny.sun.bookManagement.model.Book;
import com.sunny.sun.bookManagement.services.IBooksService;

import jakarta.annotation.Resource;

@Service("booksService")
public class BooksServiceImpl implements IBooksService{

    @Resource
    private IBooksMapper booksMapper;

    @Override
    public Book selectBookById(Integer id) throws DataAccessException {
        return booksMapper.selectBookById(id);
    }

    @Override
    public List<Book> selectBooksByTitle(String title) throws DataAccessException {
        return booksMapper.selectBooksByTitle(title);
    }

    @Override
    public int insertBook(Book book) throws DataAccessException {
        return booksMapper.insertBook(book);
    }

    @Override
    public int updateBookById(Book book) throws DataAccessException {
        int result = 0;
        try {
            result = booksMapper.updateBookById(book);
        } catch (DataAccessException e) {
            result = -1;
        }
        return  result;
    }

    @Override
    public int deleteBookById(Integer id) throws DataAccessException {
        return booksMapper.deleteBookById(id);
    }

    @Override
    public List<Book> selectAll(Integer page,Integer limit,Book book) throws DataAccessException {
        int offset = (page - 1) * limit;
        Map<String,Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("limit", limit);
        params.put("id", book.getId());
        params.put("title", book.getTitle());
        return booksMapper.selectAll(params);
    }

    @Override
    public int selectCount(Book book) throws DataAccessException {
        return booksMapper.selectCount(book);
    }
}
