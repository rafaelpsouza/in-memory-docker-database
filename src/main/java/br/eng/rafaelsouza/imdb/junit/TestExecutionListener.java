package br.eng.rafaelsouza.imdb.junit;

import br.eng.rafaelsouza.imdb.DatabaseConfig;
import br.eng.rafaelsouza.imdb.DockerDatabaseManager;
import java.util.Optional;
import org.junit.runner.Description;
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

    @Override
    public void testStarted(Description description) throws Exception {
        DockerDatabaseManager.startDb(getConfigByAnnotation(description.getTestClass().getAnnotationsByType(DockerDatabaseConfig.class)));       
    }

    private DatabaseConfig getConfigByAnnotation(DockerDatabaseConfig[] configAnnotations) {
        if (configAnnotations.length > 0) {
            DockerDatabaseConfig annotation = configAnnotations[0];
            return new DatabaseConfig(DatabaseConfig.DatabaseType.POSTGRES)
                    .withDbName(annotation.database())
                    .withUser(annotation.user())
                    .withPassword(annotation.password())
                    .withPort(annotation.port());
        }
        return new DatabaseConfig(DatabaseConfig.DatabaseType.POSTGRES);
    }
    

}
