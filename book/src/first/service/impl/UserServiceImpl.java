package first.service.impl;

import first.dao.UserDao;
import first.dao.impl.UserDaoImpl;
import first.pojo.User;
import first.service.UserService;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDaoImpl=new UserDaoImpl();

    @Override
    public int registUser(User user) {
        return userDaoImpl.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDaoImpl.queryUserByUserAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        User user = userDaoImpl.queryUserByUsername(username);
        if (user==null){
            return false;
        }else{
            return true;
        }
    }
}
