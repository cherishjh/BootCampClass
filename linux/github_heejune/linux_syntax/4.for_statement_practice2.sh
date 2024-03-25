#각 파일에 한 문구를 집어 넣는것 (file2 1 -> hello world from file2  1번)
echo "practice3 start"
mkdir mydir3
cd mydir3
for a in {1..100}
do 
touch "file$a.txt"
echo "hello world from file$a" >> "file$a.txt"
done
echo "practice complete"


#각 파일에 같은 문구를 100개 집어 넣는 반복문
echo "practice3 start"
mkdir mydir4
cd mydir4
for a in {1..100}
do 
    touch "file$a.txt"
    for b in {1..100}
    do
        echo "hello world from file$a" >> "file$a.txt"
    done
done
echo "practice complete"
