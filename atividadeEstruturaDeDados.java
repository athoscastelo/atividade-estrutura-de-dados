// pilha estatica

class PilhaEstatica {
    private int tamanhoMaximo;
    private int topo;
    private int[] pilha;


    public PilhaEstatica(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.topo = -1;
        this.pilha = new int[tamanhoMaximo];
    }

    public void inserir(int dado) {
        if (!estaCheia()) {
            pilha[++topo] = dado;
        } else {
            System.out.println("pilha cheia");
        }
    }
    public int remover() {
        if (!estaVazia()) {
            return pilha[topo--];
        } else {
            System.out.println("pilha vazia");
            return -1; 
        }
    }
    public int tamanho() {
        return topo + 1;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == tamanhoMaximo - 1;
    }

    public void imprimir() {
        if (!estaVazia()) {
            System.out.print("Pilha: ");
            for (int i = 0; i <= topo; i++) {
                System.out.print(pilha[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Pilha vazia.");
        }
    }
}

// fila estatica

class FilaEstatica {
    private int tamanhoMaximo;
    private int frente, traseira, contador;
    private int[] fila;

    public FilaEstatica(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.frente = 0;
        this.traseira = -1;
        this.contador = 0;
        this.fila = new int[tamanhoMaximo];
    }
    public void inserir(int dado) {
        if (!estaCheia()) {
            traseira = (traseira + 1) % tamanhoMaximo;
            fila[traseira] = dado;
            contador++;
        } else {
            System.out.println("Fila cheia. Não é possível inserir mais elementos.");
        }
    }

    public int remover() {
        if (!estaVazia()) {
            int dadoRemovido = fila[frente];
            frente = (frente + 1) % tamanhoMaximo;
            contador--;
            return dadoRemovido;
        } else {
            System.out.println("Fila vazia. Não é possível remover elementos.");
            return -1;
        }
    }

    public int tamanho() {
        return contador;
    }

    public boolean estaVazia() {
        return contador == 0;
    }


    public boolean estaCheia() {
        return contador == tamanhoMaximo;
    }

    public void imprimir() {
        if (!estaVazia()) {
            System.out.print("Fila: ");
            int indice = frente;
            for (int i = 0; i < contador; i++) {
                System.out.print(fila[indice] + " ");
                indice = (indice + 1) % tamanhoMaximo;
            }
            System.out.println();
        } else {
            System.out.println("Fila vazia.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // teste pilha 
        PilhaEstatica pilha = new PilhaEstatica(5);
        pilha.inserir(1);
        pilha.inserir(2);
        pilha.inserir(3);
        pilha.imprimir(); 
        System.out.println("Tamanho da Pilha: " + pilha.tamanho()); 
        System.out.println("Pilha vazia? " + pilha.estaVazia()); 
        System.out.println("Pilha cheia? " + pilha.estaCheia()); 
        pilha.remover();
        pilha.imprimir();
        pilha.remover();
        pilha.remover();
        System.out.println("Pilha vazia? " + pilha.estaVazia()); 

        // teste fila

        FilaEstatica fila = new FilaEstatica(5);
        fila.inserir(1);
        fila.inserir(2);
        fila.inserir(3);
        fila.imprimir(); 
        System.out.println("Tamanho da Fila: " + fila.tamanho());
        System.out.println("Fila vazia? " + fila.estaVazia()); 
        System.out.println("Fila cheia? " + fila.estaCheia()); 
        fila.remover();
        fila.imprimir(); 
        fila.remover();
        fila.remover();
        System.out.println("Fila vazia? " + fila.estaVazia());
    }
}
