import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[]args){
        String stringConexao = "jdbc:mysql://localhost:3306/ALLANTASK";
        String nomeBancoDeDados = "";
        String usuarioBD = "root";
        String senhaBD = "univille";
        try{
            Connection conn = DriverManager
                    .getConnection(String.format(stringConexao
                            ,usuarioBD,senhaBD));
        Statament stat = conn.createStatement();
        stat.execute();
        PreparedStatement p=
            conn.prepareStatement("insert into user(name,password) values(? ?)");
        p.setString(1,"Tom");
        p.setString(2,"Senha123");

        p.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
