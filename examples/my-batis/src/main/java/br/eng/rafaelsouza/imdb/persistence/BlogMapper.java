package br.eng.rafaelsouza.imdb.persistence;

import br.eng.rafaelsouza.imdb.domain.Blog;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Rafael Souza
 */
public interface BlogMapper {

    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);
    
    @Select("SELECT * FROM blog")
    List<Blog> select();
}
