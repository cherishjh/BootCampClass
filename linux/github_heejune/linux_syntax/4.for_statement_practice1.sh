if [ -d mydir2 ]; then
    echo "duty done"
else
    mkdir mydir2
    cd mydir2
    touch "hello_world.txt"
    for a in {1..100}
    do echo "hello world $a" >> bonjour.txt
    done
fi