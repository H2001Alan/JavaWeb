package first.service;

import first.dao.impl.UserDaoImpl;
import first.pojo.User;

public interface UserService {
    //注册
    public int registUser(User user);
    //登录
    public User login(User user);
    //验证用户名是否存在
    public boolean existUsername(String username);
}
