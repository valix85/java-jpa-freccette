package Utility;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomData {

    public static LocalDate getRandomDate(){
        try {
            long minDay = LocalDate.of(2014, 1, 1).toEpochDay();
            long maxDay = LocalDate.now().toEpochDay();
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
            System.out.println("DATA: " + randomDate);
            return randomDate;
        }catch(Exception e){
            return getRandomDate();
        }

    }


}
