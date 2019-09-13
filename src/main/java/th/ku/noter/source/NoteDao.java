package th.ku.noter.source;

import th.ku.noter.databases.SqliteConnector;

public class NoteDao extends DatabaseSource {

    public NoteDao() {
        super( SqliteConnector.getInstance() , "Note");
    }

    public Note[] getAll(String userID , String collection){
        return null;
    }

    public Note[] getAllSortByDate(String userID , String collection){
        return null;
    }

    public Note[] getAllStar(String userID , String collection){
        return null;
    }

}
