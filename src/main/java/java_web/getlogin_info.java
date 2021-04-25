package java_web;


import java.io.IOException;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/login")
public class getlogin_info extends HttpServlet {
    public void service(HttpServletRequest req , HttpServletResponse res)throws IOException{
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        
         res.setContentType("text/html");
         
        try{

        check_login c = new check_login();
        boolean b = c.check(user, pass);
        if(b==true){
          HttpSession session = req.getSession(true);
          session.setAttribute("username", user);
          res.sendRedirect("Home.jsp");

        }
        if(b == false){
            res.sendRedirect("index.html"); 
            
        }
        
        }catch(Exception e){
            System.out.println("Error");
        }
        
    }
}
