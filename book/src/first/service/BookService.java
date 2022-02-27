package first.service;

import first.pojo.Book;
import first.pojo.Page;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    void deleteBookById(int id);
    void updateBook(Book book);
    Book queryBookById(int id);
    List<Book> queryBooks();
    Page<Book> page(int pageNO, int pageSize);
    int queryForPageTotalCount();
    Page<Book> queryBooksByPrice(BigDecimal low,BigDecimal high,int pageNo,int pageSize);
}
