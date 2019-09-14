package th.ku.noter;

import org.springframework.web.bind.annotation.*;
import th.ku.noter.dao.UserNoteDao;
import th.ku.noter.source.Note;
import th.ku.noter.dao.NoteDao;
import th.ku.noter.source.UserNote;

import java.sql.SQLException;
import java.util.List;

@RestController
public class NoteController {

    private NoteDao note = NoteDao.instance;
    private UserNoteDao userNote = UserNoteDao.instance;

    @RequestMapping("/notes/{userId}/{collectionId}")
    public List<Note> getAllNote(@PathVariable("userId") String userId , @PathVariable("collectionId") String collectionId , @RequestParam("sort") String sort) throws SQLException {

        List<Note> notes = null;

        if (sort.equals("Star"))
            notes = note.getAllStar(userId , collectionId);
        else
            notes = note.getAllSortByDate(userId , collectionId);

        return notes;
    }

    @PostMapping("/notes")
    public Note createNote(@RequestBody String content , @RequestBody String userId , @RequestBody String collectionId){
        Note n = new Note("" , content , 0 ,false , false);
        Note noteObj = note.create(n);
        // create mapping obj
        UserNote un = new UserNote(userId , noteObj.getId() , collectionId , 0 , 0);
        userNote.create(un);

        return n;
    }

    @PostMapping("/notes/{userId}/{collectionId}")
    public Note updateNote(@RequestBody String noteId , @RequestBody String userId , @RequestBody String collectionId , @RequestBody boolean pin , @RequestBody boolean star) throws SQLException {
        UserNote un = new UserNote(userId , noteId , collectionId , star ? 1 : 0 , pin ? 1 : 0);
        userNote.update(un);
        return note.getSingleNote(userId , collectionId , noteId);
    }

}
