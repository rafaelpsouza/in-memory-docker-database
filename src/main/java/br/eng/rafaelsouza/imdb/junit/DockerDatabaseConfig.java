package br.eng.rafaelsouza.imdb.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Rafael Souza
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface DockerDatabaseConfig {
    
    public enum DatabaseType {
	   POSTGRES
    }
    
    DatabaseType type();
    String database() default "";
    String user() default "";
    String password() default "";
    int port() default -1;
    
}
