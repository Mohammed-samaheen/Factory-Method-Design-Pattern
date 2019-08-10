package Util;

import java.io.FileWriter;

public class Logger {
    public static void log(String s) {
        try {
            FileWriter fw = new FileWriter("result.txt", true);
            fw.write(s);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Done...\n");
    }
}
