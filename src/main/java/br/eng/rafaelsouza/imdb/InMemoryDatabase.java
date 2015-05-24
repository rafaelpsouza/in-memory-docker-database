package br.eng.rafaelsouza.imdb;

/**
 *
 * @author Rafael Souza
 */
public interface InMemoryDatabase {
    
    public void start();
    public void migrate(Migration migration);
    public void stop();
    
    
}
