package first.dao;

import first.pojo.User;

public interface UserDao {
    //根据用户名查询用户信息
    public User queryUserByUsername(String username);
    //注册
    public int saveUser(User user);
    //登录
    public User queryUserByUserAndPassword(String username,String password);
}
