package first.dao;

import first.pojo.Book;
import first.pojo.Page;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {
    int updateBook(Book book);
    int deleteBookById(int id);
    int addBook(Book book);
    Book queryBookById(int id);
    List<Book> queryBooks();
    List<Book> items(Page<Book> page);
    int queryForPageTotalCount();
    int queryForPageTotalConntByPrice(BigDecimal low,BigDecimal high);
    List<Book> queryBooksByPrice(Page<Book> page,BigDecimal low,BigDecimal high);
}
