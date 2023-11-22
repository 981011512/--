#!/bin/bash

for((i=8080;i<=8100;i++));  
do   
kill -9 $(netstat -nlp | grep :$i | awk '{print $7}' | awk -F"/" '{ print $1 }')
done
nohup java -Xms128m -Xmx200m -jar ./jar/cf-sms-service-1.0-SNAPSHOT.jar >./log/cf-sms-service-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 20
nohup java -Xms128m -Xmx200m -jar ./jar/cf-sms-api-1.0-SNAPSHOT.jar >./log/cf-sms-api-1.0-SNAPSHOT.jar.log  2>&1 &
nohup java -Xms128m -Xmx200m -jar ./jar/cf-ucenter-service-1.0-SNAPSHOT.jar >./log/cf-ucenter-service-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 20
nohup java -Xms128m -Xmx256m -jar ./jar/cf-ucenter-auth-1.0-SNAPSHOT.jar >./log/cf-ucenter-auth-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 25
nohup java -Xms128m -Xmx300m -jar ./jar/cf-ucenter-api-1.0-SNAPSHOT.jar >./log/cf-ucenter-api-1.0-SNAPSHOT.jar.log  2>&1 &
nohup java -Xms128m -Xmx300m -jar ./jar/cf-ucenter-admin-1.0-SNAPSHOT.jar >./log/cf-ucenter-admin-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 10
nohup java -Xms128m -Xmx200m -jar ./jar/cf-file-service-1.0-SNAPSHOT.jar >./log/cf-file-service-1.0-SNAPSHOT.jar.log  2>&1 &
nohup java -Xms128m -Xmx200m -jar ./jar/cf-pay-service-1.0-SNAPSHOT.jar >./log/cf-pay-service-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 20
nohup java -Xms128m -Xmx256m -jar ./jar/cf-file-api-1.0-SNAPSHOT.jar >./log/cf-file-api-1.0-SNAPSHOT.jar.log  2>&1 &
nohup java -Xms128m -Xmx200m -jar ./jar/cf-car-park-service-1.0-SNAPSHOT.jar >./log/cf-car-park-service-1.0-SNAPSHOT.jar.log  2>&1 &
nohup java -Xms128m -Xmx256m -jar ./jar/cf-pay-api-1.0-SNAPSHOT.jar >./log/cf-pay-api-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 20
nohup java -Xms128m -Xmx200m -jar ./jar/cf-car-park-api-1.0-SNAPSHOT.jar >./log/cf-car-park-api-1.0-SNAPSHOT.jar.log  2>&1 &
nohup java -Xms128m -Xmx300m -jar ./jar/cf-car-park-admin-1.0-SNAPSHOT.jar >./log/cf-car-park-admin-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 5
nohup java -Xms128m -Xmx300m -jar ./jar/cf-pay-admin-1.0-SNAPSHOT.jar >./log/cf-pay-admin-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 5
nohup java -Xms128m -Xmx300m -jar ./jar/cf-ad-service-1.0-SNAPSHOT.jar >./log/cf-ad-service-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 5
nohup java -Xms128m -Xmx300m -jar ./jar/cf-ad-api-1.0-SNAPSHOT.jar >./log/cf-ad-api-1.0-SNAPSHOT.jar.log  2>&1 &
sleep 5
nohup java -Xms128m -Xmx300m -jar ./jar/cf-ad-admin-1.0-SNAPSHOT.jar >./log/cf-ad-admin-1.0-SNAPSHOT.jar.log  2>&1 &
