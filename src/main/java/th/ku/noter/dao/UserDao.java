package th.ku.noter.dao;

import th.ku.noter.databases.UpdateType;
import th.ku.noter.source.DatabaseSource;
import th.ku.noter.databases.SqliteConnector;
import th.ku.noter.source.Queriable;
import th.ku.noter.source.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends DatabaseSource{

    public static final UserDao instance = new UserDao();

    private UserDao() {
        super(SqliteConnector.getInstance() , "User");
    }

    public void create(User user) throws SQLException {
        List<Queriable> dummy = new ArrayList<>();
        dummy.add(user);
        this.getSqlite().update("insert into User(name,email,provider_id) values (?,?,?);" , dummy , UpdateType.INSERT);
    }

    public User getById(String id) throws SQLException {

        ResultSet rs =  this.getSqlite().execute("SELECT * FROM User WHERE id=" + id);
        User user = null;
        if (rs.next()){

            user = new User(rs.getString(1), rs.getString(2), rs.getString(2), rs.getString(4));

        }

        return user;

    }

    public User getByEmail(String email) throws SQLException {

        ResultSet rs =  this.getSqlite().execute("SELECT * FROM User WHERE email=\"" + email + "\"");
        User user = null;
        if (rs.next()){

            user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));

        }

        return user;

    }

    public void update(User user){
        List<Queriable> dummy = new ArrayList<>();
        dummy.add(user);

        this.getSqlite().update("UPDATE User SET name=? , email=? , provider_id=? WHERE id=?" , dummy , UpdateType.UPDATE);

    }

    public void delete(User user){

        List<Queriable> dummy = new ArrayList<>();
        dummy.add(user);

        this.getSqlite().update("DELETE FROM User WHERE id = ?" , dummy , UpdateType.DELETE);

    }

}
