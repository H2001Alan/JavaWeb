package first.web;

import first.pojo.Book;
import first.pojo.Page;
import first.service.BookService;
import first.service.impl.BookServiceImpl;
import first.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class ClientBookServlet extends BaseServlet{
    private BookService bookService=new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    public void pageBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize =WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page=bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=pageBooks");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
    public void queryBooksByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize =WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        BigDecimal low=WebUtils.parseBigDecimal(req.getParameter("min"),new BigDecimal(0));
        BigDecimal high=WebUtils.parseBigDecimal(req.getParameter("max"),new BigDecimal(Integer.MAX_VALUE));
        Page<Book> page=bookService.queryBooksByPrice(low,high,pageNo, pageSize);
        StringBuilder sb=new StringBuilder("client/bookServlet?action=queryBooksByPrice");
        if (req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
