package com.gamedex.persist.dao;

import com.gamedex.persist.mapper.GameMapper;
import com.gamedex.persist.model.Game;

import java.sql.*;
import java.util.Collection;

/**
 * Created by Dave on 6/17/2015.
 */
public class GameDao {

    private Connection conn;
    private static GameMapper gameMapper = new GameMapper();

    public GameDao(Connection connection) {
        conn = connection;
    }

    public void addGame(Game game) throws SQLException {
        String insertString = "INSERT INTO games (id, name) VALUES (?,?);";
        PreparedStatement stmt = conn.prepareStatement(insertString);
        stmt.setInt(1, game.getId());
        stmt.setString(2, game.getName());
        stmt.executeUpdate();
    }

    public Collection<Game> getAllGames() throws SQLException {
        String getAllGamesString = "SELECT * FROM games;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(getAllGamesString);
        return gameMapper.mapRows(rs);

    }

}
