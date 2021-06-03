import models.*;

public class App {
    public static void main(String[] args) throws Exception {

        Lista arvore = new Lista();

        String palavraa = "palava teste para usar na frequencia";
        String palavra = "palava teste";

        for (int i = 0; i < palavra.length(); i++) {
            char caractere = palavra.charAt(i);
            Node obj = (Node) arvore.getObjectPalavra("" + caractere);
            if (obj == null) {
                arvore.insertEnd(new Node("" + caractere, true));
            } else {
                obj.freq += 1;
            }
        }

        while (arvore.length() != 1) {
            int valor = arvore.getIndexMenorFreq();
            Node nodeEsquerda = (Node) arvore.removeIndex(valor);

            int valor2 = arvore.getIndexMenorFreq();
            Node nodeDireita = (Node) arvore.removeIndex(valor2);

            int soma = nodeEsquerda.freq + nodeDireita.freq;

            arvore.insertEnd(new Node("Node", soma, nodeEsquerda, nodeDireita));
        }

        Node raiz = (Node) arvore.removeEnd();

        Lista binarios = new Lista();

        getBinary(raiz, "", binarios);

        System.out.println(binarios);

    }

    public static void getBinary(Node r, String _be, Lista binarios) {
        if (r.left != null) {
            enterLeft(r, _be, binarios);
        }

        if (r.right != null) {
            enterRight(r, _be, binarios);
        }

        if (!r.caractere.equals("Node")) {
            binarios.insertEnd(new Objeto(r.caractere, _be));
        }
        _be = "";

    }

    public static void enterLeft(Node r, String _be, Lista binarios) {
        _be += "0";
        getBinary(r.left, _be, binarios);
    }

    public static void enterRight(Node r, String _be, Lista binarios) {
        _be += "1";
        getBinary(r.right, _be, binarios);
    }
}
