package service;

import daoimpl.IUserDaoImpl;
import model.User;
import serviceimpl.IUserService;
import utils.UserException;

public class IUserviceImpl implements IUserService {
    private IUserDaoImpl userDao=new IUserDaoImpl();
    @Override
    public void signUp(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User login(String name, String password) throws UserException {
        if(userDao.findUser(name,password)!=null){
            return userDao.findUser(name,password);
        }else{
            throw new UserException("user not exist");
        }
    }
    public boolean repeatUser(String name){
        return userDao.repeatUser(name);
    }
}
