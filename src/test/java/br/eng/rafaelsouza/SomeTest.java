package br.eng.rafaelsouza;

import br.eng.rafaelsouza.imdb.junit.DockerDatabaseConfig;
import br.eng.rafaelsouza.imdb.junit.DockerDatabaseConfig.DatabaseType;
import br.eng.rafaelsouza.imdb.junit.DockerDatabaseRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Rafael Souza
 */
@RunWith(DockerDatabaseRunner.class)
@DockerDatabaseConfig(type = DatabaseType.POSTGRES, port = 5432)
public class SomeTest {
    
   
    @Test
    public void test1() {
        System.out.println("RUNNIN TEST: SomeTest.test1()");
    }

    @Test
    public void test2() {
        System.out.println("RUNNIN TEST: SomeTest.test1()");
    }
    
}
