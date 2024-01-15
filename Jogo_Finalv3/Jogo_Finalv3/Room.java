/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
import java.util.*;
public class Room 
{
    public String description;
    public String shortName;
    private Map<String, Room> exits = new HashMap<>();
    int cordsX = 0,cordsY = 0;
    int eventoCodigo;
    Evento eventoRoom;
    
    ////--------------------------mudança fimas
    //Controla se é uma sala final.
    boolean salaFinal = false;
    boolean validaEvento = false;
    ////--------------------------

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, String shortName, int eventoCodigo) 
    {
        this.description = description; 
        this.shortName = shortName;       
        this.eventoCodigo = eventoCodigo;
        eventoRoom = new Evento(eventoCodigo);
    }
    
     public void chamarEvento(){
        eventoRoom.startEvento();
     }
     
    public int sanidadePerdidaEvento(){
        chamarEvento();
        int sanidadePerdida = eventoRoom.getSanidadePerdida();
        return sanidadePerdida;
    }

    public void setEvento(int evento){
         eventoRoom = new Evento(evento);
         eventoCodigo=evento;
    }
    
      public int getEvento(){
        return eventoCodigo;
        
    }
     
        ////--------------------------mudança fimas
    //Controla as coordenadas na matriz
    public void setCords(int x,int y){
        cordsX = x;
        cordsY = y;
    }
    
    public int getCordsX()
    {
        return cordsX;
    }
    
    public int getCordsY()
    {
        return cordsY;
    }
    
    //Cotrola se é uma sala final
    public void finalTrue()
    {
        salaFinal = true;
    }
    
    public Boolean novoAndar(){
        if(eventoRoom.validaSaida == true){
          return true;
        }
        return false;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(String direction, Room room) 
    {
        exits.put(direction, room);
    }
    /**
    * Retorna uma descrição das saídas deste Room,
    * por exemplo, "Exits: north west".
    * @return Uma descrição das saídas disponíveis.
    */
    private String getExitString(){
        String totalExits = "Saídas:\n ";
        for(String i: exits.keySet()){
            totalExits += i+": " + exits.get(i).shortName + "\n ";
        }
        System.out.println();
        return totalExits;
    }
    public Room getExit(String direction){
        return exits.get(direction);
    }
    /**
     * @return The description of the room.
     */
    private String getDescription(){
        return description;
    }
    public String getShortName(){
        return shortName;
    }
    public String getLongDescription(){
        return( "Sala atual: " + getDescription() + "\n\n" + getExitString());
    
    }
}
