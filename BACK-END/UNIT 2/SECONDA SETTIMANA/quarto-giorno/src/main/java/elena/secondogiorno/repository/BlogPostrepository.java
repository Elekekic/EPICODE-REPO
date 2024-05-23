package elena.secondogiorno.repository;


import elena.secondogiorno.model.Autore;
import elena.secondogiorno.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostrepository extends JpaRepository<BlogPost, Integer> {
}
