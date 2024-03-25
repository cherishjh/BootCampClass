echo "script practice1 start"
mkdir /home/hanheejune/mydir_dir    #"/"가 빠져서 절대위치로 못감
cd /home/hanheejune/mydir_dir       #"/"가 빠져서 절대위치로 못감
touch file1.txt
touch file2.txt
echo "Hello from file1" > file1.txt
echo "Hello from file2" > file2.txt
cp file1.txt file1_backup.txt
mv file2.txt file2_rename.txt
echo "script practice1 complete"

