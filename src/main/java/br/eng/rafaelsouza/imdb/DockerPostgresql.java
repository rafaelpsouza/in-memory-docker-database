package br.eng.rafaelsouza.imdb;

import br.eng.rafaelsouza.imdb.DatabaseConfig.DatabaseType;
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
    public void start() {
        ExposedPort tcp5432 = ExposedPort.tcp(5432);
        Ports portBindings = new Ports();
        System.out.println("################## PORT: "+config.getPort());
        portBindings.bind(tcp5432, Ports.Binding(config.getPort().orElse(5432)));
        CreateContainerResponse container = dockerClient.createContainerCmd("postgres")
                .withPortBindings(portBindings)
                .exec();
        containerId = container.getId();
        dockerClient.startContainerCmd(containerId).exec();
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
