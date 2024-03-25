echo "start"
if [ -d "mydir2" ]; then   
    cd mydir2
else   
    mkdir mydir2
    cd mydir2
fi
if[ -f "test.txt" ]; then    
    rm -rf test.txt
    touch test.txt
else   
    touch test.txt
fi
for a in {1..100}
