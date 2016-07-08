/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package say.hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asel Meemeduma
 */
public class SayHello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String question = "How are you ?";
        boolean filter = false;
//        String name = "Asel";
//        System.out.println("Hi, I am Elsa.");
//        System.out.println("Hello  " + name + ",");
        try {
            System.out.println(question);
            if (question.contains("What")) {
                if (question.contains("name")) {
                    File file = new File("garammer.txt");
                    FileReader fileReader = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fileReader);
                    while (reader.read() != 0) {
                        if (!filter) {
                            String grammer = reader.readLine();
                            String[] split = grammer.split("=");
                            if (grammer.contains(split[0])) {
                                String[] q_count = split[1].split(",");
                                Random r = new Random();
                                int answer = r.nextInt(q_count.length);
                                for (int i = 0; q_count.length > i; i++) {
                                    System.out.println(q_count[answer]);
                                    filter = true;
                                    break;
                                }
                            }
                        }else{
                            break;
                        }
                    }
                }
            }else{
                System.out.println("Sorry ..!! I didn't got you ?");
            }

        } catch (IOException ex) {
            Logger.getLogger(SayHello.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
