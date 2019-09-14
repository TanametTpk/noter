package th.ku.noter.source;

import java.sql.PreparedStatement;

public interface Queriable {

    public void insert(PreparedStatement prep);
    public void update(PreparedStatement prep);
    public void delete(PreparedStatement prep);

}
