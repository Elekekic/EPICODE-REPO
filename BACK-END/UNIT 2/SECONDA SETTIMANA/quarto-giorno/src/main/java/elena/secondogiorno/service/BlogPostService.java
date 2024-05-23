package elena.secondogiorno.service;

import elena.secondogiorno.DTO.BlogPostDto;
import elena.secondogiorno.exception.PostNonTrovatoException;
import elena.secondogiorno.model.Autore;
import elena.secondogiorno.model.BlogPost;
import elena.secondogiorno.repository.AutoreRepository;
import elena.secondogiorno.repository.BlogPostrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogPostService {

   @Autowired
   private BlogPostrepository blogPostrepository;

   @Autowired
   private AutoreRepository autoreRepository;

    public Optional<BlogPost> getPostById(int id){
        return blogPostrepository.findById(id);
    }

    public Page<BlogPost> getAllPosts (int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return blogPostrepository.findAll(pageable);
    }

    public String savePost(BlogPostDto blogPostDto){
        BlogPost blogPost = new BlogPost();
        blogPost.setCategoria(blogPostDto.getCategoria());
        blogPost.setTitolo(blogPostDto.getTitolo());
        blogPost.setContenuto(blogPostDto.getContenuto());
        blogPost.setTempoDiLettura(blogPostDto.getTempoDiLettura());
        String cover = "https://picsum.photos/200/300";
        blogPost.setCover(cover);
        blogPostrepository.save(blogPost);
        return "Il post con id: " + blogPost.getId() + "aggiunto/a con successo";
    }

    public BlogPost updateBlogPost(int id, BlogPostDto blogPostDto) throws PostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = getPostById(id);

        if(blogPostOpt.isPresent()){
            BlogPost blogPost = blogPostOpt.get();
            blogPost.setCategoria(blogPostDto.getCategoria());
            blogPost.setTitolo(blogPostDto.getTitolo());
            blogPost.setContenuto(blogPostDto.getContenuto());
            blogPost.setTempoDiLettura(blogPostDto.getTempoDiLettura());

            Optional<Autore> autoreOptional= autoreRepository.findById(blogPostDto.getAutoreId());

            if(autoreOptional.isPresent()){
                Autore autore = autoreOptional.get();
                blogPost.setAutore(autore);
                blogPostrepository.save(blogPost);
                return blogPost;
            }
            else{
                throw new PostNonTrovatoException("Aula con id:" + id + " non trovata");
            }
        }
        else{
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

    public String deleteBlogPost(int id) throws PostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = getPostById(id);

        if (blogPostOpt.isPresent()) {
            blogPostrepository.delete(blogPostOpt.get());
            return "Post con ID: " + id + "cancellato con successo";
        } else {
            throw new PostNonTrovatoException( "Post non trovato");
        }
    }
}
