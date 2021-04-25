package java_web;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/apply")
public class apply extends HttpServlet {

    public int rq_id ;
    public String user_name;


    public String get_user(int rq_id)throws Exception{

       

        String query = "select username from request where id = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper", "root", "Phe6@nol");
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, rq_id);

        ResultSet rs = st.executeQuery();
        String u = "";
        rs.next();
         u  = rs.getString(1);
        
        st.close();
        con.close();
        return u;
    }
    
        
   
    public void service (HttpServletRequest req , HttpServletResponse res) {
        String user_n =(String) req.getSession(false).getAttribute("username");
       
        if(user_n==null){
            try{
                res.sendRedirect("index.html");
            }catch(Exception e){
                System.out.println("error");
            }
        }
        else{
            
           
            rq_id = Integer.parseInt(req.getParameter("id"));
            System.out.println(rq_id);
            String name = req.getParameter("name");
            long mo_no = Long.parseLong(req.getParameter("mo_no"));
            String message = req.getParameter("message");
            try{
            user_name = get_user(rq_id);
            update_aplicant(rq_id ,name,mo_no ,user_name ,message);
            res.sendRedirect("Home.jsp");
            
            }catch(Exception e){
               System.out.println("error");;
            }
            
        }
    }


    void update_aplicant(int rq_id , String name ,long mo_no ,String user ,String message)throws Exception{
        String query = "insert into applicants(id , name ,mo_no ,message ,username) values (?,?,?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper", "root", "Phe6@nol");
        PreparedStatement st = con.prepareStatement(query);
        st.setString(5, user);
        st.setString(2, name);
        st.setInt(1, rq_id);
        st.setLong(3, mo_no);
        st.setString(4, message);
        st.executeUpdate();
        st.close();
        con.close();
    }
}
