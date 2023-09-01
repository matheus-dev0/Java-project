/*Faça um algoritmo que receba um salário base de um vendedor e o valor de mercadorias vendidas. Deverá ser retornado o salário
resultante com a comissão de 10% sobre as vendas.
 */

import java.util.Scanner;
public class comissaoVendas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite seu salário base: ");
        float salario = input.nextFloat();
    
        System.out.println("Digite o preço das vendas totais:");
        float vendas = input.nextInt();

        float comissao = vendas * 0.10f; // calcula a comissão de 10% sobre o total de vendas realizadas.
        salario += comissao;

        System.out.printf("Sua comissão a receber baseada em suas vendas é de R$ %.2f.\nO salário total é de R$ %.2f", comissao, salario);

        input.close();
    }
}
