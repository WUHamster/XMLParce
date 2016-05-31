package Home2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WUHamster on 31.05.2016.
 */
public class ConsoleHelper {
    public static void writeMessege(String messege){
        System.out.println(messege);
    }

    public static String readLine(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "Something went wrong ((";
        }
    }

    public static String askFrom() {
        while (true) {
            writeMessege("Enter the city of departure please");
            String city = readLine();
            if (city.length()>0){
                return city;
            }
        }
    }

    public static String askTo() {
        while (true) {
            writeMessege("Enter the city of arrival please");
            String city = readLine();
            if (city.length()>0){
                return city;
            }
        }
    }

    public static String askDate() {
        while (true) {
            writeMessege("Enter the date please. DD.MM.YYYY");
            String date = readLine();
            if (date.length() == 10){
                return date;
            }
            else writeMessege("Wrong Date");
        }
    }

    public static String askTime() {
        while (true) {
            writeMessege("Enter departure time please. HH:MM");
            String time = readLine();
            if (time.length() == 5){
                return time;
            }
            else writeMessege("Wrong Time");
        }
    }



}
