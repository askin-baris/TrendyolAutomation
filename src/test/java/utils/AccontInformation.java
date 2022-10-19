package utils;

import java.util.concurrent.ThreadLocalRandom;

public class AccontInformation {
    public static String ValidEmail = "baris.askin@hotmail.com";
    public static String ValidPassword = "RAPtor1234";
    public static String InvalidEmail = "baris"+ ThreadLocalRandom.current().nextInt(0, 99999999+ 1)+"@adfkldknmd1fdl.com";
}
