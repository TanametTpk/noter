package th.ku.noter;

import org.springframework.web.bind.annotation.*;
import th.ku.noter.source.Collection;
import th.ku.noter.dao.CollectionDao;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CollectionController {

    private CollectionDao collection = CollectionDao.instance;

    @RequestMapping("/collections/{userId}")
    public List<Collection> getCollection(@PathVariable("userId") String userId) throws SQLException {
        return collection.getCollection(userId);
    }

    @PostMapping("/collections")
    public Collection createCollection(@RequestBody Collection collectionReq){

        collection.create(collectionReq);
        return collectionReq;

    }

    @PostMapping("/collections/del")
    public Collection deleteCollection(@RequestBody Collection collectionReq){

        collection.delete(collectionReq);
        return collectionReq;

    }

}
