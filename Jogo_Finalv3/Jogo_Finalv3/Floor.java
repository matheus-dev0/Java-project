import java.util.*;
/**
 * Escreva uma descrição da classe Floor aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Floor
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private ArrayList<Room> salas = new ArrayList<Room>();
    private int num = 0; //Serve apenas para controlar o núemro na descrição das salas
    private int numSalas = 0; //Numero de salas
    private int andar;
    public Room inicial;
    private int mapa[][] = new int[101][101]; //Inicializa a matriz tamanho 19 por ser impar (tem uma sala central)
     

    /**
     * Construtor para objetos da classe Floor
     */
    public Floor(int floorNum)
    {   
        andar = floorNum;
    }
    
    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
    public void startGeneration()
    {   
        inicial = new Room("Sala inicial","Sala Incial", 0);
        salas.add(inicial);
        inicial.setCords(50,50);
        mapa[50][50] = 1;
        createRooms(inicial);
    }
    
    public Room trazerInicial(){
        return inicial;
    }
    
    private void createRooms(Room gerador) 
    {   
        //int numFantasmas = 4;       //Num de fantasmas que queremos gerar, (não está em uso)
        int maxGeracoesSalas = 8;    //Quantas gerações devem ser feitas, cada geração vai criar de 1 a 3 salas a partir da sala geradora
        int salasGeradas = 0;
        numSalas++;
        
        Room salaGeradora = gerador;
        Random aleatorio = new Random();
        if(numSalas <= maxGeracoesSalas){
            int numSalasGeracao = aleatorio.nextInt(3);
            numSalasGeracao++;
            while(salasGeradas < numSalasGeracao){
                
                boolean generated = false, norte = false, leste = false, sul = false, oeste = false;
                Room proximo; //Sala que está sendo gerada
                
                if(num<10){
                proximo = new Room(("Sala " + andar +"0" + num), ("Sala " + andar + "0" + num), 0);
                }else{
                proximo = new Room(("Sala " + andar + num), ("Sala " + andar + num), 0);
                }
                Random random = new Random();
                if (numSalas%2 == 0){ //Faz que cada geração par seja uma sala com eventos
                    proximo.setEvento((random.nextInt(8)+2));
    
                }
                if(numSalas == maxGeracoesSalas){
                    proximo.setEvento(1);
                }
 
                salaGeradora = proximo; //Proxima sala se torna a geradora
                salas.add(proximo); //Adiciona a proxima sala no array
                salasGeradas++;
                while(generated == false){
                    //Caso as quatro direções estejam ocupadas.
                    if(norte == true && leste == true && sul == true && oeste == true){ //Cai aqui se as 4 direções estiverem ocupadas
                        salaGeradora = salas.get(aleatorio.nextInt(num)); //muda a sala geradora pra outra sala aleatória
                        generated = true;

                    }
                    switch(aleatorio.nextInt(4))
                    {
                        case 0:
                            //Testa se o espaço na matriz ao norte da sala geradora atual está vazio
                            if(mapa[gerador.getCordsY()-1][gerador.getCordsX()] == 0){
                                gerador.setExits("norte", proximo);
                                proximo.setExits("sul", gerador);
                                //Atribui um valor diferente de zero para o espaço na matriz que foi ocupado pela nova sala
                                mapa[gerador.getCordsY()-1][gerador.getCordsX()]++;
                                proximo.setCords(gerador.getCordsX(), gerador.getCordsY()-1);
                                generated = true;
                                num++; //Numero da sala
                            }
                            norte = true;
                            break;
                            
                        case 1:
                            //Testa se o espaço na matriz ao leste da sala geradora atual está vazio
                            if(mapa[gerador.getCordsY()][gerador.getCordsX()+1] == 0){
                                gerador.setExits("leste", proximo);
                                proximo.setExits("oeste", gerador);
                                //Atribui um valor diferente de zero para o espaço na matriz que foi ocupado pela nova sala
                                mapa[gerador.getCordsY()][gerador.getCordsX()+1]++;
                                proximo.setCords(gerador.getCordsX()+1, gerador.getCordsY());
                                generated = true;
                                num++; //Numero da sala
                            }
                            leste = true;
                            break;
                            
                        case 2:
                            //Testa se o espaço na matriz ao sul da sala geradora atual está vazio
                            if(mapa[gerador.getCordsY()+1][gerador.getCordsX()] == 0){
                                gerador.setExits("sul", proximo);
                                proximo.setExits("norte", gerador);
                                //Atribui um valor diferente de zero para o espaço na matriz que foi ocupado pela nova sala
                                mapa[gerador.getCordsY()+1][gerador.getCordsX()]++;
                                proximo.setCords(gerador.getCordsX(), gerador.getCordsY()+1);
                                generated = true;
                                num++; //Numero da sala
                            }
                            sul = true;
                            break;
                            
                        case 3:
                            //Testa se o espaço na matriz ao oeste da sala geradora atual está vazio
                            if(mapa[gerador.getCordsY()][gerador.getCordsX()-1] == 0){
                                gerador.setExits("oeste", proximo);
                                proximo.setExits("leste", gerador);
                                //Atribui um valor diferente de zero para o espaço na matriz que foi ocupado pela nova sala
                                mapa[gerador.getCordsY()][gerador.getCordsX()-1]++;
                                proximo.setCords(gerador.getCordsX()-1, gerador.getCordsY());
                                generated = true;
                                num++; //Numero da sala
                            }
                            oeste = true;
                            break;
                        
                        default: 
                            //Não é pra cair aqui nunca
                            System.out.println("?Erro?");
                            break;
                    }
                }
            }
            createRooms(salaGeradora);
        }
    }
    
    //Imprime a matriz, ou seja, o mapa (0 é vazio e 1 é ocupado por sala, se aparecer algum outro valor deve ser por que gerou uma sala em cima da outra, mais não é pra acontecer isso).
    public void mapa(){
        String linhas = "";
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                linhas = linhas + "  " + mapa[i][j];
            }
            System.out.println(linhas + "\n");
            linhas = "";
        }
    }
    ////--------------------------
}
