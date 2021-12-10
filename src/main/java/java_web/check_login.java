package java_web;

import java.sql.*;

public class check_login {
    check_login() {
    }

    boolean check(String user, String pass) throws Exception {
        String quory = "select * from users where username = ? and pass = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper", "<username>", "<Password>");
        PreparedStatement st = con.prepareStatement(quory);
        st.setString(1, user);
        st.setString(2, pass);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }

    }
}
