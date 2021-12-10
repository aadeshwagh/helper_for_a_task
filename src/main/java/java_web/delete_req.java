package java_web;

import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/accept")
public class delete_req extends HttpServlet {
    public String user_name;
    String name1;

    public void service(HttpServletRequest req, HttpServletResponse res) {
        user_name = (String) req.getSession(false).getAttribute("username");
        name1 = req.getParameter("name");
        try {
            del_req();
            res.sendRedirect("applications.jsp");
        } catch (Exception e) {
            System.out.println("Error in delete_req");
        }

    }

    public void del_req() throws Exception {
        String query1 = "delete from request where username = ?";
        String query2 = "insert into apporoved select * from applicants where username = ? and name = ?";
        String query3 = "delete from applicants where username = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper", "<username>", "<Password>");
        PreparedStatement st1 = con.prepareStatement(query2);
        st1.setString(1, user_name);
        st1.setString(2, name1);
        System.out.println(name1);
        PreparedStatement st2 = con.prepareStatement(query1);
        st2.setString(1, user_name);
        PreparedStatement st3 = con.prepareStatement(query3);
        st3.setString(1, user_name);

        st1.executeUpdate();
        st2.executeUpdate();
        st3.executeUpdate();

        con.close();

    }
}
