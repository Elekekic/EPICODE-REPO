package elena.quartogiorno2.Service;

import elena.quartogiorno2.Repository.ItemRepository;
import elena.quartogiorno2.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public Item getItemById(int id) {
        return itemRepository.findById(id).get();
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }


}
