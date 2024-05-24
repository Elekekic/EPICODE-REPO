package elena.secondogiorno.service;

import com.cloudinary.Cloudinary;
import elena.secondogiorno.DTO.BlogPostDto;
import elena.secondogiorno.exception.AutoreNonTrovatoException;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostrepository blogPostrepository;

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private Cloudinary cloudinary;

    public Optional<BlogPost> getPostById(int id) {
        return blogPostrepository.findById(id);
    }

    public Page<BlogPost> getAllPosts(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return blogPostrepository.findAll(pageable);
    }

    public String savePost(BlogPostDto blogPostDto) {

        Optional<Autore> autoreOptional = autoreRepository.findById(blogPostDto.getAutoreId());
        BlogPost blogPost = new BlogPost();

        if (autoreOptional.isPresent()) {
            blogPost.setCategoria(blogPostDto.getCategoria());
            blogPost.setTitolo(blogPostDto.getTitolo());
            blogPost.setContenuto(blogPostDto.getContenuto());
            blogPost.setTempoDiLettura(blogPostDto.getTempoDiLettura());
            blogPost.setCover("https://picsum.photos/200/300");
            blogPost.setAutore(autoreOptional.get());
            blogPostrepository.save(blogPost);
            return "Il post con id: " + blogPost.getId() + "aggiunto/a con successo";
        } else {
            throw new AutoreNonTrovatoException("Autore con id=" + blogPost.getId() + " non trovato/a");
        }
    }

    public BlogPost updateBlogPost(int id, BlogPostDto blogPostDto) {
        Optional<BlogPost> blogPostOpt = getPostById(id);

        if (blogPostOpt.isPresent()) {
            BlogPost blogPost = blogPostOpt.get();
            blogPost.setCategoria(blogPostDto.getCategoria());
            blogPost.setTitolo(blogPostDto.getTitolo());
            blogPost.setContenuto(blogPostDto.getContenuto());
            blogPost.setTempoDiLettura(blogPostDto.getTempoDiLettura());

            Optional<Autore> autoreOptional = autoreRepository.findById(blogPostDto.getAutoreId());

            if (autoreOptional.isPresent()) {
                blogPost.setAutore(autoreOptional.get());
                return blogPostrepository.save(blogPost);
            } else {
                throw new PostNonTrovatoException("Autore con id:" + id + " non trovato/a");
            }
        } else {
            throw new PostNonTrovatoException("Post con id:" + id + " non trovato");
        }
    }

    public String deleteBlogPost(int id) {
        Optional<BlogPost> blogPostOpt = getPostById(id);

        if (blogPostOpt.isPresent()) {
            blogPostrepository.delete(blogPostOpt.get());
            return "Post con ID: " + id + "cancellato con successo";
        } else {
            throw new PostNonTrovatoException("Post con id:" + id + " non trovato");
        }
    }

    public String patchCoverBlog(int id, MultipartFile cover) throws IOException {
        Optional<BlogPost> blogOptional = getPostById(id);

        if (blogOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(cover.getBytes(), Collections.emptyMap()).get("url");
            BlogPost blogPost = blogOptional.get();
            blogPost.setCover(url);

            blogPostrepository.save(blogPost);
            return "Cover con url: " + url + " salvata correttamente sul post con ID:" + id;
        } else {
            throw new PostNonTrovatoException("Post con ID: " + id + " non trovato");
        }
    }
}
