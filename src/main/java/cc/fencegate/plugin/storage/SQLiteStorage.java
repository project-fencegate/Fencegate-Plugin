package cc.fencegate.plugin.storage;

import cc.fencegate.plugin.Fencegate;
import cc.fencegate.plugin.lang.Language;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteStorage {
    private String filename;

    public SQLiteStorage(String filename){
        this.filename = filename;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:"+filename);
        } catch (SQLException e) {
            Fencegate.instance.getLogger().warning(Language.SQL_FAIL);
            e.printStackTrace();
        }
    }

    private Connection connection;

    private void createTables(){
        try {
            Statement s = connection.createStatement();
            s.execute(
                    "CREATE TABLE IF NOT EXISTS plugins (pid VARCHAR(36) PRIMARY KEY NOT NULL)"
            );
            s.close();
        } catch (SQLException e) {
            Fencegate.instance.getLogger().warning(Language.SQL_FAIL);
            e.printStackTrace();
        }
    }
}
