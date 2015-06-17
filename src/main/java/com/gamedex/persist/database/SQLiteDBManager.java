package com.gamedex.persist.database;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Dave on 6/16/2015.
 */
public class SQLiteDBManager extends DBManager {

    private static final String DATABASE_FILE = "gamedex.dat";
    private static final String SQLLITE_URI = "jdbc:sqlite:" + DATABASE_FILE;


    @Override
    protected boolean initializeRequired() {
        return !databaseFileExists();
    }

    @Override
    protected void initializeDb(Connection connection) {
        String initSQL = "CREATE TABLE games (ID INT PRIMARY KEY NOT NULL," +
                "name TEXT NOT NULL)";
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(initSQL);
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String getDatabaseUri() {
        return SQLLITE_URI;
    }


    protected boolean databaseFileExists() {
        File file = new File(DATABASE_FILE);
        return file.exists();
    }
}
