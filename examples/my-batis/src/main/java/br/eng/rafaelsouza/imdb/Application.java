package br.eng.rafaelsouza.imdb;

import br.eng.rafaelsouza.imdb.persistence.MyBatisUtil;
import br.eng.rafaelsouza.imdb.persistence.BlogMapper;
import br.eng.rafaelsouza.imdb.domain.BlogRepository;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Rafael Souza
 */
public class Application {

    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.buildSqlSessionFactory().openSession();
        BlogRepository repository = new BlogRepository(session.getMapper(BlogMapper.class));
        System.out.println("Blog: " + repository.findById(1));
        repository.listAll().forEach(blog -> System.out.println("Blog: " + blog));
    }

}
