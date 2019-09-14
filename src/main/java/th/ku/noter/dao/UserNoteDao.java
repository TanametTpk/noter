package th.ku.noter.dao;

import th.ku.noter.databases.SqliteConnector;
import th.ku.noter.databases.UpdateType;
import th.ku.noter.source.DatabaseSource;
import th.ku.noter.source.Queriable;
import th.ku.noter.source.UserNote;

import java.util.ArrayList;
import java.util.List;

public class UserNoteDao extends DatabaseSource {

    public static final UserNoteDao instance = new UserNoteDao();

    private UserNoteDao() {
        super(SqliteConnector.getInstance(), "User_Note");
    }

    public void create(UserNote userNote){
        List<Queriable> dummy = new ArrayList<>();
        dummy.add(userNote);
        this.getSqlite().update("insert into User_Note(u_id,n_id,c_id,star,pin) values (?,?,?,?,?);" , dummy , UpdateType.INSERT);
    }

    public void update(UserNote userNote){
        List<Queriable> dummy = new ArrayList<>();
        dummy.add(userNote);
        this.getSqlite().update("UPDATE User_Note SET star=? , pin=? WHERE u_id = ? AND n_id = ? AND c_id = ?" , dummy , UpdateType.UPDATE);
    }

    public void delete(UserNote userNote){
        List<Queriable> dummy = new ArrayList<>();
        dummy.add(userNote);
        this.getSqlite().update("DELETE FROM User_Note WHERE u_id = ? AND n_id = ? AND c_id = ?" , dummy , UpdateType.DELETE);
    }


}
