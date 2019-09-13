package th.ku.noter.source;

import java.sql.PreparedStatement;

public class Collection implements Queriable {

    private String id;
    private String name;

    public Collection(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(PreparedStatement prep) {

    }
}
