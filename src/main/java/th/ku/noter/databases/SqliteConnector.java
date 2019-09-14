package th.ku.noter.databases;

import th.ku.noter.source.Queriable;

import java.sql.*;
import java.util.List;

public class SqliteConnector {

    private String url;
    private Connection c;
    private static SqliteConnector sqlite = new SqliteConnector();

    public SqliteConnector(){

        this.url = "jdbc:sqlite:noter.db";
        this.c = connect();

    }

    public static SqliteConnector getInstance(){
        return sqlite;
    }

    private Connection connect(){

        Connection conn = null;

        try{
            Class.forName("org.sqlite.JDBC");
            conn =  DriverManager.getConnection(this.url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;

    }

    public ResultSet execute(String query){

        try{

            Statement stmt = c.createStatement();
            ResultSet re = stmt.executeQuery(query);
            return re;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public PreparedStatement update(String query , List<Queriable> dummies , UpdateType type){

        try(PreparedStatement prep = c.prepareStatement(query) ){

            for (Queriable dummy : dummies) {

                if (type == UpdateType.INSERT) dummy.insert(prep);
                else if (type == UpdateType.UPDATE) dummy.update(prep);
                else dummy.delete(prep);

                prep.addBatch();
            }

            c.setAutoCommit(false);
            prep.executeBatch();
            c.setAutoCommit(true);
            return prep;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

}
