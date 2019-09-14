package th.ku.noter.dao;

import th.ku.noter.databases.SqliteConnector;
import th.ku.noter.source.Collection;
import th.ku.noter.source.DatabaseSource;

public class CollectionDao extends DatabaseSource {

    public static final CollectionDao instance = new CollectionDao();

    private CollectionDao() {
        super(SqliteConnector.getInstance(), "Collection");
    }

    public Collection[] getCollection(String userID){
        return null;
    }

}
