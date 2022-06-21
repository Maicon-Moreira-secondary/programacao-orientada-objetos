public class Main {
    public static void main(String[] args) {
//        adicionar pessoas Ana, Maria, João
        System.out.println("Adicionando pessoas...");
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.add(new Pessoa(1, "Ana"));
        pessoaDAO.add(new Pessoa(2, "Maria"));
        pessoaDAO.add(new Pessoa(3, "Joao"));

//        imprimir todas as pessoas
        System.out.println("Todas as pessoas:");
        for (Pessoa pessoa : pessoaDAO.getAll()) {
            System.out.println(pessoa.getId() + " - " + pessoa.getNome());
        }

//        imprimir pessoa com id 2
        System.out.println("Pessoa com id 2:");
        System.out.println(pessoaDAO.getById(2).getNome());

//        deletar pessoa com id 3
        System.out.println("Deletando pessoa com id 3:");
        pessoaDAO.delete(pessoaDAO.getById(3));

//        imprimir todas as pessoas restantes
        System.out.println("Todas as pessoas restantes:");
        for (Pessoa pessoa : pessoaDAO.getAll()) {
            System.out.println(pessoa.getId() + " - " + pessoa.getNome());
        }
    }
}