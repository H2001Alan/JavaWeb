package first.test;

import first.pojo.User;
import first.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    UserServiceImpl userService=new UserServiceImpl();
    @Test
    public void registUser() {
        User user = new User(0,"狄仁杰","direnjie","direnjie@google.com");
        if (userService.registUser(user)>=1){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }
    }

    @Test
    public void login() {
        User login = userService.login(new User(0, "狄仁杰", "direnjie", "direnjie@google.com"));
        if(login!=null){
            System.out.println("登录成功");
        }else{
            System.out.println("登陆失败");
        }
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("李白")){
            System.out.println("用户名已存在");
        }
    }
}