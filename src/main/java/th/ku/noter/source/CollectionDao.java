package th.ku.noter.source;

import th.ku.noter.databases.SqliteConnector;

public class CollectionDao extends DatabaseSource {

    public CollectionDao() {
        super(SqliteConnector.getInstance(), "Collection");
    }

    public Collection[] getCollection(String userID){
        return null;
    }

}
