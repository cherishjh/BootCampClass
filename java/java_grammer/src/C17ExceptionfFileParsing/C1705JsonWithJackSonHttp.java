//package C17ExceptionfFileParsing;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.ArrayList;
//import java.util.List;
//
//public class C1705JsonWithJackSonHttp {
//    public static void main(String[] args) {
////        Http클라이언트 생성
//        HttpClient client = HttpClient.newHttpClient();
//        ObjectMapper mapper = new ObjectMapper();
////      HTTP 요청객체 생성
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/"))
//                .GET()
//                .build();
//
//        Path filePath = Paths.get("src/C17ExceptionfFileParsing/text_file.txt");
////        http 응답 객체 생성
//        try {
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            String post = response.body();
//            JsonNode jsonNode = mapper.readTree(post);
////           Post mypost= new Post(jsonNode.get("id").asInt(), jsonNode.get("title").asText(), jsonNode.get("body").asText(),jsonNode.get("userId").asInt());
////      readValue를 사용해서 객체로 곧바로 매핑
//          /*  Post myPost2= mapper.readValue(post, Post.class);
//            System.out.println(myPost2);*/
////            JsonNode는 트리구조 이므로
////            for(JsonNode j: jsonNode) 형식이 가능
//            List<Post> postList= new ArrayList<>();
//            for (JsonNode j : jsonNode) {
//                Post myPost= mapper.readValue(j.toString(), Post.class);
//                postList.add(myPost);
//            }
//            System.out.println(postList);
//
////            java 객체를 json 데이터로 직렬화
//            String serialized_data= mapper.writeValueAsString(postList);
//            System.out.println(serialized_data);
//        } catch(IOException | InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//}
//class Post {
//    private long id;
//    private String title;
//    private String body;
//    private int userId;
//
//    public long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    Post() {
//    }
//
//    /* Post(long id, String title, String body, int userId){
//              this.id=id;
//              this.title=title;
//              this.body=body;
//              this.userId=userId;
//        }*/
//    @Override
//    public String toString() {
//        return "id: " + this.id + " title: " + this.title;
//    }
//}
