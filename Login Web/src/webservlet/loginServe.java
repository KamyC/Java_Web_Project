package webservlet;

import service.IUserviceImpl;
import serviceimpl.IUserService;
import utils.UserException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServe")
public class loginServe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        IUserviceImpl userService=new IUserviceImpl();
        try{
            try{
                userService.login(username,password);
                request.setAttribute("message","Login Success");
                request.setAttribute("username",username);

                RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
                rd.forward(request,response);
            }catch (UserException e){
                e.printStackTrace();
                request.setAttribute("message","User Does Not Exist");
                RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                rd.forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Close browser, then reopen it, redirect to log in page*/
        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        rd.forward(request,response);
    }
}
