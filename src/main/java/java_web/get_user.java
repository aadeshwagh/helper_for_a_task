package java_web;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/register")
public class get_user extends HttpServlet{
    public void service(HttpServletRequest req , HttpServletResponse res){
        String name, username ,pass ;
        
        long contact;

        
        name = req.getParameter("name");
        username = req.getParameter("username");
        pass = req.getParameter("password");
        

        contact = Long.parseLong(req.getParameter("contact"));
       
        try{
        new register_user(name,username,pass,contact);
        res.sendRedirect("index.html");;
        }catch(Exception e){
            e.printStackTrace();
        }

        
    }
    
}
