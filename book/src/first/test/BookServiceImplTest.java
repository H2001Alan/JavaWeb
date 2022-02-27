package first.test;

import first.pojo.Book;
import first.pojo.Page;
import first.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    private BookServiceImpl bookService=new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(0,"狂人日记","鲁迅",new BigDecimal(20),1000,50,null));
    }
    @Test
    public void deleteBookById() {
        bookService.deleteBookById(4);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24,"朝花夕拾","鲁迅",new BigDecimal(20),1000,50,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(24));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book:books){
            System.out.println(book);
        }
    }
    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page.getItems());
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookService.queryForPageTotalCount());
    }

    @Test
    public void queryBooksByPrice() {
        Page<Book> bookPage = bookService.queryBooksByPrice(new BigDecimal(10), new BigDecimal(100), 1, 4);
        System.out.println(bookPage.getItems());
    }
}