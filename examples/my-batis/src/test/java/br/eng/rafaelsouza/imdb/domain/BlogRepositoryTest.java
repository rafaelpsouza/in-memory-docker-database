package br.eng.rafaelsouza.imdb.domain;

import br.eng.rafaelsouza.imdb.junit.DockerDatabaseConfig;
import br.eng.rafaelsouza.imdb.junit.DockerDatabaseConfig.DatabaseType;
import br.eng.rafaelsouza.imdb.junit.DockerDatabaseRunner;
import br.eng.rafaelsouza.imdb.persistence.BlogMapper;
import br.eng.rafaelsouza.imdb.persistence.MyBatisUtil;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 *
 * @author Rafael Souza
 */
@RunWith(DockerDatabaseRunner.class)
@DockerDatabaseConfig(type = DatabaseType.POSTGRES, port = 5432)
public class BlogRepositoryTest {

    SqlSession sqlSession;

    @BeforeClass
    public static void migrate() throws SQLException {
        String createTable = "CREATE TABLE blog(id serial NOT NULL, name character varying(50), author character varying(50), CONSTRAINT blog_pkey PRIMARY KEY (id));";
        String blog1 = "INSERT INTO blog (name, author) VALUES ('Blog1', 'Rafael');";
        String blog2 = "INSERT INTO blog (name, author) VALUES ('Blog2', 'ilegra');";
        SqlSession session = MyBatisUtil.buildSqlSessionFactory().openSession();
        session.getConnection().prepareCall(createTable).execute();
        session.getConnection().prepareCall(blog1).executeUpdate();
        session.getConnection().prepareCall(blog2).executeUpdate();
        session.commit();
        session.close();
    }

    @Before
    public void setUp() throws SQLException {
        sqlSession = MyBatisUtil.buildSqlSessionFactory().openSession();
    }

    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void testFindById() throws SQLException, InterruptedException {
        BlogRepository blogRepository = new BlogRepository(sqlSession.getMapper(BlogMapper.class));
        Blog result = blogRepository.findById(1);
        assertEquals(new Blog(1, "Blog1", "Rafael"), result);
    }

    @Test
    public void testListAll() {
        BlogRepository blogRepository = new BlogRepository(sqlSession.getMapper(BlogMapper.class));
        List<Blog> result = blogRepository.listAll();
        assertEquals(2, result.size());
    }

}
