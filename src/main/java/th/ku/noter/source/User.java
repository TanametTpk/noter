package th.ku.noter.source;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void setId(String id){
        this.id = id;
    }

    @Override
    public void insert(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getName());
        prep.setString(2 , this.getEmail());
        prep.setString(3 , this.getProviderId());
    }

    @Override
    public void update(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getName());
        prep.setString(2 , this.getEmail());
        prep.setString(3 , this.getProviderId());
        prep.setString(4 , this.getId());
    }

    @Override
    public void delete(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getId());
    }
}
