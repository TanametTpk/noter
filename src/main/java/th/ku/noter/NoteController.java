package th.ku.noter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ku.noter.source.Note;
import th.ku.noter.source.NoteDao;

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

}
