import java.util.*;

/**
 * Escreva uma descrição da classe Eventos aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Evento
{   
    private int numEvento;
    public boolean validaSaida = false;
    Parser parser= new Parser(true);
    private int sanidadePerdida = 0;
    /**
     * Construtor para objetos da classe Eventos
     */
    public Evento(int num)
    {
        numEvento = num;
    }
    
    public void startEvento(){
        if(numEvento==1){
            validaSaida = saidaGame();
        }
        else if(numEvento==2){
            itemBateria(1);
        }
        else if (numEvento == 3 || numEvento == 4){
            sanidadePerdida = fantasma1();
        }
        else if (numEvento == 5 || numEvento == 6){
            sanidadePerdida = fantasma2();
        }
        else if (numEvento == 7 || numEvento == 8){
            sanidadePerdida = fantasma3();
        }

    }

    public int getSanidadePerdida(){
        return sanidadePerdida;
    
    }
    
    public void itemBateria(int a)
    {   
        System.out.println("---------------------------------------");
        System.out.println("Você encontrou uma bateria para sua lanterna... Que achado!");
        System.out.println("A bateria aumentou em " + a + ".");
        System.out.println("---------------------------------------");
        Game.lanterna.addBattery(a);
    }

    public boolean saidaGame()
    {
        boolean x = false;
        System.out.println("Você encontrou uma escadaria... Deseja descer?");
        System.out.println("Digite 1 para descer");
        Command command = parser.getCommand();
        String commandWord = command.getCommandWord();
        if(commandWord.equals("1")){
            System.out.println("Indo para o próximo andar");
            x = true;
        }else{
            System.out.println("Saia e retorne caso queira interagir novamente");

        }
        return x;
    }
    
    public int fantasma1()
    {
        boolean comandoVerdadeiro = false;
        System.out.println("---------------------------------------");
        Game.lanterna.showStatus();
        System.out.println("Você sente uma madição amedrontadora nessa sala, você sabe que está sendo observado.");
        System.out.println("Digite 1 para conversar");
        System.out.println("Digite 2 para fugir");
        System.out.println("Digite 3 para se esconder");
        System.out.println("Digite 4 para ligar a lanterna");
        int dano = 0;
        while(!comandoVerdadeiro){
            Command command = parser.getCommand();
            String commandWord = command.getCommandWord();
            if(commandWord.equals("1")){
                System.out.println("Você tenta se comunicar com o ser além da sua compreensão.");
                System.out.println("Você sente que uma grande quantidade de conhecimento indecifrável invade sua cabeça.");
                System.out.println("A presença desaparece, ao mesmo tempo que emite uma melodia sinistra, porém intrigante.");
                comandoVerdadeiro = true;
                dano = 20;
            }else if(commandWord.equals("2")){
                System.out.println("Você tenta fugir, mesmo sentido que está se movendo, seu corpo não sai do lugar.");
                System.out.println("A madição rapidamente desaparece da sala, mas você sente como se havia passado dias nesses ultimos segundos.");
                comandoVerdadeiro = true;
                dano = 30;
            }else if(commandWord.equals("3")){
                comandoVerdadeiro = true;
                Random random = new Random();
                int aleatorio = random.nextInt(2);
                System.out.println("Você tenta se esconder atrás de alguma mobília na sala.");
                if(aleatorio == 1){
                    System.out.println("Você se esgueira atrás de uma mobília, que já estava próxima.");
                    System.out.println("A presença rápidamente desaparece, porém você sente como se tivessem se passado horas.");
                   dano = 40;
                }else{
                    System.out.println("A cada passo que você tenta fazer é como se a distância se estendesse. Você sente como se tivessem passados semanas, eventualmente consegue alcançar seu destino, apenas para perceber que só restava pó.");
                    System.out.println("A presença desaparece, mais não antes de te acordar com uma risada maléfica.");
                    dano = 60;
                }
            }else if(commandWord.equals("4")){
                if(Game.lanterna.getBattery() > 1){
                    Game.lanterna.turn();
                    System.out.println("Ao observar a sala sente como se o tempo estivesse parado.");
                    System.out.println("A presença intensifica brevemente, logo antes de desaparecer completamente.");
                    comandoVerdadeiro = true;
                    dano = 10;
                } else {
                    System.out.println("Você tenta ligar sua lanterna, mais não há bateria suficiente.");
                }
            }else{
                System.out.println("Comando inválido");
            }
        }
        System.out.println("---------------------------------------");
        return dano;
    }
    
    public int fantasma2(){
        boolean comandoVerdadeiro = false;
        System.out.println("---------------------------------------");
        Game.lanterna.showStatus();
        System.out.println("Há um fantasma com aparência jovem no centro da sala... ele não parece ter olhos...");
        System.out.println("'Me da... um abraço...', ele diz.");
        System.out.println("Digite 1 para conversar");
        System.out.println("Digite 2 para se aproximar");
        System.out.println("Digite 3 para se esgueirar pelos cantos da sala");
        System.out.println("Digite 4 para ligar a lanterna");
        int dano = 0;
        while(!comandoVerdadeiro){
            Command command = parser.getCommand();
            String commandWord = command.getCommandWord();
            if(commandWord.equals("1")){
                System.out.println("Você tenta se comunicar com a alma penada.");
                System.out.println("...");
                System.out.println("ele apenas responde com um sorriso. \n O jovem fantasma se dissipa.");
                comandoVerdadeiro = true;
                dano = 30;
            }else if(commandWord.equals("2")){
                System.out.println("Você se aproxima da alma penada e oferece um abraço.");
                System.out.println("A alma penada se dissipa em seus braços.");
                comandoVerdadeiro = true;
                dano = 0;
            }else if(commandWord.equals("3")){
                System.out.println("Você se move evitando o centro da sala...");
                System.out.println("A alma penada de aparência jovem olha diretamente para você após alguns segundos, ele parece decepcionado.\n O jovem fantasma se dissipa.");
                comandoVerdadeiro = true;
                dano = 40;
            }else if(commandWord.equals("4")){
                if(Game.lanterna.getBattery() > 1){
                    Game.lanterna.turn();
                    System.out.println("Voce aponta sua lanterna para o fantasma.");
                    System.out.println("Ele parece confuso.\n O jovem fantasma se dissipa.");
                    comandoVerdadeiro = true;
                    dano = 10;
                } else {
                    System.out.println("Você tenta ligar sua lanterna, mais não há bateria suficiente.");
                }
            } else {
                System.out.println("Comando inválido");
            }
        }
        System.out.println("---------------------------------------");
        return dano;
    }
    
    public int fantasma3(){
        boolean comandoVerdadeiro = false;
        System.out.println("---------------------------------------");
        Game.lanterna.showStatus();
        System.out.println("Ao entrar, você escuta dois fantasmas em lados opostos da sala, está muito escuro para conseguir ver suas aparências.");
        System.out.println("'Muito... escuro...', exclama o primeiro.");
        System.out.println("'Muito... claro...', exclama o segundo.");
        System.out.println("'Ao mesmo tempo, um som repetitivo, parecido a um bater de pálpebras vindo de ambos.");
        System.out.println("Digite 1 para tentar se comunicar.");
        System.out.println("Digite 2 para apontar a lanterna para o primeiro.");
        System.out.println("Digite 3 para apontar a lanterna para o segundo.");
        System.out.println("Digite 4 para ignorar ambos.");
        int dano=0;
        while(!comandoVerdadeiro){
            Command command = parser.getCommand();
            String commandWord = command.getCommandWord();
            if(commandWord.equals("1")){
                System.out.println("Você tenta se comunicar com os gêmeos.");
                System.out.println("...");
                System.out.println("O som do piscar de olhos se encerra, junto com a presença dos gêmeos.");
                comandoVerdadeiro = true;
                dano=20;
            }else if(commandWord.equals("2")){
                if(Game.lanterna.getBattery() > 1){
                    Game.lanterna.turn();
                    System.out.println("Você aponta sua lanterna acesa para o primeiro.");
                    System.out.println("'Muito... escuro...' ele diz.");
                    System.out.println("O som do piscar de olhos se encerra, junto com a presença dos gêmeos.");
                    comandoVerdadeiro = true;
                    dano=30;
                } else {
                    System.out.println("Você tenta ligar sua lanterna, mais não há bateria suficiente.");
                }
            }else if(commandWord.equals("3")){
                if(Game.lanterna.getBattery() > 1){
                    Game.lanterna.turn();
                    System.out.println("Você aponta sua lanterna acesa para o segundo.");
                    System.out.println("Ele parece satisfeito.");
                    System.out.println("O som do piscar de olhos se encerra, junto com a presença dos gêmeos.");
                    comandoVerdadeiro = true;
                    dano=0;
                }else {
                    System.out.println("Você tenta ligar sua lanterna, mais não há bateria suficiente.");
                }
            } else if(commandWord.equals("4")) {
                System.out.println("Vocẽ pode ouvir o bater das pálpebras acelerar, ficando mais rápido mais próximo.");
                System.out.println("Suas memórias recentes ficaram pouco claras, mas o som do piscar de olhos se encerra, junto com a presença dos gêmeos.");
                comandoVerdadeiro = true;
                dano=40;
                
            } else {
                System.out.println("Comando inválido");
            }
        }
        System.out.println("---------------------------------------");
        return dano;
    }
}