package com.gamedex.persist.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Dave on 6/17/2015.
 */
public abstract class RowMapper<T> {

    public abstract Collection<T> mapRows(ResultSet rs) throws SQLException;
}
