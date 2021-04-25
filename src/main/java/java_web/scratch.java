package java_web;
import java.sql.*;
public class scratch{
    public static void main(String arges[])throws Exception{
        String query = "select username from request where id = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper", "root", "Phe6@nol");
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, 4);

        ResultSet rs = st.executeQuery();
        String u = "";
        rs.next();
         u  = rs.getString(1);
        System.out.println(u);
        st.close();
        con.close();
       
    }
}