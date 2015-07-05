package com.fzzle.uad;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
        resp.getWriter().write("Hello!");
    }

}
