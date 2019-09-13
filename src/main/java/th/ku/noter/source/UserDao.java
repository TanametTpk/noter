package th.ku.noter.source;

import th.ku.noter.source.DatabaseSource;
import th.ku.noter.databases.SqliteConnector;
import th.ku.noter.source.User;

import java.sql.PreparedStatement;

public class UserDao extends DatabaseSource{

    public UserDao() {
        super(SqliteConnector.getInstance() , "User");
    }

    public void create(User user){

    }

    public User get(String email){

        return null;

    }

    public void update(User user){

    }

    public void delete(){

    }

}
