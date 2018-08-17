import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[]args){
        String stringConexao = "jdbc:mysql://localhost:3306/?";
        String nomeBancoDeDados = ""; // nome do banco de dados que foi criado no sqlworband -- baixar mysql-java-8.0.12, pasta libs
        String usuarioBD = "";
        String senhaBD = "";
        try{
            Connection conn = DriverManager
                    .getConnection(String.format(stringConexao, nomeBancoDeDados),usuarioBD,senhaBD);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
