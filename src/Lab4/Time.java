package Lab4;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
/**

Classe que representa um time em um campeonato.
*/
public class Time {
    private String id;
    private String nome;
    private String mascote;
    private List<Campeonato> campeonatoQueOTimeParticipa;


    /**
     * Construtor da classe Time.
     * 
     * @param nome O nome do time.
     * @param mascote O mascote do time.
     * @param id A identificacao do time.
     */
    public Time(String nome, String mascote, String id) {
        this.id = id;
    	this.nome = nome;
        this.mascote = mascote;
        this.campeonatoQueOTimeParticipa = new ArrayList<>();
    }

    /**
     * Obtem a identificacao do time.
     * 
     * @return A identificacao do time.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Obtem o nome do time.
     * 
     * @return O nome do time.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Obtem o mascote do time.
     * 
     * @return O mascote do time.
     */
    public String getMascote() {
        return this.mascote;
    }

    /**
     * Obtem os campeonatos em que o time esta participando.
     * 
     * @return Uma representacao em formato de string dos campeonatos em que o time participa.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    /**

    Verifica se o objeto atual e igual ao objeto fornecido.
    @param obj Objeto a ser comparado.
    @return true se os objetos forem iguais, false caso contrario.
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Time other = (Time) obj;
        return Objects.equals(id, other.id);
    }
    /**

    Obtem uma representacao dos campeonatos em que o time esta participando.

    @return Uma string com os campeonatos em que o time esta participando.
    */
    public String getCampeonatosParticipando() {
        if (campeonatoQueOTimeParticipa.isEmpty()) {
            return "O time nao esta participando de nenhum campeonato.\n";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Campeonatos do ").append(this.nome).append(":\n");
        for (Campeonato campeonato : campeonatoQueOTimeParticipa) {
            sb.append("* ").append(campeonato.getNome()).append(" - ").append(campeonato.getNumParticipantes()).append("/").append(campeonato.getLimiteParticipantes()).append("\n");
        }
        return sb.toString();
    }
    

    /**
     * Adiciona um campeonato a lista de campeonatos em que o time participa.
     * 
     * @param campeonato O campeonato a ser adicionado.
     */
    public void adicionarCampeonatoParticipando(Campeonato campeonato) {
        this.campeonatoQueOTimeParticipa.add(campeonato);
    }

 
}
