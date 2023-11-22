#!/bin/bash

for((i=8080;i<=8100;i++));  
do   
kill -9 $(netstat -nlp | grep :$i | awk '{print $7}' | awk -F"/" '{ print $1 }')
done
