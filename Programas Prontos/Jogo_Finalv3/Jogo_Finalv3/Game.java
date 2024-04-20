
public class Game 
{   
    public static Lantern lanterna;
    private Parser parser;
    private Room currentRoom;
    private Sanity sanidade;
    private int contador;
    private Floor floor;
    private int floorNumber = 0;
    private Room inicial;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {   
        lanterna = new Lantern();
        createFloor();
        sanidade = new Sanity();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    public void createFloor()
    {   
        floorNumber++;
        floor = new Floor(floorNumber);
        floor.startGeneration();
        inicial = floor.trazerInicial();
        currentRoom = inicial;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {
        parser = new Parser(false);
        printWelcome();
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            if(sanidade.isDead()){
                sanidade.getSanityStatus();
                finished = true;
            }else{
            finished = processCommand(command);}
        }
        System.out.println("Obrigado por jogar!! Volte depois!");
    }


    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println();
        System.out.println("|||||||||Eternalevasion||||||||||");
        System.out.println();
        System.out.println();

        System.out.println(
                "Ausência total, nem lembranças, nem traços, apenas um vulto sem identidade. O despertar é em um lugar insondável, onde túmulos se confundem com caminhos sinuosos... ");
        System.out.println(
                "Tudo é familiar, mas distorcido, como se as paredes da realidade se contorcessem em sua presença... ");
        System.out.println(
                "No chão, uma lanterna esquecida, teu farol na escuridão. Projeta feixes de luz que revelam o desconhecido e protege do perigo.;");
        System.out.println("Lhe resta apenas vagar para descobrir seu destino..");
        System.out.println();
        System.out.println("Digite 'ajuda' se precisar de ajuda.");
        System.out.println("Digite 'proximo' para avançar.");
        System.out.println();

    }
    
    
    //segunda Info 
        private void getPrimaryInfo() {
        System.out.println(" Você olha em volta e percebe alguns lugares que podem ser explorados, tentando");
        System.out.println("encontrar respostas para os mistérios que rondam este lugar misterioso e tentando encontrar");
        System.out.println("a saída o mais rápido possível.");
        System.out.println(
                "Tome cuidado! Sua sanidade pode e vai ser afetada por eventos. Quanto menor sua sanidade, menores");
        System.out.println("são as chances de sair com vida. Mensagens sobre o status do seu personagem vão aparecer.");

        System.out.println("Digite 'proximo' para avançar.");
    }
    
    
    //remove special characteres

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {

        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Comando inválido...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("ajuda")) {
            printHelp();
        }
        else if (commandWord.equals("va")) {
            goRoom(command);
        }
        else if (commandWord.equals("sair")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("proximo")) {
            contador++;

            if (contador == 1) {
                getPrimaryInfo();
            } else if (contador == 2) {
                printLocationInfo();
            }

        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println();
        System.out.println("Ajuda:");
        System.out.println();
        System.out.println("Tome cuidado para sobreviver... Seus recursos são escassos");
        System.out.println();
        System.out.println("Seus comandos são:");
        System.out.println("vá (norte, sul, leste , oeste) | sair  |ajuda |lanterna");
        System.out.println();
    }
    
    private void printLocationInfo() {
        System.out.println("---------------------------------------");
        sanidade.getSanityStatus();
        System.out.println(currentRoom.getLongDescription());
    }
    
    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {

        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Vá para onde?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("Não existe nenhum caminho nessa direção...");
        }
        else {
            currentRoom = nextRoom;
            int perdida = currentRoom.sanidadePerdidaEvento();
            if(currentRoom.getEvento()!= 1){
                currentRoom.setEvento(0);
            }
            setSanidadePerdida(perdida);
            if(sanidade.getSanityPercentage()<=0){
                System.out.println("Você morreu... Aperte enter");
            }else{
                if(currentRoom.novoAndar() == true){
                    createFloor();
                }
                printLocationInfo();
            }

        }
    }
    
    private void setSanidadePerdida(int perdida){
        sanidade.addSanityDamage(perdida);
    }

    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Digite somente sair");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
