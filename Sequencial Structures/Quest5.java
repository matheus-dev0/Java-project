/*Faça um programa que receba o salário base de um funcionário, a gratificação a receber e o imposto a ser pago. Calcule e mostre o salário
 * a receber, os valores informados serão considerados como porcentagem.
 */

import java.util.Scanner;

public class Quest5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digit the gratification percentage: (based on the gross salary)");
        float gratification = input.nextFloat();
        System.out.println("Digit the tax percentage: (based on the gross salary)");
        float tax = input.nextFloat();

        System.out.println("Digit your salary:");
        float grossSalary = input.nextFloat();

        float totalGratification = grossSalary * (gratification/100);
        float totalTax = grossSalary * (tax/100);
        float salary = grossSalary + totalGratification - totalTax;

        System.out.printf(
                "Your gross salary: $%.2f.\nYour gratification: $%.2f.\nTax paid: $%.2f.\nLiquid salary: $%.2f.",
                grossSalary, totalGratification, totalTax, salary);
        input.close();
    }
}
