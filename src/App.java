import models.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Lista arvore = new Lista();

        String palavraa = "palava teste para usar na frequencia";
        String palavra = "palava teste";

        for (int i = 0; i < palavra.length(); i++) {
            char caractere = palavra.charAt(i);
            Node obj = (Node) arvore.getObjectPalavra(""+caractere);
            if( obj == null ){
                arvore.insertEnd( new Node(""+caractere, true) );
            }else{
                obj.freq += 1;
            }
        }


        while( arvore.length() != 1 ){  
            int valor = arvore.getIndexMenorFreq();
            Node nodeEsquerda = (Node)arvore.removeIndex(valor);

            int valor2 = arvore.getIndexMenorFreq();
            Node nodeDireita = (Node)arvore.removeIndex(valor2);

            int soma = nodeEsquerda.freq+nodeDireita.freq;

            arvore.insertEnd( new Node( "Node", soma, nodeEsquerda, nodeDireita ) );
        }
        
        Node raiz = (Node)arvore.removeEnd();
        
        preordem(raiz, "", "");
        // preordemMostra(raiz, "", "");
        

    }

    // public static void preordem(Node r, String _be, String _bd){
    //     if(!(r == null)){
    //         System.out.print("\n\nCaracter: " + r.caractere);
    //         if(r.left != null) _be += "0";
    //         preordem(r.left,  _be, _bd);
    //         if(r.left != null) _be += "1";
    //         preordem(r.right,  _be, _bd);
    //     }else{
    //         System.out.println();
    //         System.out.println(_be);
    //         _be = "";
    //     }
    //     // System.out.println(_bd);
    //     // _bd = "";
    // }

    public static void preordem(Node r, String _be, String _bd){
        if(!r.isLeaf){
            if(r.left != null) _be += "0";
            preordem(r.left,  _be, _bd);
            if(r.right != null) _be += "1";
            preordem(r.right,  _be, _bd);
        }else{
            System.out.print("\n\nCaracter: " + r.caractere);
            System.out.print("\nBinario: " + _be);
            _be = "";
        }
        // System.out.println(_bd);
        // _bd = "";
    }

    public static void preordemMostra(Node r, String _be, String _bd){

        if(!(r == null)){
            System.out.print("\n\nCaracter: " + r.caractere);
            // System.out.print("\nFrequencia: " + r.freq);
            // System.out.print("\nBrinario: " + r.binario);
            if(r.left != null){
                System.err.println("\nESQUERDA");
            }
            preordemMostra(r.left,  _be, _bd);
            if(r.right != null) System.err.println("\nDIREITA");
            preordemMostra(r.right, _be, _bd);
        }
        _be = "";
        _bd = "";
    }

}
