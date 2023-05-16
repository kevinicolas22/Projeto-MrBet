package Lab4;

import java.util.ArrayList;
import java.util.List;

	/**
	
	Classe que representa um campeonato.
	*/
public class Campeonato {
    private String nome;
    private int limiteParticipantes;
    private List<Time> times;

    /**
     * Construtor da classe Campeonato.
     * 
     * @param nome O nome do campeonato.
     * @param limiteParticipantes O limite de participantes no campeonato.
     */
    public Campeonato(String nome, int limiteParticipantes) {
        this.nome = nome;
        this.limiteParticipantes = limiteParticipantes;
        this.times = new ArrayList<>();
    }

    /**
     * Obtem o nome do campeonato.
     * 
     * @return O nome do campeonato.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtem o limite de participantes no campeonato.
     * 
     * @return O limite de participantes no campeonato.
     */
    public int getLimiteParticipantes() {
        return limiteParticipantes;
    }

    /**
     * Obtem o numero de participantes no campeonato.
     * 
     * @return O numero de participantes no campeonato.
     */
    public int getNumParticipantes() {
        return times.size();
    }

    /**
     * Obtem a lista de times participantes do campeonato.
     * 
     * @return A lista de times participantes do campeonato.
     */
    public List<Time> getTimes() {
        return times;
    }
    
    /**
     * Adiciona um time a lista de times participantes do campeonato.
     * 
     * @param time O time a ser adicionado.
     */
    public void adicionarTime(Time time) {
        this.times.add(time);
    }

    /**
     * Verifica se ha espaco para adicionar um time no campeonato.
     * 
     * @param time O time a ser verificado.
     * @return true se houver espaco para adicionar o time, false caso contrario.
     */
    public boolean temEspacoParaTime(Time time) {
        if (times.size() >= limiteParticipantes) {
            return false;
        }
        return true;
    }


    /**
     * Verifica se o campeonato e igual a outro objeto, comparando seus nomes.
     * 
     * @param obj O objeto a ser comparado.
     * @return true se os campeonatos forem iguais, false caso contrario.
     */

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Campeonato) {
            Campeonato c = (Campeonato) obj;
            return nome.trim().equalsIgnoreCase(c.nome.trim());
        }
        return false;
    }
    /**
     * Obtem o codigo hash do campeonato, baseado em seu nome.
     * 
     * @return O codigo hash do campeonato.
     */
    
    @Override
    public int hashCode() {
        return this.nome.trim().hashCode();
    }
    /**
     * Verifica se o campeonato contem um determinado time.
     * 
     * @param time O time a ser verificado.
     * @return true se o campeonato contem o time, false caso contrario.
     */

    public boolean contemTime(Time time) {
        return this.times.contains(time);
    }
    /**
    * Obtem o objeto Time correspondente ao nome fornecido.
    *
    * @param nome O nome do time a ser buscado.
    * @return O objeto Time correspondente ao nome fornecido, ou null se nao for encontrado.
    */
    public Time getTime(String nome) {
        for (Time time : times) {
            if (time.getNome().equalsIgnoreCase(nome)) {
                return time;
            }
        }
        return null;
    }

	/**
	* Obtem a quantidade de times participantes do campeonato.
	*
	* @return A quantidade de times participantes do campeonato.
	*/
    public int getQuantidadeTimes() {
        return this.times.size();
    }
    /**
     * Obtem o nome do campeonato.
     *
     * @return O nome do campeonato.
     */

	public String getCampeonato() {
		return this.nome;
	}

}