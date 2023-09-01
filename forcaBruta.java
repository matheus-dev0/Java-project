public class forcaBruta {
    public static void main(String[] args) {
        int number = 1;
        int tentativas = 0;
        while (true) {
            tentativas++;
            if (number % 7 == 0 && number % 13 == 0) {
                System.out.println("Número encontrado: " + number + "\nQuantidade de tentativas: "+ tentativas);
                break;
            }
            number++;
        }
    }
}
