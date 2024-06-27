package net.laboratorioderedes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.laboratorioderedes.bean.LoginBean;
import net.laboratorioderedes.util.DBConnection;

/**
 *
 * @author cerso
 */
public class LoginDaoImpl implements LoginDao {

    @Override
    public String authenticateUser(LoginBean loginBean) {

        Connection connection; //Declaro una variable tipo conexion
        PreparedStatement statement; //Declaro una variable para ejecutar sentencias SQL con parametros de entrada.
        boolean estado;

        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";
        String roleDB = "";

        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement("select username,password,role from users");
            resultSet = preparedStatement.executeQuery();
       
            while (resultSet.next()) {
                userNameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role");
//                
//                System.out.println(userNameDB);
//                System.out.println(passwordDB);
//                System.out.println(roleDB);

                if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin")) {
                    return "Admin_Role";
                } else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor")) {
                    return "Editor_Role";
                } else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User")) {
                    return "User_Role";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }

}


