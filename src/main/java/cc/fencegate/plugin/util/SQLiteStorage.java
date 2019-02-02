package cc.fencegate.plugin.util;
import cc.fencegate.plugin.FenceGate;
import cc.fencegate.plugin.local.lang.Language;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteStorage {
    private String filename;
    private static final String CONNECTION_PERFIX = "jdbc:sqlite:";

    public SQLiteStorage(String filename){
        this.filename = filename;
        try {
            connection = DriverManager.getConnection(CONNECTION_PERFIX + filename);
        } catch (SQLException e) {
            FenceGate.instance.getLogger().warning(Language.SQL_FAIL);
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
            FenceGate.instance.getLogger().warning(Language.SQL_FAIL);
            e.printStackTrace();
        }
    }
}
