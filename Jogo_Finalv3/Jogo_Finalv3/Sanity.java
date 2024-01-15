
/*
 * First thing first, this are the known values of each item:
 * 
 * High Sanity - 100% - 70%
 * Medium Sanity - 69% - 30%
 * Low Sanity - 29% - 1% 
 * 
 * Who ever reach zero Sanity (I hope this will not be your case) the game difficult will be almost impossible.
 * 
 */
import java.util.Random;
import java.util.HashMap;

public class Sanity {

    private int sanityPercentage;
    private final int maxSanity = 210; // Max sanity level.

    private boolean lowSanity;
    private boolean mediumSanity;
    private boolean highSanity;
    private boolean noSanity;
    private Random randomicValue;
    private HashMap<Integer, String> messageHolder;

    public Sanity() {
        sanityPercentage = 100; // 100% initial Sanity
        randomicValue = new Random();
        messageHolder = new HashMap<>();
        messagesInitializer();

    }

    /*
     * This method takes info from currentSanityStatus() and display the sanity
     * status.
     * 
     */

    public void getSanityStatus() {
        if (currentSanityStatus() == SanityStatus.HIGH) {
            getRandomMessages();
        } else if (currentSanityStatus() == SanityStatus.MEDIUM) {

            getRandomMessages();
        } else if (currentSanityStatus() == SanityStatus.LOW) {
            getRandomMessages();
        } else if (currentSanityStatus() == SanityStatus.ZERO) {
            getRandomMessages();
        }
    }

    public int getSanityPercentage() {

        return sanityPercentage;

    }

    public boolean isSanityLow() {
        return lowSanity;
    }

    public boolean isSanityMedium() {
        return mediumSanity;
    }

    public boolean isSanityHigh() {
        return highSanity;
    }

    /*
     * This method will map the sanity on levels. If the sanity is considered High,
     * SanityStatus will be set to HIGH, and so on.
     * 
     * The type SanityStatus meakes reference for the enum method in the last line.
     * 
     */

    private SanityStatus currentSanityStatus() {
        if (sanityPercentage >= 70) {
            highSanity = true;
            mediumSanity = false;
            lowSanity = false;
            noSanity = false;
            return SanityStatus.HIGH;
        } else if (sanityPercentage >= 30) {
            highSanity = false;
            mediumSanity = true;
            lowSanity = false;
            noSanity = false;
            return SanityStatus.MEDIUM;
        } else if (sanityPercentage >= 1) {
            highSanity = false;
            mediumSanity = false;
            lowSanity = true;
            noSanity = false;
            return SanityStatus.LOW;
        } else {
            highSanity = false;
            mediumSanity = false;
            lowSanity = false;
            noSanity = true;
            return SanityStatus.ZERO;

        }
    }

    /*
     * This method will add an message describing the mental health of the character
     * based on the sanity level
     * 
     * The randomic generator logic was planned based on:
     * 
     * High sanith: 15 - 11
     * Medium sanity: 10 - 6
     * Low sanity: 5 - 1
     * 
     */
    private void getRandomMessages() {
        int messageGetter = ' ';
        if (highSanity == true) {
            messageGetter = (randomicValue.nextInt(5) + 10) + 1; // Numbers between 11 - 15

        } else if (mediumSanity == true) {
            messageGetter = (randomicValue.nextInt(5) + 5) + 1; // Numbers between 6 - 10

        } else if (lowSanity == true) {
            messageGetter = (randomicValue.nextInt(5)) + 1; // Numbers between 1 - 5
        } else if (noSanity == true) {
            messageGetter = (randomicValue.nextInt(4) + 15) + 1;

        }
        System.out.println(messageHolder.get(messageGetter));
    }

