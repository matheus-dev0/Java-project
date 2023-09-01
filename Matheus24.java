import java.util.Scanner;

public class Matheus24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o codigo do produto:");
        int codigo = input.nextInt();
        float preco = 0;

        if (codigo >= 1 && codigo <= 10) {
            preco = 10;
        } else if (codigo > 10 && codigo <= 20) {
            preco = 20;
        } else if (codigo > 20 && codigo <= 30) {
            preco = 30;
        } else if (codigo > 30 && codigo <= 40) {
            preco = 40;
        } else {
            while (true) {
                System.out.println("Digite um codigo valido entre 1 e 40!");
                codigo = input.nextInt();
                if (codigo >= 1 && codigo <= 40) {
                    break;
                }

            }
        }

        System.out.println("Digite a quantida adquirida:");
        int qtd = input.nextInt();

        float nota = qtd * preco;
        float desconto = 0;
        if (nota <= 250) {
            desconto = 0.05f;
        } else if (nota > 250 && nota <= 500) {
            desconto = 0.1f;
        } else if (nota > 500) {
            desconto = 0.15f;
        }

        float precoFinal = nota - (nota * desconto);

        System.out.printf("O preço unitário do produto é de R$%.2f.\n", preco);
        System.out.printf("O preço total da nota, sem o desconto, é de R$%.2f.\n", nota);
        System.out.printf("O desconto total é de é de %.0f%%.\n", desconto*100);
        System.out.printf("O preço total da nota, com o desconto, é de R$%.2f.\n", precoFinal);
    }

}
