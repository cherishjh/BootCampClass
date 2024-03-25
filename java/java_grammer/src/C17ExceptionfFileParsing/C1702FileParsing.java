package C17ExceptionfFileParsing;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

//text 파일 parsing
public class C1702FileParsing {
    public static void main(String[] args) {
//        src\C17ExceptionfFileParsing
        Path filePath = Paths.get("src/C17ExceptionfFileParsing/text_file.txt");     //java는 \\역 슬래시 안 써서 변경

//        버퍼 기능이 구현화되어 있고, nio 패키지에서는 non-blocking 방식 사용
//        StandardCharsets.UTF_8 이 기본이라 생략 가능
//        CREATE NEW 다음에 APPEND 실행 가능
        try {
            if (Files.exists(filePath)) {
                Files.write(filePath, "손흥민\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } else {
                Files.write(filePath, "손흥민\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//      파일읽기 : readString, readAllLines(list 형태)
        try{
            /*String mySt= Files.readString(filePath);
            System.out.println(mySt);*/
            //readAllLines을 가지고 for 문 돌려 출력
            List<String> mySt= Files.readAllLines(filePath);
            for(String a: mySt){
                System.out.println(a);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        String temp = "손흥민\n" +
                    "손흥민\n"+
                    "손흥민\n"+
                    "손흥민";
    }
}
