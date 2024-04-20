
/**
 * This is the lantern of the game
 */
public class Lantern {
    private int battery = 4; // Mudei para definirmos o nivel
    private boolean state = false; // on and off
    //private boolean turnedOn;
    //private boolean turnedOff;
    //private Sanity sanity;

    public Lantern() {
        state = false;
        //sanity = new Sanity();
    }

    public int getBattery() {
        return battery;
    }

    /*public boolean isTurnedOn() { //Não é necessário, já que a manipulação da bateria ocorre nos eventos
        if(state == true) {
            turnedOn = true;
            return turnedOn;
        } else {
            turnedOff = true;
            return turnedOff;
        }
     }
    */
    public void addBattery(int value) {
        battery += value;
        showStatus();
    }
    
    public void removeBattery(int value) {
        if(battery > 1){
            battery -= value;
            showStatus();
        }
    }
 
    /*public void turn() {  //Conceito não usado de lanterna como comando principal, e a sanidade é drenada enquanto estiver desligada.
      
         if (!isTurnedOn()) {
            sanity.addSanityDamage(8);
            if (battery >= 1) {
                state = true;
                battery = (battery - 1);
                System.out.println(getState() + ",Bateria:" + getBattery());
            } else {
                System.out.println("Você está sem bateria.");
                System.out.println(getState());
            }
        } else {
            state = false;
           System.out.println(getState());
        }
     }
     */
    
    public void turn(){
        removeBattery(2);
    }
    
    private String getState() {
        if (state == true) {
            return "Lanterna está ligada";
        } else {
            return "Lanterna está desligada";
        }
    }

    public void showStatus() {
        System.out.println("\nBateria: " + getBattery());
    }

}
