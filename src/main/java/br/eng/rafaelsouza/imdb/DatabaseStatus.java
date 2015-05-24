package br.eng.rafaelsouza.imdb;

import java.util.Objects;

/**
 *
 * @author Rafael Souza
 */
public class DatabaseStatus {

    private Boolean started;
    private String containerId;
    private int port;

    public DatabaseStatus(Boolean started) {
        this.started = started;
    }

    public DatabaseStatus(Boolean started, String containerId, int port) {
        this.started = started;
        this.containerId = containerId;
        this.port = port;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public int getExposedPort() {
        return port;
    }

    public void setExposedPort(int exposedPort) {
        this.port = exposedPort;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.containerId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DatabaseStatus other = (DatabaseStatus) obj;
        if (!Objects.equals(this.started, other.started)) {
            return false;
        }
        if (!Objects.equals(this.containerId, other.containerId)) {
            return false;
        }
        if (this.port != other.port) {
            return false;
        }
        return true;
    }

}
