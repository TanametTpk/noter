package th.ku.noter.dao;

import th.ku.noter.databases.SqliteConnector;
import th.ku.noter.databases.UpdateType;
import th.ku.noter.source.DatabaseSource;
import th.ku.noter.source.Note;
import th.ku.noter.source.Queriable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteDao extends DatabaseSource {

    public static final NoteDao instance = new NoteDao();

    private NoteDao() {
        super( SqliteConnector.getInstance() , "Note");
    }

    public Note create(Note note){

        List<Queriable> dummy = new ArrayList<>();
        long date = new Date().getTime();
        dummy.add(note);
        this.getSqlite().update("insert into Note(content,created_at) values (?,"+ date +");" , dummy , UpdateType.INSERT);
        return note;

    }

    public Note getSingleNote(String userID , String collection , String noteId) throws SQLException {
        ResultSet rs =  this.getSqlite().execute("SELECT n.id , n.content , n.created_at , u.star , u.pin FROM User_Note as u INNER JOIN Note as n ON n.id=u.n_id AND u.n_id="+ noteId+" AND u.u_id=" + userID + " AND u.c_id=" + collection );
        Note note = null;
        if (rs.next()){

            note = new Note(rs.getString(0), rs.getString(1) , rs.getLong(2) , rs.getInt(3)==1 , rs.getInt(4)==1);

        }

        return note;
    }

    public List<Note> getAllSortByDate(String userID , String collection) throws SQLException {
        ResultSet rs =  this.getSqlite().execute("SELECT n.id , n.content , n.created_at , u.star , u.pin FROM User_Note as u INNER JOIN Note as n ON n.id=u.n_id AND u.u_id=" + userID + " AND u.c_id=" + collection + " ORDER BY created_at DESC;" );
        ArrayList<Note> notes = new ArrayList();
        while (rs.next()){

            notes.add(new Note(rs.getString(0), rs.getString(1) , rs.getLong(2) , rs.getInt(3)==1 , rs.getInt(4)==1));

        }

        return notes;
    }

    public List<Note> getAllStar(String userID , String collection) throws SQLException {
        ResultSet rs =  this.getSqlite().execute("SELECT n.id , n.content , n.created_at , u.star , u.pin FROM User_Note as u INNER JOIN Note as n ON n.id=u.n_id AND u.star=1 AND u.u_id=" + userID + " AND u.c_id=" + collection + " ORDER BY created_at DESC;");
        ArrayList<Note> notes = new ArrayList();
        while (rs.next()){

            notes.add(new Note(rs.getString(0), rs.getString(1) , rs.getLong(2) , rs.getInt(3)==1 , rs.getInt(4)==1));

        }

        return notes;
    }

    public void delete(Note note){
        List<Queriable> dummy = new ArrayList<>();
        dummy.add(note);
        this.getSqlite().update("DELETE FROM Note WHERE id = ?" , dummy , UpdateType.DELETE);
    }

}
