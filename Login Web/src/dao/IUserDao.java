package dao;

import model.User;

public interface IUserDao {
    public void insertUser(User user);
    public User findUser(String name,String password);
}
