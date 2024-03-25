package Spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Webserver3 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);     //사용자 요청이 들어옴(serversocekt, header) ;; 포트 설정
            System.out.println("8081 서비스 시작");
            //header
//                POST /somepath HTTP/1.1
//                Host: www.example.com
//                Content-Type: application/x-www-form-urlencoded
//                Content-Length: 27
            // body
//                userInput=hello world

            while (true) {
                //socket 객체는 사용자의 client 객체
                try (Socket socket = serverSocket.accept()){
                    BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    StringBuilder sb= new StringBuilder();
                    String line="";
                    //readLine은 한 줄 읽기
                    while(!(line= br.readLine()).isBlank()){
                        sb.append(line+"\n");
                    }
                    if(sb.toString().contains("POST")){
                        char[] buffer = new char[1024];
                        br.read(buffer);
                        System.out.println("POST body data : " + new String(buffer));
                        System.out.println("POST all data : " + sb.toString());
                    }

                    String httpRes = "HTTP/1.1 200 OK \r\n\r\n" + "ok";
                    socket.getOutputStream().write(httpRes.getBytes("UTF-8"));     //write로 전송
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
