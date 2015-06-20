package com.gamedex.persist.dao;

import com.gamedex.persist.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dave on 6/20/2015.
 */
@Repository
@Transactional
public class GameDao {
    @Autowired
    private SessionFactory sessionFactory;



    public void persist(Game game) {
        Session sess = sessionFactory.getCurrentSession();
        sess.saveOrUpdate(game);
    }

    public List<Game> getAllGames(){
        Session sess = sessionFactory.getCurrentSession();
        return sess.createCriteria(Game.class).list();
    }
}
