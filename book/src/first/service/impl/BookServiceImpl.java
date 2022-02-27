package first.service.impl;

import first.dao.impl.BookDaoImpl;
import first.pojo.Book;
import first.pojo.Page;
import first.service.BookService;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDaoImpl bookDaoImpl=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDaoImpl.addBook(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookDaoImpl.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDaoImpl.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDaoImpl.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDaoImpl.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> bookPage = new Page<>();
        bookPage.setPageSize(pageSize);
        bookPage.setPageTotalCount(bookDaoImpl.queryForPageTotalCount());
        bookPage.setPageTotal(bookDaoImpl.queryForPageTotalCount()%pageSize>0?bookDaoImpl.queryForPageTotalCount()/pageSize+1:bookDaoImpl.queryForPageTotalCount()/pageSize);
        bookPage.setPageNo(pageNo);
        bookPage.setItems(bookDaoImpl.items(bookPage));
        return bookPage;
    }
    @Override
    public int queryForPageTotalCount() {
        return bookDaoImpl.queryForPageTotalCount();
    }

    @Override
    public Page<Book> queryBooksByPrice(BigDecimal low, BigDecimal high,int pageNo,int pageSize) {
        Page<Book> bookPage = new Page<>();
        bookPage.setPageSize(pageSize);
        bookPage.setPageTotalCount(bookDaoImpl.queryForPageTotalConntByPrice(low,high));
        bookPage.setPageTotal(bookDaoImpl.queryForPageTotalConntByPrice(low,high)%pageSize>0?bookDaoImpl.queryForPageTotalConntByPrice(low,high)/pageSize+1:bookDaoImpl.queryForPageTotalConntByPrice(low,high)/pageSize);
        bookPage.setPageNo(pageNo);
        bookPage.setItems(bookDaoImpl.queryBooksByPrice(bookPage,low,high));
        return bookPage;
    }
}
