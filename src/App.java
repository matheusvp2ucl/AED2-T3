
import models.*;

public class App {
    public static void main(String[] args) throws Exception {

        FGM_Compacter compacter = new FGM_Compacter();
        compacter.Compactar("palava teste");

        System.out.println(compacter.getCabecalho());
        System.out.println(compacter.getTextoCompactado());

        // // Instaciação de Variaveis necessarias !
        // Lista arvore = new Lista();
        // Lista binarios = new Lista();

        // // String palavra = "palava teste para usar na frequencia";
        // String palavra = "palava teste";

        // // Pega a frequencia de caracteres na string e mapeando dentro de uma
        // // lista encadeada, ja com o Node para inserir na lista o mesmo.
        // for (int i = 0; i < palavra.length(); i++) {
        //     char caractere = palavra.charAt(i);
        //     // Função criada na lista encadeada para buscar o caracter dentro da mesma
        //     // Caso não exista retorna null
        //     Node obj = (Node) arvore.getObjectPalavra("" + caractere);
        //     // Se retornar null, iremos criar o caracter e inserir ja para a contagem da
        //     // frequencia
        //     // Se não retornar null, ele vai retornar o obj Node do caracter e somar mais 1
        //     // no atributo freq do objeto !
        //     if (obj == null) {
        //         arvore.insertEnd(new Node("" + caractere));
        //     } else {
        //         obj.freq += 1;
        //     }
        // }

        // // De acordo com a regra do Algoritimo de Huffman, pegando os 2 caracteres de
        // // menor frequencia da lista
        // // retornando e somando para criar uma arvore com os dois e inserindo no final
        // // da lista com valor, assim ate
        // // formando a arvore no Node Raiz onde esta somente no primeiro indice da lista.
        // while (arvore.length() != 1) {
        //     int valor = arvore.getIndexMenorFreq();
        //     Node nodeEsquerda = (Node) arvore.removeIndex(valor);

        //     int valor2 = arvore.getIndexMenorFreq();
        //     Node nodeDireita = (Node) arvore.removeIndex(valor2);

        //     int soma = nodeEsquerda.freq + nodeDireita.freq;

        //     arvore.insertEnd(new Node("Node", soma, nodeEsquerda, nodeDireita));
        // }

        // Node raiz = (Node) arvore.removeEnd();

        // // Função recusiva para conseguir mapear o binario pela frequencia da arvore
        // // criada !
        // getBinary(raiz, "", binarios);

        // // Faz a compactação das palavras, em Binario
        // String palavraBinario = "";
        // for (int i = 0; i < palavra.length(); i++) {
        //     char caractere = palavra.charAt(i);
        //     Objeto obj = (Objeto) binarios.getLetraBinario("" + caractere);
        //     if (obj != null) {
        //         palavraBinario += obj.valor;
        //     } else {
        //         System.out.println("Letra não encontrada => " + caractere);
        //     }
        // }

        // Lista mapCabecalho = new Lista();
        // // Refazer nossa lista de Binarios novamente com os Objetos
        // String cabecalho = binarios.toString();
        // String[] baseSplit = cabecalho.split("¨");
        // for (String string : baseSplit) {
        //     String[] base = string.split(":");
        //     mapCabecalho.insertEnd( new Objeto(base[0], base[1]) );
        // }

        // // Descriptação do Binario
        // String palavraDescript = "";
        // String joinBin = "";
        // for (int i = 0; i < palavraBinario.length(); i++) {
        //     char binario = palavraBinario.charAt(i);
        //     joinBin += binario;
        //     Objeto obj = (Objeto) mapCabecalho.getBinarioLetra(joinBin);
        //     if (obj != null) {
        //         palavraDescript += obj.chave;
        //         joinBin = "";
        //     }
        // }

        // Save.compactar("imagemCompactada", ".zip", binarios.toString(), palavraBinario);
        // System.out.println();
        // System.out.println(palavraBinario);
        // System.out.println(palavraDescript);

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
