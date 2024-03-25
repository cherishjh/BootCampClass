1.윈도우 : github 에 dump 파일 업로드
2. 리눅스
    1) linux에 DB 구축 (MariaDB 설치 및 데이터베이스 설정)
        (1) 우분투 버전 확인
         lsb_release -a 
         (2) 마리아 db 설치
         sudo apt-get install -y mariadb-server

    2) github 소스코드 clone
        https://github.com/cherishjh/mariadb_syntax.git
    3) 해당 폴더로 이동해서 덤프 복원 명령어 실행
        mysql -u root -p board < dumpfile.sql


-- 강사님 script
1. sudo apt-get update
2. sudo apt-get upgrade // sudo apt-get -y upgrade
3. sudo apt-get install -y mariadb-server
    -- -y옵션 뜻은 yes를 안 물어보겠다. 
4. 마리아db start: sudo systemctl start mariaDB
    마리아 db 끝: sudo systemctl enable mariaDB
    (돌아가고 있는지 확인하는 것: ps -ef | grep mariadb)
5. sudo mariaDB -u root -p
6. create database board
7. use board
8. exit
9. git clone: 레파지토리 주소; 
10. dump 파일 있는곳까지 이동 : cd ~ 
11. sudo mysql -u root -p board < dumpfile.sql