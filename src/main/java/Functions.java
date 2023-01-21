//package converter;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.util.Scanner;
//
//public class Functions {
//    public static void main(String[] args) {
//        final Functions f = new Functions();
//        Scanner input=new Scanner(System.in);
//        int id=input.nextInt();
//        f.printStudentCourses("D:\\FWD_first_project\\jsonvalidator",id);
//
//    }
//
//    void printStudentCourses(String f, int id) {
//        //String gg = String.valueOf(f);
//
//        try {
//            JSONParser jp = new JSONParser();
//            Object obj = jp.parse(f);
//            JSONObject jo = (JSONObject) obj;
//            if (jo.containsKey(id)) {
//                System.out.println("Yes");
//
//            } else {
//                System.out.println("NO");
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//}
