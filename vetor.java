
//Este programa receberá dois vetores e retornará um terceiro resultante dos elementos dos anteriores, deixando os valores ordenados
import java.util.Scanner;

public class vetor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite os tamanho do primeiro vetor:");
        int m = input.nextInt();
        int[] nums1 = new int[m];

        for (int i = 0; i < m; i++) {
            System.out.printf("Digite o %d elemento: ", i + 1);
            nums1[i] = input.nextInt();
        }

        System.out.println("Digite os tamanho do segundo vetor:");
        int n = input.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < m; i++) {
            System.out.printf("Digite o %d elemento: ", i + 1);
            nums2[i] = input.nextInt();
       
            
       
        }
 
        int[] vetorResultante = new int[m+n];

        int index = 0;
        for(int i = 0; i < m+n; i++) {
            
        }
 
    }
}