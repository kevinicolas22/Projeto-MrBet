package Lab4;

/**
Classe que representa uma aposta em um time de um campeonato.
*/
public class Aposta {
    private Time time;
    private Campeonato campeonato;
    private int colocacao;
    private double valor;
    /**
     * Construtor da classe Aposta.
     * 
     * @param time O time selecionado na aposta.
     * @param campeonato O campeonato em que a aposta esta sendo feita.
     * @param colocacao A colocacao esperada do time na aposta.
     * @param valor O valor da aposta.
     */
    public Aposta(Time time, Campeonato campeonato, int colocacao, double valor) {
        this.time = time;
        this.campeonato = campeonato;
        this.colocacao = colocacao;
        this.valor = valor;
    }

    /**
     * Obtem o time selecionado na aposta.
     * 
     * @return O time selecionado na aposta.
     */
    public Time getTime() {
        return time;
    }

    /**
     * Define o time selecionado na aposta.
     * 
     * @param time O time selecionado na aposta.
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Obtem o campeonato em que a aposta esta sendo feita.
     * 
     * @return O campeonato em que a aposta esta sendo feita.
     */
    public Campeonato getCampeonato() {
        return campeonato;
    }

    /**
     * Define o campeonato em que a aposta esta sendo feita.
     * 
     * @param campeonato O campeonato em que a aposta esta sendo feita.
     */
    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    /**
     * Obtem a colocacao esperada do time na aposta.
     * 
     * @return A colocacao esperada do time na aposta.
     */
    public int getColocacao() {
        return colocacao;
    }

    /**
     * Define a colocacao esperada do time na aposta.
     * 
     * @param colocacao A colocacao esperada do time na aposta.
     */
    public void setColocacao(int colocacao) {
        this.colocacao = colocacao;
    }

    /**
     * Obtem o valor da aposta.
     * 
     * @return O valor da aposta.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor da aposta.
     * 
     * @param valor O valor da aposta.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
}
