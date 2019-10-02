package th.ku.noter;

import org.springframework.web.bind.annotation.*;
import th.ku.noter.dao.UserNoteDao;
import th.ku.noter.request.NoteReq;
import th.ku.noter.source.Note;
import th.ku.noter.dao.NoteDao;
import th.ku.noter.source.UserNote;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
public class NoteController {

    private NoteDao note = NoteDao.instance;
    private UserNoteDao userNote = UserNoteDao.instance;

    @RequestMapping("/notes/{userId}/{collectionId}")
    public List<Note> getAllNote(@PathVariable("userId") String userId , @PathVariable("collectionId") String collectionId , @RequestParam("sort") String sort) throws SQLException {

        List<Note> notes = null;
        if (sort.equals("star")) {
            notes = note.getAllStar(userId , collectionId);
        }
        else
            notes = note.getAllSortByDate(userId , collectionId);
        return notes;
    }

    @PostMapping("/notes")
    public Note createNote(@RequestBody NoteReq noteReq) throws SQLException {
        long date = new Date().getTime();
        Note n = new Note("" , noteReq.getNote().getContent() , date ,false , false);
        Note noteObj = note.create(n);
        // create mapping obj
        UserNote un = new UserNote(noteReq.getUserId() , noteObj.getId() , noteReq.getCollectionId() , 0 , 0);
        userNote.create(un);

        return n;
    }

    @PostMapping("/notes/{userId}/{collectionId}/{noteId}")
    public Note updateNote( @PathVariable("noteId") String noteId , @PathVariable("userId") String userId , @PathVariable("collectionId") String collectionId , @RequestBody Note note) throws SQLException {
        UserNote un = new UserNote(userId , noteId , collectionId , note.isStar() ? 1 : 0 , note.isPin() ? 1 : 0);
        userNote.update(un);
        return this.note.getSingleNote(userId , collectionId , noteId);
    }

    @PostMapping("/notes/{userId}/{collectionId}/{noteId}/del")
    public Note deleteNote( @PathVariable("noteId") String noteId , @PathVariable("userId") String userId , @PathVariable("collectionId") String collectionId , @RequestBody Note note) throws SQLException {
        UserNote un = new UserNote(userId , noteId , collectionId , note.isStar() ? 1 : 0 , note.isPin() ? 1 : 0);
        userNote.delete(un);
        this.note.delete(note);
        return note;
    }

}
