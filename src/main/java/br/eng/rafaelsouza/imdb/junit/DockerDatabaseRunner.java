package br.eng.rafaelsouza.imdb.junit;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 *
 * @author Rafael Souza
 */
public class DockerDatabaseRunner extends BlockJUnit4ClassRunner{

    public DockerDatabaseRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addFirstListener(new TestExecutionListener());
        super.run(notifier);
    }

 
}
