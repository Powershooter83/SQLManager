package me.prouge;

import me.prouge.utils.Manager;

public class SQLManager {

    public static Manager create(String host, String port, String database, String username, String password) {
        return new Manager(host, port, database, username, password);
    }
}
