package Main;

import java.util.Scanner;

import Aplicacoes.Metodos;
import Entidades.Arvore;
import Entidades.No;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arvore<Integer> arvore = new Arvore<>();
        Metodos<Integer> metodos = new Metodos<>();

        System.out.print("Quantos nós deseja inserir? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite o id do nó: ");
            int id = sc.nextInt();
            System.out.println("Digite o dado do nó: ");
            int dado = sc.nextInt();
            arvore.setRaiz(inserir(arvore.getRaiz(), id, dado));
        }

        System.out.println("Árvore inicial (em ordem):");
        imprimeEmOrdem(arvore.getRaiz());
        System.out.println();

        // a. Rotação à esquerda
        if (arvore.getRaiz() != null && arvore.getRaiz().getDir() != null) {
            arvore.setRaiz(metodos.rotacaoEsquerda(arvore.getRaiz()));
            System.out.println("Árvore após rotação à esquerda (em ordem):");
            imprimeEmOrdem(arvore.getRaiz());
            System.out.println();
        } else {
            System.out.println("Rotação à esquerda não aplicada (falta de nó à direita).");
        }

        // b. Rotação à direita
        if (arvore.getRaiz() != null && arvore.getRaiz().getEsq() != null) {
            arvore.setRaiz(metodos.rotacaoDireita(arvore.getRaiz()));
            System.out.println("Árvore após rotação à direita (em ordem):");
            imprimeEmOrdem(arvore.getRaiz());
            System.out.println();
        } else {
            System.out.println("Rotação à direita não aplicada (falta de nó à esquerda).");
        }

        // c. Rotação dupla à esquerda
        // A rotação dupla à esquerda requer primeiro um cenário de rotação direita no filho da direita
        if (arvore.getRaiz() != null && arvore.getRaiz().getDir() != null) {
            arvore.setRaiz(metodos.rotacaoDuplaEsquerda(arvore.getRaiz()));
            System.out.println("Árvore após rotação dupla à esquerda (em ordem):");
            imprimeEmOrdem(arvore.getRaiz());
            System.out.println();
        } else {
            System.out.println("Rotação dupla à esquerda não aplicada (falta de nó à direita).");
        }

        // d. Rotação dupla à direita
        if (arvore.getRaiz() != null && arvore.getRaiz().getEsq() != null) {
            arvore.setRaiz(metodos.rotacaoDuplaDireita(arvore.getRaiz()));
            System.out.println("Árvore após rotação dupla à direita (em ordem):");
            imprimeEmOrdem(arvore.getRaiz());
            System.out.println();
        } else {
            System.out.println("Rotação dupla à direita não aplicada (falta de nó à esquerda).");
        }

        sc.close();
    }

    private static No<Integer> inserir(No<Integer> raiz, int id, int dado) {
        if (raiz == null) {
            return new No<Integer>(id, dado);
        }
        if (id < raiz.getId()) {
            raiz.setEsq(inserir(raiz.getEsq(), id, dado));
        } else if (id > raiz.getId()) {
            raiz.setDir(inserir(raiz.getDir(), id, dado));
        }
        return raiz;
    }

    private static void imprimeEmOrdem(No<Integer> raiz) {
        if (raiz == null) return;
        imprimeEmOrdem(raiz.getEsq());
        System.out.print(raiz.getId() + "(" + raiz.getDados() + ") ");
        imprimeEmOrdem(raiz.getDir());
    }
}
