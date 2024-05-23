package elena.secondogiorno.controller;

import elena.secondogiorno.DTO.BlogPostDto;
import elena.secondogiorno.exception.PostNonTrovatoException;
import elena.secondogiorno.model.BlogPost;
import elena.secondogiorno.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public String savePosts(@RequestBody BlogPostDto blogPostDto) {
        return blogPostService.savePost(blogPostDto);
    }

    @GetMapping("/api/blogposts")
    public Page<BlogPost> getAllBlogPosts(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "1") int size,
                                          @RequestParam(defaultValue = "id") String sortBy) {
        return blogPostService.getAllPosts(page,size,sortBy);
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

    @PutMapping("/api/blogposts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BlogPost updatePost(@PathVariable int id, @RequestBody BlogPostDto blogPostDto) throws PostNonTrovatoException {
        String cover = "https://picsum.photos/200/300";
        blogPostDto.setCover(cover);
        return blogPostService.updateBlogPost(id, blogPostDto);
    }

    @DeleteMapping("/api/blogposts/{id}")
    public String deletePost(@PathVariable int id) throws PostNonTrovatoException{
        return blogPostService.deleteBlogPost(id);
    }
}
