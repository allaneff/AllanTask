package hellojdbc.hellojdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String stringConexao = "jdbc:mysql://localhost:3306/ALLANTASK";
    private static final String usuarioBD = "root";
    private static final String senhaBD = "univille";

    public Connection getConnection{
        try{
            return DriverManager
                    .getConnection(stringConexao
                            ,usuarioBD, senhaBD)
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
