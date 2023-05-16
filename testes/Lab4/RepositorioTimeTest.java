package Lab4;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class RepositorioTimeTest {

    private RepositorioTime repositorio;

    @BeforeEach
    public void setUp() {
        repositorio = new RepositorioTime();
    }

    @Test
    public void incluirTime_Sucesso() {
        // Arrange
		Time time = new Time("250_PB", "Campinense", "Raposa");

        // Act
        String resultado = repositorio.incluirTime(time);

        // Assert
        Assert.assertEquals("INCLUSAO REALIZADA!\n", resultado);
        Map<String, Time> times = repositorio.getTimes();
        Assert.assertEquals(time, times.get(time.getId()));
    }

    @Test
    public void incluirTime_TimeJaExiste() {
        // Arrange
		Time time = new Time("250_PB", "Campinense", "Raposa");
        repositorio.incluirTime(time);

        // Act
        String resultado = repositorio.incluirTime(time);

        // Assert
        Assert.assertEquals("TIME JA EXISTE!\n", resultado);
    }
    
    @Test
    public void getCampeonatosParticipando_NenhumCampeonato() {
        // Arrange
		Time time = new Time("250_PB", "Campinense", "Raposa");
        // Act
        String resultado = time.getCampeonatosParticipando();

        // Assert
        Assert.assertEquals("O time nao esta participando de nenhum campeonato.\n", resultado);
    }

   
}

