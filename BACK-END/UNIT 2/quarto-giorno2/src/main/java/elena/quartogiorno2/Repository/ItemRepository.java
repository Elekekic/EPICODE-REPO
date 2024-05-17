package elena.quartogiorno2.Repository;

import elena.quartogiorno2.bean.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer> {
}
