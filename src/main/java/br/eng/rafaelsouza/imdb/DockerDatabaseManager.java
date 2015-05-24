package br.eng.rafaelsouza.imdb;

import com.github.dockerjava.core.DockerClientBuilder;

/**
 *
 * @author Rafael Souza
 */
public class DockerDatabaseManager {

    private static InMemoryDatabase dbInstance;

    private DockerDatabaseManager() {}

    public static void startDb(DatabaseConfig databaseConfig) {
        if (dbInstance == null) {
            dbInstance = new DockerPostgresql(DockerClientBuilder.getInstance("http://localhost:2375").build(), databaseConfig);
            dbInstance.start();
        }
    }

    public static void stop() {
        if (dbInstance != null) {
            System.out.println("#################### stoping database");
            dbInstance.stop();
            dbInstance = null;
        }
    }

}
