package Lab4;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GerenciadorApostasTest {

    private GerenciadorApostas gerenciadorApostas;
    private Time time;
    private Campeonato campeonato;

    @BeforeEach
    public void setUp() {
        gerenciadorApostas = new GerenciadorApostas();
		time = new Time("250_PB", "Campinense", "Raposa");
        campeonato = new Campeonato("Campeonato 1", 10);
    }

    @Test
    public void criarAposta_TimeNaoExiste() {
        // Arrange

        // Act
        String resultado = gerenciadorApostas.criarAposta(null, campeonato, 1, 100.0);

        // Assert
        Assert.assertEquals("TIME NAO EXISTE!\n", resultado);
    }

    @Test
    public void criarAposta_CampeonatoNaoExiste() {
        // Arrange

        // Act
        String resultado = gerenciadorApostas.criarAposta(time, null, 1, 100.0);

        // Assert
        Assert.assertEquals("CAMPEONATO NAO EXISTE!\n", resultado);
    }

    @Test
    public void criarAposta_TimeNaoFazParteDoCampeonato() {
        // Arrange

        // Act
        String resultado = gerenciadorApostas.criarAposta(time, campeonato, 1, 100.0);

        // Assert
        Assert.assertEquals("TIME NAO FAZ PARTE DO CAMPEONATO!\n", resultado);
    }

    @Test
    public void criarAposta_ColocacaoInvalida() {
        // Arrange
        campeonato.adicionarTime(time);

        // Act
        String resultado = gerenciadorApostas.criarAposta(time, campeonato, 11, 100.0);

        // Assert
        Assert.assertEquals("COLOCACAO INVALIDA!\n", resultado);
    }

    @Test
    public void criarAposta_ValorInvalido() {
        // Arrange
        campeonato.adicionarTime(time);

        // Act
        String resultado = gerenciadorApostas.criarAposta(time, campeonato, 1, -100.0);

        // Assert
        Assert.assertEquals("VALOR INVALIDO!\n", resultado);
    }

    @Test
    public void criarAposta_ApostaCriada() {
        // Arrange
        campeonato.adicionarTime(time);

        // Act
        String resultado = gerenciadorApostas.criarAposta(time, campeonato, 1, 100.0);

        // Assert
        Assert.assertEquals("APOSTA FEITA!\n", resultado);
    }

    @Test
    public void exibirApostas_NenhumaAposta() {
        // Arrange

        // Act
        String resultado = gerenciadorApostas.exibirApostas();

        // Assert
        Assert.assertEquals("NENHUMA APOSTA FEITA\n", resultado);
    }

}
