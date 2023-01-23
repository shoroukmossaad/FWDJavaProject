//package FilesOprations;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class WriteOnJson {
//    public static void main(String[] args) {
//        WriteOnJson thisClass=new WriteOnJson();
//        Scanner input = new Scanner(System.in);
//        System.out.println("please enter student id: ");
//        String id = input.nextLine();
//        System.out.println("please enter student id: ");
//        int courseNum = input.nextInt();
//        int arr[]= new int[courseNum];
//        for (int i = 0; i < courseNum; i++) {
//            arr[i]=input.nextInt();
//        }
//        thisClass.addCources(id,arr,"files/studentCourcesIds.json");
//    }
//
//    void addCources(String id, int [] courseNum, String path) {
//
//
//        //First Employee
//        JSONObject jsonObject = new JSONObject();
//
//        //Add employees to list
//        JSONArray jsonArray = new JSONArray();
//
//
//        for (int i = 0; i < courseNum.length; i++) {
//            jsonObject.put(id,courseNum[i]);
//        }
//        jsonArray.add(jsonObject);
//
//        //Write JSON file
//        try (FileWriter file = new FileWriter(path)) {
//            //We can write any JSONArray or JSONObject instance to the file
//            file.write(jsonArray.toJSONString());
//            file.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//
