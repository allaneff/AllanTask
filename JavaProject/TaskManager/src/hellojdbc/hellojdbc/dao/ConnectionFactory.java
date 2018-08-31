package hellojdbc.hellojdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//Responsável por abrir uma conexão com o banco.
public class ConnectionFactory {

    private static final String stringConexao = "jdbc:mysql:/127.0.0.1/localhost:3306/ALLANTASK";
    private static final String usuarioBD = "root";
    private static final String senhaBD = "root123";

    public Connection getConnection(){
        try{
            return DriverManager.getConnection(stringConexao,usuarioBD,senhaBD);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
