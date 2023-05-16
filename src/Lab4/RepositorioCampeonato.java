package Lab4;

import java.util.HashMap;
import java.util.Map;

/**

Classe que representa um repositorio de campeonatos.
*/
public class RepositorioCampeonato {
    private Map<String, Campeonato> campeonatos = new HashMap<>();

    /**
     * Construtor da classe RepositorioCampeonato.
     */
    public RepositorioCampeonato() {
        this.campeonatos = new HashMap<>();
    }

    /**
     * Adiciona um campeonato ao repositorio.
     *
     * @param campeonato O campeonato a ser adicionado.
     * @return Uma mensagem indicando o resultado da operacao.
     */
    public String adicionarCampeonato(Campeonato campeonato) {
        if (this.campeonatos.containsKey(campeonato.getNome())) {
            return "CAMPEONATO JA EXISTE!\n";
        }

        this.campeonatos.put(campeonato.getNome(), campeonato);
        return "CAMPEONATO ADICIONADO!\n";
    }

    /**
     * Obtem o campeonato correspondente ao nome fornecido.
     *
     * @param nomeCampeonato O nome do campeonato a ser buscado.
     * @return O objeto Campeonato correspondente ao nome fornecido, ou null se nao for encontrado.
     */
    public Campeonato getCampeonato(String nomeCampeonato) {
        return campeonatos.get(nomeCampeonato);
    }

    /**
     * Inclui um time em um campeonato.
     *
     * @param nomeCampeonato O nome do campeonato.
     * @param time O time a ser incluido.
     * @return Uma mensagem indicando o resultado da operacao.
     */
    public String incluirTimeEmCampeonato(String nomeCampeonato, Time time) {
        Campeonato campeonato = this.getCampeonato(nomeCampeonato);

        if (campeonato == null) {
            return "CAMPEONATO NAO EXISTE!\n";
        }

        if (time == null) {
            return "TIME NAO EXISTE!\n";
        }

        if (!campeonato.temEspacoParaTime(time)) {
            return "NUMERO DE PARTICIPANTES DESTE CAMPEONATO FOI EXCEDIDO!\n";
        }

        if (campeonato.contemTime(time)) {
            return "TIME JA ESTA INSCRITO NO CAMPEONATO!\n";
        } else {
            campeonato.adicionarTime(time);
            time.adicionarCampeonatoParticipando(campeonato);
            return "TIME INCLUIDO NO CAMPEONATO!\n";
        }
    }

    /**
     * Obtem o mapa de campeonatos armazenados no repositorio.
     *
     * @return O mapa de campeonatos.
     */
    public Map<String, Campeonato> getCampeonatos() {
        return this.campeonatos;
    }

    /**
     * Verifica se um time faz parte de um campeonato.
     *
     * @param time O time a ser verificado.
     * @param nomeCampeonato O nome do campeonato.
     * @return Uma mensagem indicando se o time faz parte ou nao do campeonato.
     */
    public String verificarTimeNoCampeonato(Time time, String nomeCampeonato) {
		Campeonato campeonato = this.getCampeonato(nomeCampeonato);
		
	    if (campeonato == null) {
	        return "CAMPEONATO NAO EXISTE!\n";
	    }
	    
	    if (time == null) {
	        return "TIME NAO EXISTE!\n";
	    }

	    if (campeonato.contemTime(time)) {
	    	return "TIME FAZ PARTE DO CAMPEONATO!\n";
	    } else {
	    	return "TIME NAO FAZ PARTE DO CAMPEONATO!\n";
	    }
	}
}
