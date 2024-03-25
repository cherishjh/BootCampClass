//package C17ExceptionfFileParsing;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.Map;
//
//public class C1703JsonWithJackSonRaw {
//    public static void main(String[] args) {
//        ObjectMapper mapper= new ObjectMapper();
//        try {
////            readTree를 통해서 json을 계층적 트리구조형태로 변환
//            File myPath = Paths.get("src/C17ExceptionfFileParsing/test-data1.json").toFile();
//            JsonNode data1= mapper.readTree(Paths.get("src/C17ExceptionfFileParsing/text_file.txt").toFile());
//            Map<String,String> studentMap= new HashMap<>();
//            studentMap.put("id",data1.get("id").asText());
//            studentMap.put("name",data1.get("name").asText());
//            studentMap.put("classNumber",data1.get("classNumber").asText());
//            studentMap.put("city",data1.get("city").asText());
//            System.out.println(studentMap);
////      key value 값이 예상이 안될때 Object 타입으로 받을 수 있다
//            Map<String, String> studentMap2=mapper.readValue(myPath,Map.class);
//            System.out.println(studentMap2);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//}
