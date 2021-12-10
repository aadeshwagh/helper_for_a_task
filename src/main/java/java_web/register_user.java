package java_web;

import java.sql.*;

public class register_user {
    register_user(String name, String username, String pass, long contact) throws Exception {
        String quory = "insert into users(name,username,pass,contact) values('" + name + "','" + username + "','" + pass
                + "'," + contact + ")";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper", "<username>", "<Password>");
        Statement st = con.createStatement();
        st.executeUpdate(quory);
        st.close();
        con.close();

    }
}
