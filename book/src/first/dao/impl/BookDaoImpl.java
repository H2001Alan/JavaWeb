package first.dao.impl;

import first.dao.BookDao;
import first.pojo.Book;
import first.pojo.Page;
import org.apache.taglibs.standard.tag.common.fmt.BundleSupport;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set `name`=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public int deleteBookById(int id) {
        String sql="delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int addBook(Book book) {
        String sql="insert into t_book(`name`,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public Book queryBookById(int id) {
        String sql="select id,`name`,price,author,sales,stock,img_path from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select id,`name`,price,author,sales,stock,img_path from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public List<Book> items(Page<Book> page) {
        int begin=(page.getPageNo()-1)*page.getPageSize();
        String sql1="select id,`name`,price,author,sales,stock,img_path from t_book limit ?,?";
        return queryForList(Book.class,sql1,begin,page.getPageSize());
    }
    @Override
    public int queryForPageTotalCount() {
        String sql="select count(*) from t_book";
        Number count= (Number)queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public int queryForPageTotalConntByPrice(BigDecimal low, BigDecimal high) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number count=(Number)queryForSingleValue(sql,low,high);
        return count.intValue();
    }

    @Override
    public List<Book> queryBooksByPrice(Page<Book> page,BigDecimal low, BigDecimal high) {
        int begin=(page.getPageNo()-1)*page.getPageSize();
        String sql="select id,`name`,price,author,sales,stock,img_path from t_book where price between ? and ? limit ?,?";
        return queryForList(Book.class,sql,low,high,begin,page.getPageSize());
    }
}
