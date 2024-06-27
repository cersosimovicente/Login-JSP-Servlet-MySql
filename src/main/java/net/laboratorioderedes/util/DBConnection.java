package net.laboratorioderedes.util;

import java.sql.Connection; //Importo la libreria del DriverManager
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Agustin USER
 */
public class DBConnection {
    private static BasicDataSource dataSource = null; //Realizo la implementación de una librería para crear un pool de conexiones
                                                      //La conexion la inicializo en null
    private static DataSource getDataSource(){
        if(dataSource == null){
            dataSource = new BasicDataSource(); //Creo una nueva base de conexiones
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //Asigno el driver de conexiones
            dataSource.setUsername("root"); //Declaro el nombre de usuario de la base de datos
            dataSource.setPassword("root"); //Declaro la constraseña de usuario de la base de datos
            dataSource.setUrl("jdbc:mysql://localhost:3306/customers?zeroDateTimeBehavior=CONVERT_TO_NULL"); //Declaro la base de datos a utilizar
            dataSource.setInitialSize(20); //Numero de conexiones que se deberan abrir al trabajar el pool
            dataSource.setMaxIdle(15); //Numero maximo de conexiones inactivas
            dataSource.setMaxTotal(20); //Numero maximo de conexiones que se pueden abrir
        }
        return dataSource; //Devuelve la base de datos
    }
    public static Connection getConnection() throws SQLException { //Metodo que devuelve la conexion
        return getDataSource().getConnection();
    }
}
