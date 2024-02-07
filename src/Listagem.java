import java.util.*;

public class Listagem {

    class GerenciadorDeListagem {
        private List<Tarefas> tarefas = new ArrayList<>();
        public GerenciadorDeTarefas gerenciadorDeTarefas = new GerenciadorDeTarefas();


        public void listarTarefas() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n===== LISTAGEM DE TAREFAS =====\n");
            System.out.println("[1] LISTAR POR CATEGORIA");
            System.out.println("[2] LISTAR POR PRIORIDADE");
            System.out.println("[3] LISTAR POR STATUS");
            System.out.println("ESCOLHA UMA OPÇÃO:");
            String subOpcao = scanner.nextLine();
            switch (subOpcao) {
                case "1":
                    listarPorCategoria();
                    break;
                case "2":
                    listarPorPrioridade();
                    break;
                case "3":
                    listarPorStatus();
                    break;
                default:
                    System.out.println("Opção inválida no submenu.");
                    break;
            }
        }

        public void listarPorCategoria() {
            System.out.println("\n====LISTAR TAREFAS POR CATEGORIA=====\n");
            Map<String, List<Tarefas>> tarefasPorCategoria = new HashMap<>();
            for (Tarefas tarefa : tarefas) {
                if (!tarefasPorCategoria.containsKey(tarefa.getCategoria())) {
                    tarefasPorCategoria.put(tarefa.getCategoria(), new ArrayList<>());
                }
                tarefasPorCategoria.get(tarefa.getCategoria()).add(tarefa);
            }
            for (Map.Entry<String, List<Tarefas>> entry : tarefasPorCategoria.entrySet()) {
                System.out.println("Categoria: " + entry.getKey());
                for (Tarefas tarefa : entry.getValue()) {
                    System.out.println(tarefa);
                }
            }
        }

        public void listarPorPrioridade() {
            System.out.println("\n====LISTAR TAREFAS POR PRIORIDADE=====\n");
            Map<Integer, List<Tarefas>> tarefasPorPrioridade = new TreeMap<>();
            for (Tarefas tarefa : tarefas) {
                if (!tarefasPorPrioridade.containsKey(tarefa.getPrioridade())) {
                    tarefasPorPrioridade.put(tarefa.getPrioridade(), new ArrayList<>());
                }
                tarefasPorPrioridade.get(tarefa.getPrioridade()).add(tarefa);
            }
            for (Map.Entry<Integer, List<Tarefas>> entry : tarefasPorPrioridade.entrySet()) {
                System.out.println("Prioridade: " + entry.getKey());
                for (Tarefas tarefa : entry.getValue()) {
                    System.out.println(tarefa);

                }

            }

        }

        public void listarPorStatus() {
            System.out.println("\n====LISTAR TAREFAS POR STATUS=====\n");
            Map<String, List<Tarefas>> tarefasPorStatus = new HashMap<>();
            for (Tarefas tarefa : tarefas) {
                if (!tarefasPorStatus.containsKey(tarefa.getStatus())) {
                    tarefasPorStatus.put(tarefa.getStatus(), new ArrayList<>());
                }
                tarefasPorStatus.get(tarefa.getStatus()).add(tarefa);
            }
            for (Map.Entry<String, List<Tarefas>> entry : tarefasPorStatus.entrySet()) {
                System.out.println("Status: " + entry.getKey());
                for (Tarefas tarefa : entry.getValue()) {
                    System.out.println(tarefa);
                }
            }
        }
    }
}
