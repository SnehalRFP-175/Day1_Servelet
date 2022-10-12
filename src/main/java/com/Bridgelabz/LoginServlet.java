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

@WebServlet(
        description = "Login servlet testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Snehal"),
                @WebInitParam(name = "password", value = "Snehal@123")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse respponse) throws ServletException, IOException {
        //get request parameters for username and password
        String username = request.getParameter("user");
        String password = request.getParameter("pwd");

        //get servlet config init params
        String userId = getServletConfig().getInitParameter("username");
        String pass = getServletConfig().getInitParameter("password");

        if (username.equals(userId) && password.equals(pass)){
            request.setAttribute("username", username);
            request.getRequestDispatcher("loginSuccess.jsp").forward(request,respponse);
        }else{
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out = respponse.getWriter();
            out.write("<font color=red> User name or password is wrong!.</font>");
            requestDispatcher.include(request, respponse);
            out.close();
        }
    }
}
