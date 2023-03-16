import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public  class RandomGenerator {
    private final int amountToBeGenerated;

    public RandomGenerator(int amountToBeGenerated) {
        this.amountToBeGenerated = amountToBeGenerated;
    }

    public void UsingUUID(){
        Set<String> setOfId = new HashSet<>();
        if (amountToBeGenerated%2==0){
            for (int i = 0; i<amountToBeGenerated/2; i++){
                String uuid = UUID.randomUUID().toString();
                String toSubString = uuid.substring(10,20);
                setOfId.add(toSubString);
                String toSubString2 = uuid.substring(0,10);
                setOfId.add(toSubString2);
            }
        }else {
            for (int i = 0; i < amountToBeGenerated / 2; i++) {
                String uuid = UUID.randomUUID().toString();
                String toSubString = uuid.substring(10, 20);
                setOfId.add(toSubString);
                String toSubString2 = uuid.substring(0, 10);
                setOfId.add(toSubString2);
            }
            String uuid = UUID.randomUUID().toString();
            String toSubString = uuid.substring(10, 20);
            setOfId.add(toSubString);
        }
        System.out.println("Size of set containing randomly generated ID's is "+setOfId.size());
        int scale = 10;
        BigDecimal num1 = new BigDecimal(setOfId.size());
        BigDecimal num2 = new BigDecimal(amountToBeGenerated);
        BigDecimal num3 = (num1.divide(num2, scale,RoundingMode.HALF_UP));

        System.out.println("Degree of randomness in percentage is "
                +num3.multiply(BigDecimal.valueOf(100))+" %");
    }
    public void UsingStringBuilder(){
        Set<String> setOfId = new HashSet<>();
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"+"-";
        for (int f = 0; f<amountToBeGenerated; f++){
            StringBuilder randomString = new StringBuilder(10);
            for (int i = 0; i < 10; i++) {
                int index = (int)(AlphaNumericString.length() * Math.random());
                randomString.append(AlphaNumericString.charAt(index));
            }
            setOfId.add(String.valueOf(randomString));
        }
        System.out.println("Size of set containing randomly generated ID's is "+setOfId.size());
        int scale = 10;
        BigDecimal num1 = new BigDecimal(setOfId.size());
        BigDecimal num2 = new BigDecimal(amountToBeGenerated);
        BigDecimal num3 = (num1.divide(num2, scale,RoundingMode.HALF_UP));

        System.out.println("Degree of randomness in percentage is "
                +num3.multiply(BigDecimal.valueOf(100))+" %");
    }
    public void UsingRandomClass(){
        Set<String> setOfId = new HashSet<>();
        Random random = new Random(1234567890);
        char capital;

        for (int i = 0; i<amountToBeGenerated; i++){
            String randomString = "";
            int x = random.nextInt(10);
            if (x%2==0){
                randomString = randomString + "-";
            }else {
                randomString = randomString + random.nextInt(10);
            }
            for (int d =0; d<7; d++){
                randomString = randomString + random.nextInt(10);
            }
            capital = (char) (random.nextInt(26) + 'A');
            randomString = randomString + capital;
            setOfId.add(randomString);
        }
        System.out.println("Size of set containing randomly generated ID's is "+setOfId.size());
        int scale = 10;
        BigDecimal num1 = new BigDecimal(setOfId.size());
        BigDecimal num2 = new BigDecimal(amountToBeGenerated);
        BigDecimal num3 = (num1.divide(num2, scale,RoundingMode.HALF_UP));

        System.out.println("Degree of randomness in percentage is "
                +num3.multiply(BigDecimal.valueOf(100))+" %");
    }
}
