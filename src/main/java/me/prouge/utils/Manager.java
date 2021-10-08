package me.prouge.utils;

import java.sql.*;

public class Manager {
    private final String host;
    private final String port;
    private final String database;
    private final String username;
    private final String password;

    public Manager(String host, String port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
        getConnection();
    }

    private Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String unicode = "useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
            return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?" + unicode, username, password);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void createQuery(String query) {
        if (query.toUpperCase().startsWith("CREATE") ||
                query.toUpperCase().startsWith("DELETE") ||
                query.toUpperCase().startsWith("DROP") ||
                query.toUpperCase().startsWith("ALTER") ||
                query.toUpperCase().startsWith("INSERT")) {
            executeUpdate(query);
        }
        if (query.toUpperCase().startsWith("SELECT")) {
            executeQuery(query);
        }

    }

    private ResultSet executeQuery(String query) {
        try {
            return getConnection().createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void executeUpdate(String query) {
        try {
            getConnection().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
