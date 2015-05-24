/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eng.rafaelsouza.imdb;

import com.github.dockerjava.api.ConflictException;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.NotFoundException;
import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.StartContainerCmd;
import com.github.dockerjava.api.command.StopContainerCmd;
import com.github.dockerjava.api.model.Ports;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Rafael Souza
 */
public class DockerPostgresqlTest {

    @Test
    public void testStartDefaultConfig() {
        DockerClient client = mockedClient("aabb11");
        DockerPostgresql postgresInstance = new DockerPostgresql(client, new DatabaseConfig(DatabaseConfig.DatabaseType.POSTGRES));
        DatabaseStatus status = postgresInstance.start();
        assertEquals(new DatabaseStatus(true, "aabb11", 5432), status);
    }

    @Test
    public void testStartCustonPort() {
        DockerClient client = mockedClient("1111");
        DockerPostgresql postgresInstance = new DockerPostgresql(client, new DatabaseConfig(DatabaseConfig.DatabaseType.POSTGRES).withPort(1000));
        DatabaseStatus status = postgresInstance.start();
        assertEquals(new DatabaseStatus(true, "1111", 1000), status);
    }

    @Test
    public void testStop() {
        DockerClient client = mockedClient("2222");
        DockerPostgresql postgresInstance = new DockerPostgresql(client, new DatabaseConfig(DatabaseConfig.DatabaseType.POSTGRES).withPort(1000));
        DatabaseStatus status = postgresInstance.start();
        postgresInstance.stop();
        verify(client, times(1)).stopContainerCmd(status.getContainerId());
    }

    private DockerClient mockedClient(String createdId) {
        DockerClient client = mock(DockerClient.class);
        CreateContainerCmd containerCmd = mockedCreateContainerCmd(createdId);
        when(client.createContainerCmd("postgres")).thenReturn(containerCmd);
        StartContainerCmd startContainerCmd = mockedStartContainerCmd(createdId);
        when(client.startContainerCmd(createdId)).thenReturn(startContainerCmd);
        when(client.stopContainerCmd(any())).thenReturn(mock(StopContainerCmd.class));
        return client;
    }

    private CreateContainerCmd mockedCreateContainerCmd(String createdId) throws NotFoundException, ConflictException {
        CreateContainerResponse containerResponse = mockedCreateContainerResponse(createdId);
        CreateContainerCmd containerCmd = mock(CreateContainerCmd.class);
        when(containerCmd.withPortBindings(any(Ports.class))).thenReturn(containerCmd);
        when(containerCmd.exec()).thenReturn(containerResponse);
        return containerCmd;
    }

    private CreateContainerResponse mockedCreateContainerResponse(String createdId) {
        CreateContainerResponse containerResponse = mock(CreateContainerResponse.class);
        when(containerResponse.getId()).thenReturn(createdId);
        return containerResponse;
    }

    private StartContainerCmd mockedStartContainerCmd(String createdId) {
        StartContainerCmd startContainerCmd = mock(StartContainerCmd.class);
        when(startContainerCmd.getContainerId()).thenReturn(createdId);
        return startContainerCmd;
    }

}
