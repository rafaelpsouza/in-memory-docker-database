package br.eng.rafaelsouza.imdb;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.Ports;

/**
 *
 * @author Rafael Souza
 */
public class DockerPostgresql implements InMemoryDatabase {

    private final DockerClient dockerClient;
    private String containerId;
    private final DatabaseConfig config;

    public DockerPostgresql(DockerClient dockerClient, DatabaseConfig config) {
        this.dockerClient = dockerClient;
        this.config = config;
    }

    @Override
    public DatabaseStatus start() {
        int databasePort = config.getPort().orElse(5432);
        Ports portBindings = new Ports();
        portBindings.bind(ExposedPort.tcp(5432), Ports.Binding(databasePort));
        CreateContainerResponse createContainerResponse = dockerClient.createContainerCmd("postgres")
                .withPortBindings(portBindings)
                .exec();
                
        containerId = createContainerResponse.getId();
        dockerClient.startContainerCmd(containerId).exec();
        return new DatabaseStatus(true, containerId, databasePort);        
    }

    @Override
    public void migrate(Migration migration) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stop() {
        dockerClient.stopContainerCmd(containerId).exec();
    }

}
