package hellojdbc;

import hellojdbc.hellojdbc.dao.ConnectionFactory;

import java.sql.*;

public class Main {
    public static void main(String[]args){


        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement ps = con.prepareStatement("insert into at_user(name,password) values('Tom','Senha123')");

            ps.execute();

            PreparedStatement sp = con.prepareStatement("select user_id, name, password from user");

            ResultSet rs = sp.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
            }

            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
