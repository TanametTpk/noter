package th.ku.noter;

import org.springframework.web.bind.annotation.*;
import th.ku.noter.source.Note;
import th.ku.noter.dao.NoteDao;

import java.util.List;

@RestController
public class NoteController {

    private NoteDao note = NoteDao.instance;

    @RequestMapping("/notes/{userId}/{collectionId}")
    public List<Note> getAllNote(@PathVariable("userId") String userId , @PathVariable("collectionId") String collectionId , @RequestParam("sort") String sort){

        List<Note> notes = null;

        if (sort.equals("Star"))
            notes = note.getAllStar(userId , collectionId);
        else
            notes = note.getAllSortByDate(userId , collectionId);

        return notes;
    }

    @PostMapping("/notes")
    public Note createNote(@RequestBody String content , @RequestBody String userId , @RequestBody String collectionId){
        Note n = new Note("" , content , false , false);
        note.create(n);
        // create mapping obj
        return n;
    }

}
