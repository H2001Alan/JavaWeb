package first.web;

import first.pojo.Book;
import first.pojo.Page;
import first.service.impl.BookServiceImpl;
import first.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import static java.lang.Integer.parseInt;

public class BookServlet extends BaseServlet{
    private BookServiceImpl bookService=new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),5000);
        Book book=new Book();
        WebUtils.copyParamTOBean(req.getParameterMap(),book);
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=pageBooks&pageNo="+pageNo);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),5000);
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=pageBooks&pageNo="+pageNo);
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        WebUtils.copyParamTOBean(req.getParameterMap(),book);
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=pageBooks&pageNo="+req.getParameter("pageNo"));
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询全部图书信息
        List<Book> books = bookService.queryBooks();
        //将所有图书信息保存到request域中，供manager.jsp展示
        req.setAttribute("key",books);
        //请求转发至manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt (req.getParameter("id"));
        Book book = bookService.queryBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    public void pageBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo =WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize =WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page=bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=pageBooks");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
