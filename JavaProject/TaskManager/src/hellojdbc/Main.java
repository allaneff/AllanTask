import java.sql.*;

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
        p.close();

        Statament query = conn.createStatement();

        resultSet result = ((Statement) query).executeQuery("select user_id, name, password from user");
        while(((ResultSet) result).next()){
            long userId = result.getLong(1);
            String name = result.getString(2);
            String password = result.getString(3);
            System.out.println(userId+" "+name+" "+password);

        }

        //Fecha a conexão de bancos de dados
         p.close();   

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
