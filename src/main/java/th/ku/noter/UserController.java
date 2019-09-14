package th.ku.noter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import th.ku.noter.source.User;
import th.ku.noter.dao.UserDao;

@RestController
public class UserController {

    private UserDao user = UserDao.instance;

    @PostMapping("/users")
    public User createUser(@RequestBody String id, @RequestBody String name , @RequestBody String email , @RequestBody String provider_id){
        User u = new User(id , name , email , provider_id);
        user.create(u);
        return u;
    }

    @RequestMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        return user.getById(userId);
    }

    @PostMapping("/users/login")
    public User login(@RequestBody String email , @RequestBody String providerId){
        User u = user.getByEmail(email);

        if (u.getProviderId().equals(providerId)){
            return u;
        }

        noAUth();
        return null;
    }

    @ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
    void noAUth(){}

}
