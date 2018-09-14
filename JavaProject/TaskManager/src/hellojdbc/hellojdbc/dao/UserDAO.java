package hellojdbc.hellojdbc.dao;

import hellojdbc.hellojdbc.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO{


    public void insert(User user){


        try(
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into user(name,password) values(?,?)")
        ){

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.execute();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public List<User> getAll(){
        List<User> list = new ArrayList<>();

        try(
                Connection connection = getConnection();
                Statement statement = connection.createStatement()
        )
        {
            ResultSet resultSet = statement.executeQuery("select user_id,name,password from user");

            while(resultSet.next()){

                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                list.add(user);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return list;
    }


    public User getById(long id){
        User user = null;

        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("select user_id,name,password from user where user_id = ?")
        ){

            statement.setLong(1,id);


            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return user;
    }

    public User getByName(String name){
        User user = null;

        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("select user_id,name,password from user where name = ?")
        )
        {

            statement.setString(1,name);

            ResultSet resultSet = statement.executeQuery();


            while(resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return user;
    }

}