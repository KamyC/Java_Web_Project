package webservlet;
import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.IUserviceImpl;
import serviceimpl.IUserService;
import utils.FormValidate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "signUpServe")
public class signUpServe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> userInfo=request.getParameterMap();
        FormValidate fv=new FormValidate();
        try {
            BeanUtils.populate(fv,userInfo);
            if(!fv.validate()){
                RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");
                request.setAttribute("fv",fv);
                rd.forward(request,response);
            }
            else{
                /* check if there are repeated username*/
                String inputName=fv.getUsername();
                IUserviceImpl userService=new IUserviceImpl();
                if(userService.repeatUser(inputName)){
                    System.out.println("存在");
                    RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");
                    request.setAttribute("message","user already exists");
                    rd.forward(request,response);
                }else{
                    /*save into database*/
//                    System.out.println("不存在");
                    User user=new User();
                    user.setUsername(request.getParameter("username"));
                    user.setPassword(request.getParameter("password"));
                    user.setEmail(request.getParameter("email"));

                    userService.signUp(user);
                    /*jump to login page*/
                    RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                    request.setAttribute("signup_success","sign up success");
                    rd.forward(request,response);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("signUp.jsp");
        rd.forward(request,response);
    }
}