    private void messagesInitializer() {
        // Alta Sanidade (11-15)
        messageHolder.put(11,
                "Me sentindo ótimo! A vida está boa, e não tenho do que reclamar. Tudo parece estar se encaixando.\n");
        messageHolder.put(12,
                "As coisas estão indo bem. Estou contente e esperançoso, com uma sensação de calma na minha vida cotidiana.\n");
        messageHolder.put(13,
                "A vida está boa, e estou aproveitando as vibrações positivas. Cada dia parece um presente.\n");
        messageHolder.put(14,
                "Em um estado de alegria e contentamento. O mundo é um lugar bonito, e estou apreciando cada momento.\n");
        messageHolder.put(15,
                "Absolutamente fantástico! Tudo está perfeito, e estou em paz comigo mesmo e com o mundo.\n");

        // Média Sanidade (6-10)
        messageHolder.put(6,
                "Indo bem. Existe uma sutil inquietação, mas estou esperançoso de que as coisas vão melhorar em breve.\n");
        messageHolder.put(7,
                "Não estou me sentindo no meu melhor agora, mas estou otimista de que as coisas vão melhorar em breve.\n");
        messageHolder.put(8,
                "Um pouco indisposto, lidando com algumas dúvidas. Esperando por dias mais brilhantes pela frente.\n");
        messageHolder.put(9,
                "Lutando um pouco, mas vou superar. Enfrentando dúvidas e incertezas, mas mantendo a resiliência.\n");
        messageHolder.put(10,
                "O mundo parece um pouco instável, entre altos e baixos. Esperando por estabilidade e uma jornada mais tranquila.\n");

        // Baixa Sanidade (1-5)
        messageHolder.put(1,
                "Ajuda! Me sinto ameaçado, e minha mente está em caos. Preciso de assistência urgente!\n");
        messageHolder.put(2,
                "Sentindo-me aterrorizado. Sombras se aproximando, e não consigo entender a realidade. Com medo pela minha vida.\n");
        messageHolder.put(3,
                "Mãe! Preciso da sua ajuda. Está escurecendo, e não tenho certeza do que é real. Me sentindo ameaçado e perdido.\n");
        messageHolder.put(4,
                "Pânico se instalando. Minha mente está desmoronando, e cada passo parece uma jornada perigosa. Alguém, por favor, ajude!\n");
        messageHolder.put(5,
                "Gritos na minha mente, vozes ameaçando minha existência. Não consigo distinguir entre realidade e pesadelo. Me ajude, por favor!\n");
                
        // frases de morte
        messageHolder.put(16,
                "Serenamente dou o primeiro passo no caminho da eternidade e saio da vida para entrar na História.");

        messageHolder.put(17, "Aqui agora existe apenas um corpo frio que futuramente será devorado por vermes.");

        messageHolder.put(18,
                "Sua última respiração se mistura com o vento, enquanto a terra o abraça em seu leito final.");

        messageHolder.put(19,
                "Aqui jaz um aventureiro destemido, agora descansando em paz após desafiar inúmeras tormentas.");

    }

    private void sanityDamageChecker(float dano) {

        System.out.println("Você perdeu " + (int) dano + "% de sua sanidade.");

    }

    /*
     * 
     * This represents the logic for the sanity percentage loss through the
     * gameplay.
     * 
     * The remainingSanity represents the math for calculate the percentage left,
     * with the difference applied.
     * Ex: with the damage, the value of remainingSanity will be 91%.
     * 
     * 
     * 
     */

    private int setSanityPercentage(int percentage) {
        sanityPercentage = percentage;
        return sanityPercentage;
    }

    public boolean isDead() {
        if (getSanityPercentage() <= 0) {

            setSanityPercentage(0);
            return true;
        } else {
            return false;
        }

    }



    public void addSanityDamage(float damage) {

        float sanityDamageTaken = maxSanity - damage; // Just doing the math for remove percentages of the sanity

        int remainingSanity = Math.round(sanityDamageTaken / maxSanity * 100); // Rounding to avoid decimal values

        int percentageRemoved = 100 - remainingSanity;

        this.sanityPercentage -= percentageRemoved;

        sanityDamageChecker(percentageRemoved);

        isDead();
    }

    enum SanityStatus {
        HIGH,
        MEDIUM,
        LOW,
        ZERO
    }

    public static void main(String[] args) {
        Sanity s = new Sanity();

        s.getSanityStatus();
        s.addSanityDamage(15);
        s.getSanityStatus();
        s.addSanityDamage(1766);
        s.getSanityStatus();

        System.out.println(s.getSanityPercentage());
    }

}