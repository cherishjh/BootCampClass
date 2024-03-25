mkdir mydir
cd mydir
touch first.txt second.txt
file_name="first.txt"
if [-f "$first_name.txt"]; then 
    echo "$file_name exists"
else
    echo "$file_name does not exists"
fi