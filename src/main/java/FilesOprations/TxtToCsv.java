package FilesOprations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/*
//This class for 1- Read the student list on the system and convert it into a proper format .csv first criteria /doCsvFormat()/.
                 2- Implement a function that prints all student data that exist in the CSV files that you generated before in section 1 /printStudentData()/.
*/
public class TxtToCsv {

    BufferedWriter bw = null;
    Scanner sc = null;


    public static void main(String[] args) {
        final TxtToCsv tc = new TxtToCsv();

        tc.doCsvFormat(tc.getPaths("files/student-data.txt"), "#", ",", "$", "\n", tc.getPaths("files/student-data.csv.txt"));
        tc.printStudentData(tc.getPaths("files/student-data.csv.txt"), tc.getPaths("files/print-student-data"));

//        String output[] = tc.readFileInString(tc.getPaths("files/student-data.csv.txt"));
//        tc.writeStringInFile(output, tc.getPaths("files/print-student-data"));

    }

//    protected String[] readFileInString(Path path1) {
//        String text[]=new String[200];
//        try {
//            sc = new Scanner(path1);
//
//            while (sc.hasNextLine()) {
//                int i=0;
//                text[i] = sc.nextLine();
//                text[i] = text[i].replaceAll("id,name,Grade,email,address,region,country", "\nid      name             Grade       email                  address                         region         country ");
//                text [i]= text[i].replaceAll(",", ",      ");
//
//                i++;
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            sc.close();
//            return text;
//        }
//
//
//    }
//
//    void writeStringInFile(String text[], Path path2) {
//
//        try {
//            bw = Files.newBufferedWriter(path2);
//            for (int i = 0; i < text.length&&text[i] != null; i++) {
//                System.out.println(text[i]);
//                bw.write(text[i]);
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//
//            try {
//                bw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    private void printStudentData(Path p1, Path p2) {
        String text;

        try {
            bw = Files.newBufferedWriter(p2);
            sc = new Scanner(p1);
            bw.write("-------------------------------\nCurrent Student List\n-------------------------------");
            while (sc.hasNextLine()) {
                text = sc.nextLine();
                text = text.replaceAll("id,name,Grade,email,address,region,country", "\nid      name             Grade       email                  address                         region         country ");
                text = text.replaceAll(",", ",      ");

                // System.out.println(s);
                bw.write(text);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    protected Path getPaths(String file) {
        return Paths.get(file);
    }

    protected void doCsvFormat(Path p1, String c1, String c2, String c3, String c4, Path p2) {
        String text;
        try {
            bw = Files.newBufferedWriter(p2);
            sc = new Scanner(p1);
            while (sc.hasNextLine()) {
                text = sc.nextLine();
                text = text.replace(c1, c2);
                text = text.replace(c3, c4);
                bw.write(text);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
