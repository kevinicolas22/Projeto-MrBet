package Lab4;

import java.util.ArrayList;
import java.util.List;

/**
Classe responsavel por gerenciar as apostas realizadas.
*/
public class GerenciadorApostas {
    private List<Aposta> apostas;

    /**
     * Construtor da classe GerenciadorApostas.
     * Inicializa a lista de apostas.
     */
    public GerenciadorApostas() {
        this.apostas = new ArrayList<>();
    }

    /**
     * Cria uma nova aposta.
     * 
     * @param time O time selecionado na aposta.
     * @param campeonato O campeonato em que a aposta esta sendo feita.
     * @param colocacao A colocacao esperada do time na aposta.
     * @param valor O valor da aposta.
     * @return Uma mensagem indicando o resultado da criacao da aposta.
     */
    public String criarAposta(Time time, Campeonato campeonato, int colocacao, double valor) {
        if (time == null) {
            return "TIME NAO EXISTE!\n";
        }

        if (campeonato == null) {
            return "CAMPEONATO NAO EXISTE!\n";
        }

        if (!campeonato.contemTime(time)) {
            return "TIME NAO FAZ PARTE DO CAMPEONATO!\n";
        }

        if (colocacao <= 0 || colocacao > campeonato.getLimiteParticipantes()) {
            return "COLOCACAO INVALIDA!\n";
        }

        if (valor <= 0) {
            return "VALOR INVALIDO!\n";
        }

        Aposta aposta = new Aposta(time, campeonato, colocacao, valor);
        apostas.add(aposta);
        return "APOSTA FEITA!\n";
    }

    /**
     * Exibe as apostas realizadas.
     * 
     * @return Uma representacao em formato de string das apostas realizadas.
     */
    public String exibirApostas() {
        StringBuilder sb = new StringBuilder();
        if (apostas.isEmpty()) {
            sb.append("NENHUMA APOSTA FEITA\n");
        } else {
            sb.append("Apostas:\n\n");
            int numeroAposta = 1;
            for (Aposta aposta : apostas) {
                sb.append(numeroAposta).append(". [").append(aposta.getTime().getId())
                        .append("] ").append(aposta.getTime().getNome()).append(" / ")
                        .append(aposta.getTime().getMascote()).append("\n")
                        .append(aposta.getCampeonato().getNome()).append("\n")
                        .append(aposta.getColocacao()).append("/").append(aposta.getCampeonato().getLimiteParticipantes())
                        .append("\nR$ ").append(aposta.getValor()).append("\n\n");
                numeroAposta++;
            }
        }
        return sb.toString();
    }
}
