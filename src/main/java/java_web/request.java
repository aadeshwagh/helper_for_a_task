package java_web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/request")
public class request extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        String city, task;
        long mo_no;
        int cost;

        String user = (String) req.getSession(false).getAttribute("username");
        if (user == null) {
            try {
                res.sendRedirect("index.html");
            } catch (Exception e) {
                System.out.println("error");
            }
        } else {
            String ci = req.getParameter("city");
            task = req.getParameter("task");
            cost = Integer.parseInt(req.getParameter("cost"));
            mo_no = Long.parseLong(req.getParameter("mo_no"));

            city = ci.toLowerCase();
            try {
                register_req(city, task, cost, mo_no, user);
                res.sendRedirect("request.html");
            } catch (Exception e) {
                System.out.println("Fuck!");
            }

            // delete_req(id);

        }
    }

    void register_req(String city, String task, int cost, long mo_no, String user) throws Exception {
        String query = "insert into request(city , task ,mo_no ,cost ,username) values(?,?,?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper", "<username>", "<Password>");
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, city);
        st.setString(2, task);
        st.setInt(4, cost);
        st.setLong(3, mo_no);
        st.setString(5, user);
        st.executeUpdate();
        st.close();
        con.close();
    }

}
