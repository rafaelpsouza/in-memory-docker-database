package br.eng.rafaelsouza.imdb.junit;

import br.eng.rafaelsouza.imdb.DockerDatabaseManager;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/**
 *
 * @author Rafael Souza
 */
class TestExecutionListener extends RunListener {

    @Override
    public void testRunFinished(Result result) throws Exception {
        DockerDatabaseManager.stop();
    }  

}
