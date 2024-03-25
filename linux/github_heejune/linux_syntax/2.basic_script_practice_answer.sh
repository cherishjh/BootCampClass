#터미널창에 "script practice1 start"
echo "script practice1 start"
#홈디렉토리에서 mydir 이라는 폴더 생성
cd
mkdir mydir
#-mydir로 이동해서 file1.txt, file2.txt 파일 생성
cd mydir
touch file1.txt
toudh file2.txt
#-file1. txt에는 Hello from file1 이라는 문구 입력
#-file2. txt에는 Hello from file2 이라는 문구 입력
echo "Hello from file1" > file1.txt
echo "Hello from file2" > file2.txt
#-file1.txt는 복사본 만들기 file1_backup.txt
cp file1.txt file1_backup.txt
#-file2.txt는 file2_rename으로 이름 변경
mv file2.txt file2_rename.txt
# script practice complete 출력
echo "script practice complete"
