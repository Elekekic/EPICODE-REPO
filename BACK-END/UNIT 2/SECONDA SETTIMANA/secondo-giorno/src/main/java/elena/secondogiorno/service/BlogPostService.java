package elena.secondogiorno.service;

import elena.secondogiorno.exception.PostNonTrovatoException;
import elena.secondogiorno.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    private List<BlogPost> blogPosts = new ArrayList<>();

    public Optional<BlogPost> getPostById(int id){
        return blogPosts.stream().filter(posts -> posts.getId()==id).findFirst();
    }

    public List<BlogPost> getAllPosts(){
        return blogPosts;
    }

    public String savePost(BlogPost blogPost){
        blogPosts.add(blogPost);
        return "Il post " + blogPost.getTitolo() +  " è stato aggiunto con l'ID: " + blogPost.getId();
    }

    public BlogPost updateBlogPost(int id, BlogPost blogPostUpd) throws PostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = getPostById(id);
        if(blogPostOpt.isPresent()){
            BlogPost blogPost = blogPostOpt.get();
            blogPost.setCategoria(blogPostUpd.getCategoria());
            blogPost.setTitolo(blogPostUpd.getTitolo());
            blogPost.setContenuto(blogPostUpd.getContenuto());
            blogPost.setTempoDiLettura(blogPostUpd.getTempoDiLettura());
            return blogPost;
        }
        else{
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

    public String deleteBlogPost(int id) throws PostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = getPostById(id);

        if (blogPostOpt.isPresent()) {
            blogPosts.remove(blogPostOpt.get());
            return "Post eliminato";
        } else {
            throw new PostNonTrovatoException( "Post non trovato");
        }
    }
}
