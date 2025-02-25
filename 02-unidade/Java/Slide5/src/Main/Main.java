package Main;

import java.util.Scanner;

import Aplicacoes.HeapfyBuilt;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Digite os elementos do array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array original:");
        HeapfyBuilt heapfyBuilt = new HeapfyBuilt();
		heapfyBuilt.imprimeArray(arr);

        HeapfyBuilt heapfyBuilt2 = new HeapfyBuilt();
        heapfyBuilt2.buildHeap(arr);
        System.out.println("Array após construir a heap:");
        HeapfyBuilt heapfyBuilt3 = new HeapfyBuilt();
		heapfyBuilt3.imprimeArray(arr);

        HeapfyBuilt heapfyBuilt4 = new HeapfyBuilt();
        heapfyBuilt4.heapSort(arr);
        System.out.println("Array após Heapsort:");
        HeapfyBuilt heapfyBuilt5 = new HeapfyBuilt();
		heapfyBuilt5.imprimeArray(arr);

        sc.close();
    }
}
