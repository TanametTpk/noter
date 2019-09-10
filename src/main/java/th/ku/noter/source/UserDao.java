package th.ku.noter;

import th.ku.noter.source.DatabaseSource;
import th.ku.noter.databases.SqliteConnector;

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
