package com.gamedex.persist.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBManager {

    private static boolean initComplete = false;
    private static Connection connection;


    public DBManager() {

    }

    public synchronized Connection getConnection() throws SQLException {
        if (connection == null) {
            boolean callInit = !initComplete && initializeRequired();
            connection = DriverManager.getConnection(getDatabaseUri());
            if (callInit) {
                initializeDb(connection);
                initComplete = true;
            }
        }
        return connection;
    }

    /**
     * Returns whether or not the database has been previously initialized. If false is returned, then a call to {@link #initializeDb(Connection)} will be made after the connection is complete.
     */
    abstract protected boolean initializeRequired();

    /**
     * Will be called if {@link #initializeRequired()} returned true.
     *
     * @param connection Database connection to use for initialization.
     */
    abstract protected void initializeDb(Connection connection);

    /**
     * Will be used to get the String which {@link DriverManager#getConnection(String)} requires.
     *
     * @return The database uri this DBManager is governing.
     */
    abstract protected String getDatabaseUri();
}
