public class Livro implements Publicacao {
    private String titulo;
    private String autor;
    private int totPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String titulo, String autor, int totPaginas, Pessoa leitor) {
        if (totPaginas < 0) {
            throw new IllegalArgumentException("O total de paginas nao pode ser negativo");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.totPaginas = totPaginas;
        this.pagAtual = 0;
        this.aberto = false;
        this.leitor = leitor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotPaginas() {
        return totPaginas;
    }

    public void setTotPaginas(int totPaginas) {
        if (totPaginas < 0) {
            throw new IllegalArgumentException("O total de paginas nao pode ser negativo");
        }

        this.totPaginas = totPaginas;
        if (pagAtual > totPaginas) {
            pagAtual = totPaginas;
        }
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        if (pagAtual < 0 || pagAtual > totPaginas) {
            throw new IllegalArgumentException("A pagina atual deve estar entre zero e o total de paginas");
        }

        this.pagAtual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    @Override
    public void abrir() {
        aberto = true;
    }

    @Override
    public void fechar() {
        aberto = false;
    }

    @Override
    public void folhear(int p) {
        if (aberto && p >= 0 && p <= totPaginas) {
            pagAtual = p;
        }
    }

    @Override
    public void avancarPag() {
        if (aberto && pagAtual < totPaginas) {
            pagAtual++;
        }
    }

    @Override
    public void voltarPag() {
        if (aberto && pagAtual > 0) {
            pagAtual--;
        }
    }
}
