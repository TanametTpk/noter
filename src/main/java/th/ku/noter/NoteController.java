package th.ku.noter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @RequestMapping("/notes")
    public String[] getAllNote(){
        return new String[0];
    }

}
