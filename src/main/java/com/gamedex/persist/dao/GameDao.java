package com.gamedex.persist.dao;

import com.gamedex.persist.model.Game;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Dave on 6/20/2015.
 */
@Repository
public class GameDao {
    @Autowired
    private SessionFactory sessionFactory;


    public void save(Game game) {
        
    }
}
