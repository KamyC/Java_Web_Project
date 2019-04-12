package daoimpl;

import dao.IUserDao;
import model.User;
import utils.DBUltis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IUserDaoImpl implements IUserDao {
    @Override
    public void insertUser(User user) {
        Connection connection=null;
        try{
            connection=DBUltis.startConnect();
            String sql="insert into users.t_user values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getId());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getEmail());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUltis.disConnect(connection,null,null);
        }
    }

    @Override
    public User findUser(String name, String password) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=null;
        try{
            connection=DBUltis.startConnect();
            String sql="select * from users.t_user where username=? and password=?";
            ps=  connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while(rs.next()){
                user=new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUltis.disConnect(connection,ps,rs);
        }
        return user;
    }

    public boolean repeatUser(String name){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            connection=DBUltis.startConnect();
            String sql="select * from users.t_user where username=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
//    public static void main(String[] args){
//        User user=new User();
//        user.setUsername("JimCC");
//        user.setPassword("4255225");
//        user.setEmail("34077@qq.com");
//        IUserDaoImpl userDao=new IUserDaoImpl();
//        userDao.insertUser(user);
//    };
}
