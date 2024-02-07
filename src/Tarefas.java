import java.util.*;
import java.util.Scanner;
import java.util.UUID;

public class Tarefas {

    private UUID id;
    private String nome;
    private String descricao;
    private String dataTermino;
    private int prioridade;
    private String categoria;
    private String status;

    // Construtor
    public Tarefas(String nome, String descricao, String dataTermino, int prioridade, String categoria, String status) {
        this.id = this.id = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Descrição: " + descricao + ", Data de Término: " + dataTermino + ", Prioridade: " + prioridade + ", Categoria: " + categoria + ", Status: " + status;
    }
}

class GerenciadorDeTarefas {
    private List<Tarefas> tarefas = new ArrayList<>();

    public void rebalancearTarefas() {
        // Ordena a lista de tarefas com base na prioridade
        Collections.sort(tarefas, new Comparator<Tarefas>() {
            @Override
            public int compare(Tarefas t2, Tarefas t1) {
                return Integer.compare(t2.getPrioridade(), t1.getPrioridade());
            }
        });
    }

    public void criarTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n====CRIAR TAREFAS=====\n");
        System.out.println("DIGITE O NOME DA TAREFA");
        String nome = scanner.nextLine();

        System.out.println("DESCRIÇÃO DA TAREFA:");
        String descricao = scanner.nextLine();

        System.out.println("DATA DE TÉRMINO DA TAREFA:");
        String dataTermino = scanner.nextLine();

        System.out.println("PRIORIDADE (DE 1 A 5):");
        int prioridade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("CATEGORIA DA TAREFA:");
        String categoria = scanner.nextLine();

        System.out.println("STATUS DA TAREFA (TODO, DOING, DONE):");
        String status = scanner.nextLine();
        Tarefas tarefa = new Tarefas(nome, descricao, dataTermino, prioridade, categoria, status);
        tarefas.add(tarefa);

        rebalancearTarefas();

        System.out.println("\nTarefa criada com sucesso! Aqui estão os detalhes da tarefa:\n" + tarefa);
    }



    public void listarTarefas() {
        System.out.println("\n====LISTAR TAREFAS=====\n");
        for (Tarefas tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public void procurarTarefas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n====PROCURAR TAREFAS=====\n");
        System.out.println("DIGITE O NOME DA TAREFA QUE DESEJA PROCURAR:");
        String nome = scanner.nextLine();

        for (Tarefas tarefa : tarefas) {
            if (tarefa.getNome().equalsIgnoreCase(nome)) {
                System.out.println(tarefa);
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }
    public void atualizarTarefas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n====ATUALIZAR TAREFAS=====\n");
        System.out.println("DIGITE O NOME DA TAREFA QUE DESEJA ATUALIZAR:");
        String nome = scanner.nextLine();

        for (Tarefas tarefa : tarefas) {
            if (tarefa.getNome().equalsIgnoreCase(nome)) {
                System.out.println("DESCRIÇÃO DA TAREFA:");
                String descricao = scanner.nextLine();
                tarefa.setDescricao(descricao);

                System.out.println("DATA DE TÉRMINO DA TAREFA:");
                String dataTermino = scanner.nextLine();
                tarefa.setDataTermino(dataTermino);

                System.out.println("PRIORIDADE (DE 1 A 5):");
                int prioridade = scanner.nextInt();
                scanner.nextLine();
                tarefa.setPrioridade(prioridade);

                System.out.println("CATEGORIA DA TAREFA:");
                String categoria = scanner.nextLine();
                tarefa.setCategoria(categoria);

                System.out.println("STATUS DA TAREFA (TODO, DOING, DONE):");
                String status = scanner.nextLine();
                tarefa.setStatus(status);

                System.out.println("\nTarefa atualizada com sucesso! Aqui estão os detalhes da tarefa:\n" + tarefa);
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }

    public void deletarTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n====DELETAR TAREFAS=====\n");
        System.out.println("DIGITE O NOME DA TAREFA QUE DESEJA DELETAR:");
        String nome = scanner.nextLine();

        for (Tarefas tarefa : tarefas) {
            if (tarefa.getNome().equalsIgnoreCase(nome)) {
                tarefas.remove(tarefa);
                System.out.println("\nTarefa deletada com sucesso!");
                return;
            }
        }

        System.out.println("Tarefa não encontrada.");
    }



}


