package br.eng.rafaelsouza.imdb.junit;

import br.eng.rafaelsouza.imdb.DatabaseConfig;
import br.eng.rafaelsouza.imdb.DockerDatabaseManager;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 *
 * @author Rafael Souza
 */
public class DockerDatabaseRunner extends BlockJUnit4ClassRunner {

    public DockerDatabaseRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addFirstListener(new TestExecutionListener());
        DockerDatabaseManager.startDb(getConfigByAnnotation(this.getDescription().getTestClass().getAnnotationsByType(DockerDatabaseConfig.class)));
        super.run(notifier);
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
