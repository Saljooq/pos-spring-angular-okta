#!/bin/bash

# REMEMBER TO run 'chmod +x run_silently.sh' to allow execution and then './run_silently'

# first we kill any existing processes on the port
kill $(lsof -t -i:4200)

# next we install dependencies and 'compile'
npm i

# next we run the angular code silently
nohup ng serve > angular.out 2>&1 &

# we tail the output file to see the output
# tail -F angular.out

# a simple ctrl + c will end the tail