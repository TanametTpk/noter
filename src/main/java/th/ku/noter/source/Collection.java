package th.ku.noter.source;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Collection implements Queriable {

    private String id;
    private String name;
    private String u_id;

    public Collection(String id, String name, String u_id) {
        this.id = id;
        this.name = name;
        this.u_id = u_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    @Override
    public void insert(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getName());
        prep.setString(2 , this.getU_id());
    }

    @Override
    public void update(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getName());
        prep.setString(2 , this.getId());
    }

    @Override
    public void delete(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getId());
    }
}
