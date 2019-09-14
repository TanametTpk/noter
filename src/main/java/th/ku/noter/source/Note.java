package th.ku.noter.source;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Note implements Queriable {

    private String id;
    private String content;
    private long created_at;
    private boolean star;
    private boolean pin;

    public Note(String id, String content, long created_at, boolean star, boolean pin) {
        this.id = id;
        this.content = content;
        this.created_at = created_at;
        this.star = star;
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public boolean isStar() {
        return star;
    }

    public void setStar(boolean star) {
        this.star = star;
    }

    public boolean isPin() {
        return pin;
    }

    public void setPin(boolean pin) {
        this.pin = pin;
    }

    @Override
    public void insert(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getContent());
        prep.setLong(2 , this.getCreated_at());
    }

    @Override
    public void update(PreparedStatement prep) {

    }

    @Override
    public void delete(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getId());
    }
}
