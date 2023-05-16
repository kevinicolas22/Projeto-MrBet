package Lab4;

import java.util.*;
/**
 * Classe principal que contem o metodo main para executar o programa MrBet.
 */
public class MrBet {

	/**
     * Metodo main para iniciar o programa MrBet.
     *
     * @param args Argumentos de linha de comando.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RepositorioTime repositorioTime = new RepositorioTime();
        RepositorioCampeonato repositorioCampeonato = new RepositorioCampeonato();
        GerenciadorApostas gerenciadorApostas = new GerenciadorApostas();
        
        String escolha, escolhaB, escolhaT = "";
        while (true) {
            escolha = exibirMenu(scanner);
            escolhaB = "";
            escolhaT = "";

            if (escolha.equals("B")) {
                escolhaB = exibirMenuB(scanner);
            } else if (escolha.equals("T")) {
                escolhaT = exibirMenuT(scanner);
            }

            comando(escolha, escolhaB, escolhaT,repositorioTime,repositorioCampeonato, gerenciadorApostas, scanner);
        }
    }
    /**
     * Exibe o menu principal e retorna a escolha do usuario.
     *
     * @param scanner Scanner para leitura de entrada do usuario.
     * @return A escolha do usuario.
     */
    private static String exibirMenu(Scanner scanner) {
        System.out.println("----MrBet----\n\n" +
                "(M)Minha inclusao de times\n" +
                "(R)Recuperar time\n" +
                "(.)Adicionar campeonato\n" +
                "(B)Bora incluir time em campeonato e Verificar se time esta em campeonato\n" +
                "(E)Exibir campeonatos que o time participa\n" +
                "(T)Tentar a sorte e status\n" +
                "(!)Ja pode fechar o programa!\n" +
                "\n" +
                "Opcao> ");
        return scanner.nextLine().toUpperCase();
    }
    /**
     * Exibe o menu para incluir time em um campeonato ou verificar se o time esta em um campeonato.
     *
     * @param scanner              Scanner para leitura de entrada do usuario.
     * @return A opcao selecionada pelo usuario.
     */
    private static String exibirMenuB(Scanner scanner) {
        System.out.println("(I)ncluir time em campeonato\n" +
                "(V)erificar se time esta em campeonato\n" +
                "\n" +
                "Opcao> ");
        return scanner.nextLine().toUpperCase();
    }
    /**
     * Exibe o menu para realizar apostas ou exibir o status das apostas.
     *
     * @param scanner              Scanner para leitura de entrada do usuario.
     * @return A opcao selecionada pelo usuario.
     */
    private static String exibirMenuT(Scanner scanner) {
        System.out.println("(A)postar\n" +
                "(S)tatus das Apostas\n" +
                "\n" +
                "Opcao> ");
        return scanner.nextLine().toUpperCase();
    }
    /**
     * Executa o comando correspondente à escolha do usuario.
     *
     * @param opcao             Escolha do usuario no menu principal.
     * @param opcaoB            Escolha do usuario no menu B.
     * @param opcaoT            Escolha do usuario no menu T.
     * @param repositorioTime   Repositorio de times.
     * @param repositorioCampeonato Repositorio de campeonatos.
	 * @param gerenciadorApostas Gerenciador de apostas.
	 * @param scanner Scanner para leitura de entrada do usuario.
	 */
    private static void comando(String opcao, String opcaoB, String opcaoT, RepositorioTime repositorioTime, RepositorioCampeonato repositorioCampeonato, GerenciadorApostas gerenciadorApostas, Scanner scanner) {
        switch (opcao) {
            case "M":
                incluirTime( scanner, repositorioTime);
                break;
            case "R":
                recuperarTime( scanner, repositorioTime);
                break;
            case ".":
                adicionarCampeonato(scanner, repositorioCampeonato);
                break;
            case "B":
                switch (opcaoB) {
                    case "I":
                        IncluirTimeEmCampeonato(scanner, repositorioTime, repositorioCampeonato);
                        break;
                    case "V":
                        verificarTimeNoCampeonato(scanner, repositorioTime, repositorioCampeonato);
                        break;
                    default:
                        System.out.println("Opcao invalida.\n");
                        break;
                }
                break;
            case "E":
                exibirCampeonatosDoTime(scanner, repositorioTime);
                break;
            case "T":
                switch (opcaoT) {
                    case "A":
                        realizarAposta(scanner, repositorioTime, repositorioCampeonato, gerenciadorApostas);
                        break;
                    case "S":
                        exibirApostas(gerenciadorApostas);
                        break;
                    default:
                        System.out.println("Opcao invalida.\n");
                        break;
                }
                break;
             case "!":
                 sai();
                 break;
             default:
                 System.out.println("Opcao invalida.\n");
    		}
    	}
    /**
     * Realiza a inclusao de um time.
     *
     * @param scanner          Scanner para leitura de entrada do usuario.
     * @param repositorioTime  Repositorio de times.
     */
    private static void incluirTime(Scanner scanner, RepositorioTime repositorioTime) {
        System.out.print("Codigo: ");
        String codigoTime = scanner.nextLine().toUpperCase();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Mascote: ");
        String mascote = scanner.nextLine();
        Time time = new Time(nome, mascote, codigoTime);
        System.out.print(repositorioTime.incluirTime(time));
    }
    /**
     * Recupera as informacoes de um time.
     *
     * @param scanner         Scanner para leitura de entrada do usuario.
     * @param repositorioTime Repositorio de times.
     */
    private static void recuperarTime(Scanner scanner, RepositorioTime repositorioTime) {
   	 System.out.print("Codigo: ");
   	 String codigoTime = scanner.nextLine().toUpperCase();
     System.out.print(repositorioTime.getTimeAtributosRecuoerarTime(codigoTime));  	    
   }
    /**
     * Adiciona um campeonato.
     *
     * @param scanner              Scanner para leitura de entrada do usuario.
     * @param repositorioCampeonato Repositorio de campeonatos.
     */
    private static void adicionarCampeonato(Scanner scanner, RepositorioCampeonato repositorioCampeonato) {
        System.out.print("Campeonato: ");
        String nomeCampeonato = scanner.nextLine().toUpperCase();
        System.out.print("Participantes: ");
        int limiteParticipantes = Integer.parseInt(scanner.nextLine());
        Campeonato campeonato = new Campeonato(nomeCampeonato, limiteParticipantes);
        System.out.print(repositorioCampeonato.adicionarCampeonato(campeonato));  	    
    }
    /**
     * Realiza a inclusao de um time em um campeonato.
     *
     * @param scanner              Scanner para leitura de entrada do usuario.
     * @param repositorioTime      Repositorio de times.
     * @param repositorioCampeonato Repositorio de campeonatos.
     */
    private static void IncluirTimeEmCampeonato(Scanner scanner, RepositorioTime repositorioTime, RepositorioCampeonato repositorioCampeonato ) {
        System.out.print("Campeonato: ");
        String nomeCampeonato = scanner.nextLine().toUpperCase();
        System.out.print("Codigo do time: ");
        String codigoTime = scanner.nextLine().toUpperCase();
        Time time = repositorioTime.getTime(codigoTime);
        System.out.print(repositorioCampeonato.incluirTimeEmCampeonato(nomeCampeonato, time));  	    
    }
   
