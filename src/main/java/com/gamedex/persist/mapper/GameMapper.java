package com.gamedex.persist.mapper;

import com.gamedex.persist.model.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Dave on 6/17/2015.
 */
public class GameMapper extends RowMapper<Game> {
    @Override
    public Collection<Game> mapRows(ResultSet rs) throws SQLException {
        Collection<Game> games = new HashSet<>();
        while (rs.next()) {
            Game game = new Game();
            game.setName(rs.getString("name"));
            game.setId(rs.getInt("id"));
            games.add(game);
        }
        return games;
    }
}
