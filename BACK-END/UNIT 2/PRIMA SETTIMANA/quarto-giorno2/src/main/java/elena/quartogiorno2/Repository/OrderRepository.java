package elena.quartogiorno2.Repository;

import elena.quartogiorno2.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order, Integer> {
}
