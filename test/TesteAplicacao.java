public class TesteAplicacao {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Ana", 20, "Feminino");
        pessoa.fazerAniversario();
        verificar(pessoa.getIdade() == 21,
                "fazerAniversario deve incrementar a idade");

        Livro livro = new Livro("Java", "Autor", 10, pessoa);
        verificar(!livro.isAberto(), "O livro deve iniciar fechado");
        verificar(livro.getPagAtual() == 0,
                "A pagina inicial deve ser zero");
        verificar(livro.getLeitor() == pessoa,
                "O livro deve agregar a pessoa recebida");

        livro.folhear(5);
        verificar(livro.getPagAtual() == 0,
                "Livro fechado nao deve permitir navegacao");

        livro.abrir();
        verificar(livro.isAberto(), "abrir deve alterar o estado");
        livro.folhear(5);
        verificar(livro.getPagAtual() == 5,
                "folhear deve aceitar uma pagina valida");
        livro.avancarPag();
        verificar(livro.getPagAtual() == 6,
                "avancarPag deve avancar uma pagina");
        livro.voltarPag();
        verificar(livro.getPagAtual() == 5,
                "voltarPag deve voltar uma pagina");

        livro.folhear(-1);
        verificar(livro.getPagAtual() == 5,
                "folhear nao deve aceitar pagina negativa");
        livro.folhear(11);
        verificar(livro.getPagAtual() == 5,
                "folhear nao deve ultrapassar o total");
        livro.folhear(10);
        livro.avancarPag();
        verificar(livro.getPagAtual() == 10,
                "avancarPag nao deve ultrapassar o total");
        livro.folhear(0);
        livro.voltarPag();
        verificar(livro.getPagAtual() == 0,
                "voltarPag nao deve criar pagina negativa");

        livro.fechar();
        verificar(!livro.isAberto(), "fechar deve alterar o estado");
        livro.avancarPag();
        verificar(livro.getPagAtual() == 0,
                "Livro fechado nao deve avancar pagina");

        String detalhes = livro.detalhes();
        verificar(detalhes.contains("Java")
                        && detalhes.contains("Autor")
                        && detalhes.contains("Ana")
                        && detalhes.contains("21")
                        && detalhes.contains("Feminino"),
                "detalhes deve incluir livro e leitor");

        livro.setLeitor(null);
        verificar(livro.detalhes().contains("nao informado"),
                "detalhes deve tratar leitor nulo");

        verificarExcecao(() -> new Livro("Invalido", "Autor", -1, pessoa),
                "O construtor deve rejeitar total negativo");
        verificarExcecao(() -> livro.setPagAtual(11),
                "O setter deve rejeitar pagina acima do total");
        verificar(livro.getPagAtual() == 0,
                "Operacao invalida nao deve alterar a pagina");

        System.out.println("Todos os testes foram aprovados.");
    }

    private static void verificar(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new AssertionError(mensagem);
        }
    }

    private static void verificarExcecao(Runnable operacao, String mensagem) {
        try {
            operacao.run();
            throw new AssertionError(mensagem);
        } catch (IllegalArgumentException esperada) {
            // Comportamento esperado.
        }
    }
}
