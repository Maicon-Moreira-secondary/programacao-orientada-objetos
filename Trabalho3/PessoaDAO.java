import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private List<Pessoa> pessoas;

    public PessoaDAO() {
        pessoas = new ArrayList<Pessoa>();
    }

    public Pessoa getById(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public List<Pessoa> getAll() {
        return pessoas;
    }

    public void add(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void delete(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }
}
