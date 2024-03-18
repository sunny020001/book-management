package com.sunny.sun.bookManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.sun.bookManagement.controller.common.ResponseData;
import com.sunny.sun.bookManagement.model.Book;
import com.sunny.sun.bookManagement.services.IBooksService;

@RestController
public class bookController {

    @Autowired
    private IBooksService booksService;

    @PostMapping("book/create")
    public @ResponseBody ResponseData create(@ModelAttribute Book book){
        ResponseData responseData = ResponseData.ok();

        int result = booksService.insertBook(book);
        responseData.getData().put("result", result);

        return responseData;
    }

    @PutMapping("book/update/{id}")
    public @ResponseBody ResponseData update(@PathVariable("id") Integer id,@ModelAttribute Book book){
        ResponseData responseData = ResponseData.ok();

        int result = booksService.updateBookById(book);
        responseData.getData().put("result", result);

        return responseData;
    }

    @PostMapping("books")
    public @ResponseBody ResponseData selectAll(@RequestParam(value = "page", required = true, defaultValue = "1") Integer page,@RequestParam(value = "limit", required = true, defaultValue = "10") Integer limit,@RequestBody Book book){
        ResponseData responseData = ResponseData.ok();

        int count = booksService.selectCount(book);
        responseData.setCount(count);

        List<Book> books = booksService.selectAll(page,limit,book);
        responseData.getData().put("result", books);

        return responseData;
    }

    @GetMapping("book/{id}")
    public @ResponseBody ResponseData selectById(@PathVariable("id") Integer id){
        ResponseData responseData = ResponseData.ok();

        Book book = booksService.selectBookById(id);
        responseData.getData().put("result", book);

        return responseData;
    }

    @GetMapping("book/name/{name}")
    public @ResponseBody ResponseData selectByName(@PathVariable("name") String name){
        ResponseData responseData = ResponseData.ok();

        List<Book> book = booksService.selectBooksByTitle(name);
        responseData.getData().put("result", book);

        return responseData;
    }

    @DeleteMapping("book/{id}")
    public @ResponseBody ResponseData deleteById(@PathVariable("id") Integer id){
        ResponseData responseData = ResponseData.ok();

        int result = booksService.deleteBookById(id);
        responseData.getData().put("result", result);

        return responseData;
    }

}
