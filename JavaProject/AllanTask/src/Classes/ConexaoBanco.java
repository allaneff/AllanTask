package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fábrica de Conexoes com o Banco Mysql
 */
public class ConexaoBanco {

    private final static String dataBaseName = "AllanTask";
    private final static String dataBaseUser = "root";
    private final static String dataBasePassword = "univille123";
    private final static String dataBaseServer = "jdbc:mysql://localhost/";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(dataBaseServer + dataBaseName + "?autoReconnect=true&useSSL=false",dataBaseUser,dataBasePassword);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
