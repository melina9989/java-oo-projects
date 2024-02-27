package gr.aueb.cf.myPractice.ioApp;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HomeworkGrades {
    public static void main(String[] args) {
        String line = "";
        String name = null;
        double average = 0.0;
            try(BufferedReader bf = new BufferedReader(new FileReader("C:/tmp/grades.txt", StandardCharsets.UTF_8));
                PrintStream ps = new PrintStream("C:/tmp/primOut.txt", StandardCharsets.UTF_8);
                PrintStream psLog = new PrintStream("C:/tmp/logGrades.txt");
            ) {
                while ((line = bf.readLine()) != null) {
                    String[] grades = line.split(" +");

                    String fullName = grades[0].concat(" ").concat(grades[1]);
                    int grade1 = Integer.parseInt(grades[2]);
                    int grade2 = Integer.parseInt(grades[3]);
                    average = (double)((grade1 + grade2) / 2);
                    if (grade1 < 0 || grade1 > 10 || grade2 < 0 || grade2 > 10) {
                        log(psLog, "Invalid grade for student " + fullName + "\n");
                    }else {
                        ps.printf("Ο μεσος ορος για τον μαθητη %s ειναι %.2f\n", fullName, average);
                    }
                }

                
                

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
    }
    public static void log(PrintStream ps , String message) {
        ps.print(message);
        }

}
