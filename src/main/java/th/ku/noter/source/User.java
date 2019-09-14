package th.ku.noter.source;

import java.sql.PreparedStatement;

public class User implements Queriable {

    private String id;
    private String name;
    private String email;
    private String providerId;

    public User(String id, String name, String email , String providerId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.providerId = providerId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProviderId() {
        return providerId;
    }

    @Override
    public void insert(PreparedStatement prep) {

    }

    @Override
    public void update(PreparedStatement prep) {

    }

    @Override
    public void delete(PreparedStatement prep) {

    }
}
