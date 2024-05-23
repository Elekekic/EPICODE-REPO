package elena.quartogiorno2.Service;

import elena.quartogiorno2.Repository.TableRepository;
import elena.quartogiorno2.bean.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public void saveTable(Table table) {
        tableRepository.save(table);
    }

    public Table getTableByNumber(int numero) {
        return tableRepository.findById(numero).get();
    }

    public List<Table> getAllTable() {
        return tableRepository.findAll();
    }

    public void deleteTable(int numero) {
        tableRepository.deleteById(numero);
    }
}
