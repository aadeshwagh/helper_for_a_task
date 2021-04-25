package java_web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/logout")
public class logout extends HttpServlet{
    public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException{
        HttpSession session = req.getSession(false);
        session.invalidate();
        res.sendRedirect("index.html");  

    } 
}
