package elena.quartogiorno2.Service;

import elena.quartogiorno2.Repository.OrderRepository;
import elena.quartogiorno2.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrderByNumero(int id) {
        return orderRepository.findById(id).get();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
