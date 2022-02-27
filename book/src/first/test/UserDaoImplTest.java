package first.test;

import first.dao.impl.UserDaoImpl;
import first.pojo.User;
import org.junit.Test;

public class UserDaoImplTest {
    @Test
    public void queryUserByUsername() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.queryUserByUsername("李白");
        if (user!=null){
            System.out.println("用户名可用！");
        }else{
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void saveUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user=new User(20,"韩信","hanxin","hanxin@qq.com");
        System.out.println(userDao.saveUser(user));
    }

    @Test
    public void queryUserByUserAndPassword() {
        UserDaoImpl userDao = new UserDaoImpl();
        if (userDao.queryUserByUserAndPassword("李白","libai")!=null){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
