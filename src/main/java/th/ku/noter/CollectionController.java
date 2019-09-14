package th.ku.noter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ku.noter.source.Collection;
import th.ku.noter.source.CollectionDao;

@RestController
public class CollectionController {

    private CollectionDao collection = CollectionDao.instance;

    @RequestMapping("/collections/{userId}")
    public Collection[] getCollection(@PathVariable("userId") String userId){
        return collection.getCollection(userId);
    }

}