    /**
     * Verifica se um time esta participando de um campeonato.
     *
     * @param scanner              Scanner para leitura de entrada do usuario.
     * @param repositorioTime      Repositorio de times.
     * @param repositorioCampeonato Repositorio de campeonatos.
     */
    private static void verificarTimeNoCampeonato(Scanner scanner, RepositorioTime repositorioTime, RepositorioCampeonato repositorioCampeonato) {
        System.out.print("Informe o codigo do time: "); 
    	String codigoTime = scanner.nextLine().toUpperCase();
    	Time time = repositorioTime.getTime(codigoTime);
        System.out.print("Informe o nome do campeonato: ");
        String nomeCampeonato = scanner.nextLine().toUpperCase();
        System.out.print(repositorioCampeonato.verificarTimeNoCampeonato(time, nomeCampeonato));  	    
    }
    /**
     * Exibe os campeonatos em que um time esta participando.
     *
     * @param scanner         Scanner para leitura de entrada do usuario.
     * @param repositorioTime Repositorio de times.
     */
    private static void exibirCampeonatosDoTime(Scanner scanner, RepositorioTime repositorioTime) {  
        System.out.print("Time: ");
        String codigoTime = scanner.nextLine().toUpperCase();
        Time time = repositorioTime.getTime(codigoTime);
        System.out.print(time.getCampeonatosParticipando());
    }
    /**
    * Realiza uma aposta em um campeonato.
    *
    * @param scanner Scanner para leitura de entrada do usuario.
    * @param repositorioTime Repositorio de times.
    * @param repositorioCampeonato Repositorio de campeonatos.
    * @param gerenciadorApostas Gerenciador de apostas.
    */
    private static void realizarAposta(Scanner scanner, RepositorioTime repositorioTime, RepositorioCampeonato repositorioCampeonato, GerenciadorApostas gerenciadorApostas) {
        System.out.print("Informe o codigo do time: ");
        String codigoTime = scanner.nextLine().toUpperCase();
        Time time = repositorioTime.getTime(codigoTime);
        System.out.print("Nome do campeonato: ");
        String codigoCampeonato = scanner.nextLine().toUpperCase();
        Campeonato campeonato = repositorioCampeonato.getCampeonato(codigoCampeonato);
        System.out.print("Colocacao: ");
        int colocacao = Integer.parseInt(scanner.nextLine());
        System.out.print("Valor da aposta: R$");
        double valor = Double.parseDouble(scanner.nextLine());
        System.out.print(gerenciadorApostas.criarAposta(time, campeonato, colocacao, valor));
    }
    /**
     * Exibe todas as apostas realizadas.
     *
     * @param gerenciadorApostas Gerenciador de apostas.
     */
    public static void exibirApostas(GerenciadorApostas gerenciadorApostas) {
        System.out.println("Apostas:\n");
        System.out.print(gerenciadorApostas.exibirApostas());
    }
    /**
     * Finaliza a execucao do programa.
     */
	private static void sai() {
		System.out.println("\nPor hoje e so pessoal!\n");
		System.exit(0);
	}
  
}