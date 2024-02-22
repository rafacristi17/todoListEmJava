import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Listagem listagem = new Listagem();
        Listagem.GerenciadorDeListagem gerenciadorDeListagem = listagem.new GerenciadorDeListagem();
        GerenciadorDeTarefas gerenciadorDeTarefas = new GerenciadorDeTarefas();

        boolean rodando = true;
        while (rodando) {

            System.out.println("\n=====TODO LIST=====\n");
            System.out.println("[1] CRIAR TAREFAS");
            System.out.println("[2] LISTAR TAREFAS");
            System.out.println("[3] PROCURAR TAREFAS");
            System.out.println("[4] ATUALIZAR TAREFA");
            System.out.println("[5] DELETAR TAREFAS");
            System.out.println("[6] SAIR DO SISTEMA");
            System.out.println("ESCOLHA UMA OPÇÃO");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    gerenciadorDeTarefas.criarTarefa();
                    break;
                case "2":
                    gerenciadorDeListagem.listarTarefas();
                    break;
                case "3":
                    gerenciadorDeTarefas.procurarTarefas();
                    break;
                case "4":
                    gerenciadorDeTarefas.atualizarTarefas();
                    break;
                case "5":
                    gerenciadorDeTarefas.deletarTarefa();
                    break;
                case "6":
                    rodando = false;
                    System.out.print("Saindo do sistema... ");
                    break;
                default:
                    System.out.println(" Opção inválida, escolha uma das opções");
                    break;
            }

        }
    }
}