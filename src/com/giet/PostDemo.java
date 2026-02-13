package com.giet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PostDemo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("username");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Welcome " + name + "</h2>");
        out.println("<p>Your email: " + email + "</p>");
        out.println("</body></html>");
    }
}