package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        System.out.println(uname + "," + pwd);
        User u = service.getOne(uname);
        if (u == null){
            resp.getWriter().write("2");
        }else {
            if (u.getPassword().equals(pwd)){
                resp.getWriter().write("1");
            }else {
                resp.getWriter().write("3");
            }
        }

    }
}
