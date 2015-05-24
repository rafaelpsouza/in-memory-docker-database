/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AppTest {
    
    
    @Test
    public void test1() {
        System.out.println("RUNNIN TEST: AppTest.test1()");
    }

    @Test
    public void test2() {
        System.out.println("RUNNIN TEST: AppTest.test2()");
    }

    @Test
    public void test3() {
        System.out.println("RUNNIN TEST: AppTest.test3()");
    }
    
}
