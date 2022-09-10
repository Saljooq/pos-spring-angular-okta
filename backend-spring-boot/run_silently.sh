#!/bin/bash

# REMEMBER TO run 'chmod +x run_silently.sh' to allow execution and then './run_silently'

# first we kill any existing processes on the port
kill $(lsof -t -i:8080)

# next we compile into a jar
mvn clean install

# next we run the jar silently and output into spring.out file
nohup java -jar target/*.jar > spring.out 2>&1 &

# next we let the users know where to see the output
echo "read spring.out to see how it ran"

# we tail the output file to see the output
tail -F spring.out

# a simple ctrl + c will end the tail
