package Lab4;

import java.util.HashMap;
import java.util.Map;
/**

Classe responsavel por armazenar e manipular os times em um repositorio.
*/

public class RepositorioTime {
    private Map<String, Time> times;
    
    /**
     * Construtor da classe RepositorioTime.
     * Inicializa o mapa de times.
     */
    public RepositorioTime() {
        this.times = new HashMap<>();
    }

    /**
     * Inclui um novo time no repositorio.
     * 
     * @param time O time a ser incluido.
     * @return Uma mensagem indicando o resultado da inclusao do time.
     */
    public String incluirTime(Time time) {
        if (times.containsKey(time.getId())) {
            return "TIME JA EXISTE!\n";
        }
        
        this.times.put(time.getId(), time);
        System.out.println(times.size());
        return "INCLUSAO REALIZADA!\n";
    }

    /*
     * 
     * Obtem um time com base no seu codigo.
     * 
     * @param codigo O codigo do time.
     * @return O objeto Time correspondente ao codigo fornecido.
     */
    public Time getTime(String codigo) {
        return times.get(codigo);
    }

    /**
     * Obtem uma representacao em formato de string dos atributos de um time com base no seu codigo.
     * 
     * @param codigo O codigo do time.
     * @return Uma string contendo os atributos do time.
     */
    public String getTimeAtributosRecuoerarTime(String codigo) {
        Time time = this.getTime(codigo);
        return "[" + time.getId() + "] " + time.getNome() + " / " + time.getMascote()+ "\n";
    }

    /**
     * Obtem todos os times armazenados no repositorio.
     * 
     * @return Um mapa contendo todos os times armazenados.
     */
    public Map<String, Time> getTimes() {
        return this.times;
    }
}
