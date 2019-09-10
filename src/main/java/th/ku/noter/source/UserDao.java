package th.ku.noter.source;

import th.ku.noter.source.DatabaseSource;
import th.ku.noter.databases.SqliteConnector;
import th.ku.noter.source.User;

public class UserDao extends DatabaseSource {

    public UserDao() {
        super(SqliteConnector.getInstance() , "User");
    }

    public User get(String email){

        return null;

    }

    public void update(){

    }

    public void delete(){

    }

    public boolean validate(String password){
        return false;
    }

}
