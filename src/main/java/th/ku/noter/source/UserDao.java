package th.ku.noter.source;

import th.ku.noter.source.DatabaseSource;
import th.ku.noter.databases.SqliteConnector;
import th.ku.noter.source.User;

import java.sql.PreparedStatement;

public class UserDao extends DatabaseSource{

    public static final UserDao instance = new UserDao();

    private UserDao() {
        super(SqliteConnector.getInstance() , "User");
    }

    public void create(User user){

    }

    public User getById(String id){

        return null;

    }

    public User getByEmail(String email){

        return null;

    }

    public void update(User user){

    }

    public void delete(){

    }

}
