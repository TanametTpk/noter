package th.ku.noter.dao;

import th.ku.noter.databases.SqliteConnector;
import th.ku.noter.source.DatabaseSource;
import th.ku.noter.source.Note;

import java.util.List;

public class NoteDao extends DatabaseSource {

    public static final NoteDao instance = new NoteDao();

    private NoteDao() {
        super( SqliteConnector.getInstance() , "Note");
    }

    public void create(Note note){



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
