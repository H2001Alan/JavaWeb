package first.test;

import first.dao.impl.BookDaoImpl;
import first.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDaoImpl bookDao=new BookDaoImpl();
    @Test
    public void updateBook() {
        System.out.println(bookDao.updateBook(new Book(23, "唐诗三百首", "佚名", new BigDecimal(128), 100, 0, null)));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(22));
    }

    @Test
    public void addBook() {
        bookDao.addBook(new Book(0,"唐诗三百首","佚名",new BigDecimal(128),100,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(5));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookDao.queryBooks());
    }
}