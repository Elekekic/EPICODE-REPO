package elena.secondogiorno.controller;

import elena.secondogiorno.exception.PostNonTrovatoException;
import elena.secondogiorno.model.BlogPost;
import elena.secondogiorno.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogPostController {


    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/api/blogposts")
    @ResponseStatus(HttpStatus.CREATED)
    public String savePosts(@RequestBody BlogPost blogPost) {
        String cover = "https://picsum.photos/200/300";
        blogPost.setCover(cover);
        return blogPostService.savePost(blogPost);
    }

    @GetMapping("/api/blogposts")
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllPosts();
    }

    @GetMapping("/api/blogposts/{id}")
    public BlogPost getPostById(@PathVariable int id) throws PostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = blogPostService.getPostById(id);
        if (blogPostOpt.isPresent()) {
            return blogPostOpt.get();
        } else {
            throw new PostNonTrovatoException("Il post con ID " + id + " non è stato trovato");
        }
    }

    @PutMapping(path = "/api/blogposts/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BlogPost updatePost(@PathVariable int id, @RequestBody BlogPost blogPost) throws PostNonTrovatoException {
        String cover = "https://picsum.photos/200/300";
        blogPost.setCover(cover);
        return blogPostService.updateBlogPost(id, blogPost);
    }

    @DeleteMapping("/api/blogposts/{id}")
    public String deletePost(@PathVariable int id) throws PostNonTrovatoException{
        return blogPostService.deleteBlogPost(id);
    }
}
