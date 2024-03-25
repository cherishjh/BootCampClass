# 사용자가 현재 위치해 있는 폴더 
pwd
# 현재 위치에서 파일, 폴더 목록
ls   //있는지 없는지 확인

# +자세히
ls-1   //소유 관계
# +숨김파일까지 
ls -al
#디렉토리 생성
mkdir heejune_dir
#특정 디렉토리로 이동
cd heejune_dir
#루트 디렉토리 이동
cd /      (꼭 한 칸 띄고 "/")
#다시 기존의 폴더로 이동
cd home/hanheejune/heejune_dir
# #상위 폴더로 이동
# cd ..
cd / 

#비어있는 파일 만들기 
touch first_file.txt
#파일 내용 조회
cat first_file.txt



#터미널창에 문자열 출력
echo "hello world"
#echo를 통해 파일에 write 하는 방법
echo "hello world" > first_file.txt
# > 하나를 쓰면 덮어쓰기, >> 를 쓰면 추가하기 

#파일을 읽기 위해서는 <를 사용 
#sort 명령어와 함께 많이 사용
sort < first_file.txt 

명령어 오타가 너무 많이 나왔을때 ctrl+c
이미 쓴 명령어는 화살표 위 방향을 눌러서 past 명령어 불러올 수 있음


#history 명령어를 통해 이전에 실행했던 명령어 조회 
history
#입력 중인 명령창 정리
clear

# . 은 현재 폴더를 의미 
  . /

#rm은 삭제 명령어, rm -r은 디렉토리까지 삭제 
# rm -rf는 디렉토리까지 묻지 않고 삭제
rm -rf heejune_dir

#cp 는 복사 명령어
#cp 복사대상 복사된 파일명
cp- -r test_dir heejune_dir/second_dir

#mv는 이동명령어(r 옵션 필요 없음)
# mv는 이동대상 이동된 파일명 (경로 포함)
# mv는 파일명을 변경하는데도 많이 사용된다.
mv test_dir heejune_dir/second_dir

# head, tail
head는 cat처럼 파일을 출력하는 것, 상위 n행 조회
#tail은 하위 n행 조회
# head 파일명 : 상위 10개
# 특정 개수 -n 붙이기 : head -5 파일명  >> 상위 5개 조회

