package th.ku.noter.source;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface Queriable {

    public void insert(PreparedStatement prep) throws SQLException;
    public void update(PreparedStatement prep) throws SQLException;
    public void delete(PreparedStatement prep) throws SQLException;

}
