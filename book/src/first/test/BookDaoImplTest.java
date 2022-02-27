package first.test;

import first.dao.impl.BookDaoImpl;
import first.pojo.Book;
import first.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    private BookDaoImpl bookDao=new BookDaoImpl();
    @Test
    public void items() {
        Page<Book> bookPage = new Page<>();
        List<Book> items = bookDao.items(bookPage);
        System.out.println(items);
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageTotalConntByPrice() {
        System.out.println(bookDao.queryForPageTotalConntByPrice(new BigDecimal(5), new BigDecimal(50)));
    }
}