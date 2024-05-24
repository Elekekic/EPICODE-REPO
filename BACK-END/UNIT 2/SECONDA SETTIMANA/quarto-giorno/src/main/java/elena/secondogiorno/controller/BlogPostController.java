package elena.secondogiorno.controller;

import elena.secondogiorno.DTO.BlogPostDto;
import elena.secondogiorno.exception.BadRequestException;
import elena.secondogiorno.exception.PostNonTrovatoException;
import elena.secondogiorno.model.BlogPost;
import elena.secondogiorno.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/api/blogPosts")
    @ResponseStatus(HttpStatus.CREATED)
    public String savePosts(@RequestBody @Validated BlogPostDto blogPostDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (s, s2) -> s + s2));
        }
        return blogPostService.savePost(blogPostDto);
    }

    @GetMapping("/api/blogPosts")
    public Page<BlogPost> getAllBlogPosts(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "1") int size,
                                          @RequestParam(defaultValue = "id") String sortBy) {
        return blogPostService.getAllPosts(page, size, sortBy);
    }

    @GetMapping("/api/blogPosts/{id}")
    public BlogPost getPostById(@PathVariable int id) {
        Optional<BlogPost> blogPostOpt = blogPostService.getPostById(id);
        if (blogPostOpt.isPresent()) {
            return blogPostOpt.get();
        } else {
            throw new PostNonTrovatoException("Il post con ID " + id + " non è stato trovato");
        }
    }

    @PutMapping("/api/blogPosts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BlogPost updatePost(@PathVariable int id, @RequestBody @Validated BlogPostDto blogPostDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s, s2) -> s+s2));
        }

        return blogPostService.updateBlogPost(id, blogPostDto);
    }

    @DeleteMapping("/api/blogPosts/{id}")
    public String deletePost(@PathVariable int id) {
        return blogPostService.deleteBlogPost(id);
    }

    @PatchMapping("/api/blogPosts/{id}")
    public String patchCoverBlog(@PathVariable int id,@RequestBody MultipartFile cover) throws IOException {
        return blogPostService.patchCoverBlog(id, cover);
    }
}
