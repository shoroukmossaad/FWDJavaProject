package FilesOprations;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/*
  This class for 1-Implement view-specific student data functionality form json file /printStudentCourses(JSONObject jObj)/.
                 2- Implement enrolling a student in a course functionality / addCourses(String path)/
                 */

public class JsonParser {


    public static void main(String[] args) {
        final JsonParser jp = new JsonParser();
        JSONObject jsonObject = jp.makeJsonObject("files/studentCourcesIds.json");
        jp.printStudentCourses(jsonObject);

        jp.addCourses("files/studentCourcesIds.json");

    }

    JSONObject makeJsonObject(String jsonPath) {
        String data = null;
        JSONObject jObj = null;
        try {
            data = new String(Files.readAllBytes(Paths.get(jsonPath)));
            jObj = new JSONObject(data);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return jObj;
        }


    }

    void printStudentCourses(JSONObject jObj) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter student id: ");
        String id = input.nextLine();
        JSONArray courses = null;

        jObj.toJSONArray(courses);
        if (jObj.has(id)) {
            courses = jObj.getJSONArray(id);
            if (courses.isEmpty()) {
                System.out.println("====================================================================================\n" + "Student Details page\n" + "====================================================================================\n" + "Name: Malcolm Barnes         Grade:9                Email:velit.aliquam@outlook.couk" + "------------------------------------------------------------------------------------\n" + "Enrolled courses.\n" + "This student hasn't enrolled in any courses\n" + "------------------------------------------------------------------------------------");
            } else {
                System.out.println("====================================================================================\n" + "Student Details page\n" + "====================================================================================\n" + "Name: Malcolm Barnes         Grade:9                Email:velit.aliquam@outlook.couk\n" + "\n------------------------------------------------------------------------------------\n" + "Enrolled courses.\n" + courses + "\n" + "1- 1,      Algorithms,    \"Scott, Austin C.\",    8 weeks,     2H,      Hall1\n" + "------------------------------------------------------------------------------------");
            }
        } else {
            System.out.println("Invalid Student ID");
        }


    }


    void addCourses(String path) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter student id: ");
        String id = input.nextLine();
        System.out.print("please enter  the number of courses you want to enrol them :");
        int num = input.nextInt();
        int courseNum[] = new int[num];
        System.out.print("please enter courses ids:");
        for (int i = 0; i < num; i++) {
            courseNum[i] = input.nextInt();
        }


        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        FileWriter fw = null;
        BufferedWriter bw = null;
        if (!jsonObject.has(id)) {
            for (int i = 0; i < courseNum.length; i++) {
                if (courseNum[i] != courseNum[i++]) {


                    if (jsonArray.length() < 6) {
                        jsonArray.put(courseNum[i]);
                    } else if (i < courseNum.length) {
                        System.err.println("EXCEPTION:you can enroll in only 6 courses");
                    }
                }


                jsonObject.put(id, jsonArray);
            }
        } else {
            jsonObject.append(id, jsonArray);
        }

        jsonObject.put(id, jsonArray);

        try {
            fw = new FileWriter(path, true);

            fw.write(jsonObject.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.flush();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void deleteCourses() {

    }

}

