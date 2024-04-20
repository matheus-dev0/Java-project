
import java.text.Normalizer;
import java.util.regex.Pattern;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    boolean isEvent;
    private final String[] validCommands = {
        "va", "sair", "ajuda", "1", "2", "3", "4", "proximo"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords(boolean isEvent)
    {
        this.isEvent = isEvent;
        if(isEvent == true){
             String[] validCommands = {"1", "2", "3", "4"};
        }
    }
    private static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        if(aString != null){
        aString = deAccent(aString.toLowerCase());}
        
        
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
