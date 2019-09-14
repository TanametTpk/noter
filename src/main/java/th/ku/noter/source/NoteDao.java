package th.ku.noter.source;

import th.ku.noter.databases.SqliteConnector;

import java.util.List;

public class NoteDao extends DatabaseSource {

    public static final NoteDao instance = new NoteDao();

    private NoteDao() {
        super( SqliteConnector.getInstance() , "Note");
    }

    public List<Note> getAll(String userID , String collection){
        return null;
    }

    public List<Note> getAllSortByDate(String userID , String collection){
        return null;
    }

    public List<Note> getAllStar(String userID , String collection){
        return null;
    }

}
