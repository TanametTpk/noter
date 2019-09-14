package th.ku.noter.dao;

import th.ku.noter.databases.SqliteConnector;
import th.ku.noter.databases.UpdateType;
import th.ku.noter.source.Collection;
import th.ku.noter.source.DatabaseSource;
import th.ku.noter.source.Queriable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectionDao extends DatabaseSource {

    public static final CollectionDao instance = new CollectionDao();

    private CollectionDao() {
        super(SqliteConnector.getInstance(), "Collection");
    }

    public List<Collection> getCollection(String userID) throws SQLException {

        ResultSet rs =  this.getSqlite().execute("SELECT * FROM Collection WHERE u_id=" + userID);
        ArrayList<Collection> collection = new ArrayList();
        while (rs.next()){

            collection.add(new Collection(rs.getString(0), rs.getString(1)));

        }

        return collection;
    }

    public void create(Collection collection){

        List<Queriable> dummy = new ArrayList<>();
        dummy.add(collection);
        this.getSqlite().update("insert into Collection(name, u_id) values (?,?);" , dummy , UpdateType.INSERT);

    }

    public void update(Collection collection){

        List<Queriable> dummy = new ArrayList<>();
        dummy.add(collection);
        this.getSqlite().update("UPDATE Collection SET name=? WHERE id=?" , dummy , UpdateType.UPDATE);

    }

    public void delete(Collection collection){

        List<Queriable> dummy = new ArrayList<>();
        dummy.add(collection);
        this.getSqlite().update("DELETE FROM Collection WHERE id = ?" , dummy , UpdateType.DELETE);

    }

}
