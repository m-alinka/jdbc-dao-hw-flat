package org.example;


import java.sql.Connection;

public class FlatDAOImpl extends AbstractDAO<Flat> {
    public FlatDAOImpl(Connection conn, String table) {
        super(conn, table);
    }
}
