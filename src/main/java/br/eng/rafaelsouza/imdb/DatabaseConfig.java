package br.eng.rafaelsouza.imdb;

import java.util.Optional;

/**
 *
 * @author Rafael Souza
 */
public class DatabaseConfig {

    public enum DatabaseType {
        POSTGRES
    }

    private DatabaseType dbType;
    private Optional<String> dbName;
    private Optional<String> user;
    private Optional<String> password;
    private Optional<Integer> port;

    public DatabaseConfig(DatabaseType databaseType) {
        this.dbType = databaseType;
        this.dbName = Optional.empty();
        this.user = Optional.empty();
        this.password = Optional.empty();
        this.port = Optional.empty();;
    }

    public Optional<String> getDbName() {
        return dbName;
    }

    public DatabaseConfig withDbName(String dbName) {
        if (!isEmpty(dbName)) {
            this.dbName = Optional.of(dbName);
        }
        return this;
    }

    public Optional<String> getUser() {
        return user;
    }

    public DatabaseConfig withUser(String user) {
        if (!isEmpty(user)) {
            this.user = Optional.of(user);
        }
        return this;
    }

    public Optional<String> getPassword() {
        return password;
    }

    public DatabaseConfig withPassword(String password) {
        if (!isEmpty(password)) {
            this.password = Optional.of(password);
        }
        return this;
    }

    public Optional<Integer> getPort() {
        return port;
    }

    public DatabaseConfig withPort(Integer port) {
        if (port > 0) 
            this.port = Optional.of(port);        
        return this;
    }

    public DatabaseType getDbType() {
        return dbType;
    }

    private boolean isEmpty(String value) {
        return value == null || value.isEmpty();

    }
}
