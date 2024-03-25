//package C17ExceptionfFileParsing;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class C1704JsonWithJackSonClass {
//    public static void main(String[] args) {
//        File myPath = Paths.get("src/C17ExceptionfFileParsing/test-data2.json").toFile();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            JsonNode data1= mapper.readTree(myPath);
//            JsonNode students= data1.get("students");
//            List<data> studentList= new ArrayList<>();
//            for(JsonNode j : students){
//                data myStudents=mapper.readValue(j.toString(),data.class);
//                studentList.add(myStudents) ;
//            }
//            System.out.println(students);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//class data{
//    private int id;
//    private String name;
//    private String classNumber;
//    private String city;
//
//    data(){
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getClassNumber() {
//        return classNumber;
//    }
//
//    public String getCity() {
//        return city;
//    }
//}
//
