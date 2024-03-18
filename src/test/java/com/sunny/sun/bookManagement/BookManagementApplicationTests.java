package com.sunny.sun.bookManagement;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sunny.sun.bookManagement.mapper.IBooksMapper;
import com.sunny.sun.bookManagement.model.Book;

@SpringBootTest
class BookManagementApplicationTests {

	@Autowired
	IBooksMapper booksMapper;

	@Autowired
	DataSource dataSource;

	@Test
	void dataSource() throws SQLException{
		System.out.println(dataSource.getConnection());
	}

	@Test
	void selectBookById(){
		Book book = booksMapper.selectBookById(1);
		assertNull(book);
	}

	@Test
	void selectBooksByTitle(){
		List<Book> books= booksMapper.selectBooksByTitle("高等");
		assertNull(books);
	}

}
