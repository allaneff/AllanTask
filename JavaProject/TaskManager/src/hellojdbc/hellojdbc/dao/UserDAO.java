package hellojdbc.hellojdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

    //Insere um usuario
    public void insert(User user){
        try{
            Connection conn = (new ConnectionFactory().getConnection();

            Statament stat = conn.createStatemente();
            stat.execute("delete from user");
            //fecha a conexao com o banco de dados
            stat.close();
            conn.close();
            {
            }
        }catch(Exception e){

    }
    // Excluir todos os registros da tabela
    public void deleteALL(){
        try{
            Connection conn = (new ConnectionFactory().getConnection();
            PreparedStatement p=
                    conn.prepareStatement("insert into user(name,password) values(? ?)");
            p.setString(1,user.getName());
            p.setString(2,user.getPassword());

            p.execute();
            p.close();

            Statament stat = conn.createStatemente();
            stat.execute("delete from user");
            //fecha a conexao com o banco de dados
            stat.close();
            conn.close();
            {
            })
        }catch(Exception e){

        }
    }
}
