package com.Bridgelabz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "snehal"),
                @WebInitParam(name = "password", value = "Snehal@123")
        }
)
public class LoginServlet extends HttpServlet {
    private String validName = "[A-Z][a-z]{2,}";
    private String ValidPass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=[^@#$%^&*+=].{8,}$";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get request parameters for username and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");



        //get servlet config init params
        String userId = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if (user.matches(validName) && password.matches(ValidPass))
        {
            if (user.equals(user) && userId.equals(user) && password.equals(pwd)){
                request.setAttribute("user", user);
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
            }
            else{
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
                PrintWriter out = response.getWriter();
                out.write("<font color=red> User name or password is wrong!.</font>");
                requestDispatcher.include(request, response);
                out.close();
            }
        }
        else
        {
            PrintWriter out = response.getWriter();
            out.write("<font color=red>Enter Valid User Name or Valid Password....</font>");
        }

    }
}





