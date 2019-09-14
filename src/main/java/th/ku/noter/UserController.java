package th.ku.noter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import th.ku.noter.source.User;
import th.ku.noter.dao.UserDao;

import java.sql.SQLException;

@RestController
public class UserController {

    private UserDao user = UserDao.instance;

    @PostMapping("/users")
    public User createUser( @RequestBody User userReq) throws SQLException {
        User u = new User("" , userReq.getName() , userReq.getEmail() , userReq.getProviderId());
        user.create(u);
        User uRes = user.getByEmail(userReq.getEmail());

        if (uRes.getProviderId().equals(userReq.getProviderId())){
            return uRes;
        }

        throw new RuntimeException("Repeat email");
    }

    @RequestMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") String userId) throws SQLException {
        return user.getById(userId);
    }

    @PostMapping("/users/login")
    public User login(@RequestBody User userReq) throws SQLException {
        User u = user.getByEmail(userReq.getEmail());

        if (u.getProviderId().equals(userReq.getProviderId())){
            return u;
        }

        noAUth();
        return null;
    }

    @ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
    void noAUth(){}

}
