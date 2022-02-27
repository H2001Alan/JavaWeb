package first.web;

import com.google.gson.Gson;
import first.pojo.User;
import first.service.UserService;
import first.service.impl.UserServiceImpl;
import first.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet{
    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User login = userService.login(new User(0, username, password, null));
        if (login != null) {
            //保存用户登录之后的信息
            req.getSession().setAttribute("user",login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "账号名或密码错误");
            req.setAttribute("username", username);
            System.out.println("账号或密码错误");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        User user = new User();
        WebUtils.copyParamTOBean(req.getParameterMap(),user);
        //检查验证码
        if (token!=null&&token.equalsIgnoreCase(code)) {
            if (!userService.existUsername(user.getUsername())) {
                userService.registUser(new User(0, user.getUsername(),user.getPassword(),user.getEmail()));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            } else {
                req.setAttribute("email", user.getEmail());
                req.setAttribute("msg","用户名已存在!");
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email",user.getEmail());
            req.setAttribute("msg","验证码错误!");
            //通过请求转发，跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
    public void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HashMap<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        boolean b = userService.existUsername(username);
        map.put("exist", b);
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }
}