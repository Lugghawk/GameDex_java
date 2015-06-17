package com.gamedex.main;

import com.gamedex.persist.dao.GameDao;
import com.gamedex.persist.database.SQLiteDBManager;
import com.gamedex.persist.model.Game;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Dave on 6/16/2015.
 */
public class GameDexMain {
    static Connection conn;

    public static void main(String[] args) {

        try {
            conn = (new SQLiteDBManager()).getConnection();

            GameDao dao = new GameDao(conn);
            Game myGame = new Game();
            myGame.setName("battlefield 1942");
            myGame.setId(1);
            dao.addGame(myGame);
            for (Game game : dao.getAllGames()) {
                System.out.println(String.format("Game [ Name: %s , id %d ]", game.getName(), game.getId()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
