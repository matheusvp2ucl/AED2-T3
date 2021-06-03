package models;

public class Arvore {

    private Node raiz;

    public Arvore() {
        raiz = null;
    }

    public void insereEsquerda(Node node) {
        raiz.setLeft(node);
    }

    public void insereDireita(Node node) {
        raiz.setRight(node);
    }

    public void inserirRaiz(String chave, int valor) {
        raiz = new Node(chave, valor);
    }

    public Node getRaiz() {
        return raiz;
    }

}
