import java.util.Scanner;

public class barraCilindrica {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Bem vindo! Iremos calcular a tensão de uma barra cilíndrica desejada!");
        System.out.println("Digite o diâmetro da barra:");
        float diametro = input.nextFloat();
        System.out.println("Digite a carga o qual a barra será submetida:");
        float carga = input.nextFloat();

        int n = 0;

        if(diametro > 100) {
            n = 2;
        } else if(diametro < 50) {
            n = 6;
        } else {
            n = 4;
        }
    
        double tensao = (4 * carga)/Math.PI*Math.pow(diametro, 2) * n;

        System.out.printf("A tensão desta barra cilíndrica é de %.2f", tensao);
        
    }
}
