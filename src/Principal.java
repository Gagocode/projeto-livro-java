public class Principal {
    public static void main(String[] args) {
        Pessoa ana = new Pessoa("Ana", 22, "Feminino");
        Pessoa bruno = new Pessoa("Bruno", 30, "Masculino");

        Livro livroJava = new Livro("Programacao Orientada a Objetos",
                "Autor Exemplo", 200, ana);
        Livro livroPadroes = new Livro("Padroes de Projeto",
                "Outra Autoria", 150, bruno);

        System.out.println("=== ESTADO INICIAL ===");
        System.out.println(livroJava.detalhes());
        System.out.println();
        System.out.println(livroPadroes.detalhes());

        ana.fazerAniversario();
        livroJava.abrir();
        livroJava.folhear(40);
        livroJava.avancarPag();
        livroJava.voltarPag();

        int paginaAntesDaTentativaInvalida = livroJava.getPagAtual();
        livroJava.folhear(250);
        System.out.println();
        System.out.println("Tentativa de folhear para a pagina 250: pagina atual = "
                + livroJava.getPagAtual());
        System.out.println("Limite preservado: "
                + (livroJava.getPagAtual() == paginaAntesDaTentativaInvalida));

        livroJava.fechar();

        System.out.println();
        System.out.println("=== ESTADO APOS AS OPERACOES ===");
        System.out.println(livroJava.detalhes());
    }
}
