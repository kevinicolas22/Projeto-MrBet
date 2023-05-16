package Lab4;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class RepositorioCampeonatoTest {

    private RepositorioCampeonato repositorio;

    @BeforeEach
    public void setUp() {
        repositorio = new RepositorioCampeonato();
    }

    @Test
    public void adicionarCampeonato_Sucesso() {
        // Arrange
        Campeonato campeonato = new Campeonato("Brasileirão Série A 2023", 20);

        // Act
        String resultado = repositorio.adicionarCampeonato(campeonato);

        // Assert
        Assert.assertEquals("CAMPEONATO ADICIONADO!\n", resultado);
        Map<String, Campeonato> campeonatos = repositorio.getCampeonatos();
        Assert.assertEquals(campeonato, campeonatos.get(campeonato.getNome()));
    }
    
    @Test
    public void adicionarCampeonato_CampeonatoJaExiste() {
        // Arrange
        Campeonato campeonato = new Campeonato("Brasileirão Série A 2023", 20);
        repositorio.adicionarCampeonato(campeonato);

        // Act
        String resultado = repositorio.adicionarCampeonato(campeonato);

        // Assert
        Assert.assertEquals("CAMPEONATO JA EXISTE!\n", resultado);
    }
    
    @Test
    public void incluirTimeEmCampeonato_Sucesso() {
        // Arrange
        Campeonato campeonato = new Campeonato("Brasileirão Série A 2023", 20);
		 Time time = new Time("250_PB", "Campinense", "Raposa");
        repositorio.adicionarCampeonato(campeonato);

        // Act
        String resultado = repositorio.incluirTimeEmCampeonato(campeonato.getNome(), time);

        // Assert
        Assert.assertEquals("TIME INCLUIDO NO CAMPEONATO!\n", resultado);
        Assert.assertTrue(campeonato.contemTime(time));
    }
    
    @Test
    public void incluirTimeEmCampeonato_CampeonatoNaoExiste() {
        // Arrange
		 Time time = new Time("250_PB", "Campinense", "Raposa");

        // Act
        String resultado = repositorio.incluirTimeEmCampeonato("Brasileirão Série A 2023", time);

        // Assert
        Assert.assertEquals("CAMPEONATO NAO EXISTE!\n", resultado);
    }
    
    @Test
    public void incluirTimeEmCampeonato_TimeNaoExiste() {
        // Arrange
        Campeonato campeonato = new Campeonato("Brasileirão Série A 2023", 20);
        repositorio.adicionarCampeonato(campeonato);

        // Act
        String resultado = repositorio.incluirTimeEmCampeonato(campeonato.getNome(), null);

        // Assert
        Assert.assertEquals("TIME NAO EXISTE!\n", resultado);
    }
    
    @Test
    public void incluirTimeEmCampeonato_NumeroMaximoParticipantesExcedido() {
        // Arrange
        Campeonato campeonato = new Campeonato("Brasileirão Série A 2023", 1);
		Time time1 = new Time("250_PB", "Campinense", "Raposa");
	    Time time2 = new Time("252_PB", "Alagoas", "Cachorro");
        repositorio.adicionarCampeonato(campeonato);
        
        // Act
        repositorio.incluirTimeEmCampeonato(campeonato.getNome(), time1);
        String resultado2 = repositorio.incluirTimeEmCampeonato(campeonato.getNome(), time2);
        
        // Assert
        Assert.assertEquals("NUMERO DE PARTICIPANTES DESTE CAMPEONATO FOI EXCEDIDO!\n", resultado2);    
    }
    
    @Test
    public void incluirTimeEmCampeonato_IncluirTimeCampeonatoRepetido() {
        // Arrange
	 	Campeonato campeonato = new Campeonato("Brasileirão série A 2023", 2);
	    Time time = new Time("250_PB", "Campinense", "Raposa");
        repositorio.adicionarCampeonato(campeonato);

        // Act
        repositorio.incluirTimeEmCampeonato(campeonato.getNome(), time);
        String resultado = repositorio.incluirTimeEmCampeonato(campeonato.getNome(), time);


        // Assert
        Assert.assertEquals("TIME JA ESTA INSCRITO NO CAMPEONATO!\n", resultado);
    }
    
    @Test
    public void verificarTimeNoCampeonato_TimeIncluidoNoCampeonato() {
        // Arrange
    	Campeonato campeonato = new Campeonato("Brasileirão série A 2023", 2);
	    Time time = new Time("250_PB", "Campinense", "Raposa");
        repositorio.adicionarCampeonato(campeonato);
        repositorio.incluirTimeEmCampeonato(campeonato.getNome(), time);

        // Act
        String resultado = repositorio.verificarTimeNoCampeonato(time, campeonato.getNome());

        // Assert
        Assert.assertEquals("TIME FAZ PARTE DO CAMPEONATO!\n", resultado);
    }
 
	 @Test
	    public void verificarTimeNoCampeonato_TimeNaoIncluidoNoCampeonato() {
	        // Arrange
		 	Campeonato campeonato = new Campeonato("Brasileirão série A 2023", 2);
		    Time time = new Time("250_PB", "Campinense", "Raposa");
	        repositorio.adicionarCampeonato(campeonato);
	        // Act
	        String resultado = repositorio.verificarTimeNoCampeonato(time, campeonato.getNome());
	        // Assert
	        Assert.assertEquals("TIME NAO FAZ PARTE DO CAMPEONATO!\n", resultado);
	    }
	 
	 @Test
	    public void verificarTimeNoCampeonato_CampeonatoNaoExiste() {
		 	Campeonato campeonato = new Campeonato("Brasileirão série A 2023", 2);
		    Time time = new Time("250_PB", "Campinense", "Raposa");
	        repositorio.incluirTimeEmCampeonato(campeonato.getNome(), time);

	        // Act
	        String resultado = repositorio.verificarTimeNoCampeonato(time, campeonato.getNome());

	        // Assert
	        Assert.assertEquals("CAMPEONATO NAO EXISTE!\n", resultado);
	    }
	 
	 @Test
	    public void verificarTimeNoCampeonato_TimeNaoExistente() {
	        // Arrange
	        Campeonato campeonato = new Campeonato("Brasileirão Série A 2023", 20);
	        repositorio.adicionarCampeonato(campeonato);
	        // Act
	        String resultado = repositorio.verificarTimeNoCampeonato(null, campeonato.getNome());

	        // Assert
	        Assert.assertEquals("TIME NAO EXISTE!\n", resultado);
	    }
}
