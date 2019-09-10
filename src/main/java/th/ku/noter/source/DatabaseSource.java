package th.ku.noter;

public class DatabaseSource {

    private SqliteConnector sqlite;
    private String dbName;

    public DatabaseSource(SqliteConnector sqlite, String dbName) {
        this.sqlite = sqlite;
        this.dbName = dbName;
    }

    public SqliteConnector getSqlite() {
        return sqlite;
    }

    public String getDbName() {
        return dbName;
    }
}
