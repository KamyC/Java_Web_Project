package serviceimpl;

import model.User;
import utils.UserException;

public interface IUserService {
    public void signUp(User user);
    public User login(String name, String password) throws UserException;
}
