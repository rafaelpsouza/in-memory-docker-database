package br.eng.rafaelsouza.imdb.domain;

import br.eng.rafaelsouza.imdb.persistence.BlogMapper;
import br.eng.rafaelsouza.imdb.domain.Blog;
import java.util.List;

/**
 *
 * @author Rafael Souza
 */
public class BlogRepository {
    
    BlogMapper blogMapper;

    public BlogRepository(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }   
    
    
    public Blog findById(int id){
        return blogMapper.selectBlog(id);
    }
    
    
    public List<Blog> listAll(){
        return blogMapper.select();
    }
    
}
