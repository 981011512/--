@echo off

start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-ucenter-service-1.0-SNAPSHOT.jar >./log/cf-ucenter-service-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 20 /NOBREAK
start java -Xms1024m -Xmx3072m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-car-park-service-1.0-SNAPSHOT.jar >./log/cf-car-park-service-1.0-SNAPSHOT.jar.log  2>&1 &
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-car-park-api-1.0-SNAPSHOT.jar >./log/cf-car-park-api-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms512m -Xmx3072m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-file-service-1.0-SNAPSHOT.jar >./log/cf-file-service-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms512m -Xmx1024m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-pay-service-1.0-SNAPSHOT.jar >./log/cf-pay-service-1.0-SNAPSHOT.jar.log  2>&1 &
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-car-park-admin-1.0-SNAPSHOT.jar >./log/cf-car-park-admin-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms512m -Xmx2048m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-chat-service-1.0-SNAPSHOT.jar >./log/cf-chat-service-1.0-SNAPSHOT.jar.log  2>&1 &
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-pay-api-1.0-SNAPSHOT.jar >./log/cf-pay-api-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-ucenter-auth-1.0-SNAPSHOT.jar >./log/cf-ucenter-auth-1.0-SNAPSHOT.jar.log  2>&1 &
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-pay-admin-1.0-SNAPSHOT.jar >./log/cf-pay-admin-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-sms-service-1.0-SNAPSHOT.jar >./log/cf-sms-service-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-sms-api-1.0-SNAPSHOT.jar >./log/cf-sms-api-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-ucenter-api-1.0-SNAPSHOT.jar >./log/cf-ucenter-api-1.0-SNAPSHOT.jar.log  2>&1 &
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-ucenter-admin-1.0-SNAPSHOT.jar >./log/cf-ucenter-admin-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms256m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-file-api-1.0-SNAPSHOT.jar >./log/cf-file-api-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms128m -Xmx300m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-position-service-1.0-SNAPSHOT.jar >./log/cf-position-service-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms128m -Xmx300m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-position-api-1.0-SNAPSHOT.jar >./log/cf-position-api-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms128m -Xmx300m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-ad-service-1.0-SNAPSHOT.jar >./log/cf-ad-service-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms128m -Xmx300m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-ad-api-1.0-SNAPSHOT.jar >./log/cf-ad-api-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms128m -Xmx300m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-ad-admin-1.0-SNAPSHOT.jar >./log/cf-ad-admin-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms128m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-charging-service-1.0-SNAPSHOT.jar >./log/cf-charging-service-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms128m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-charging-api-1.0-SNAPSHOT.jar >./log/cf-charging-api-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 5 /NOBREAK
start java -Xms128m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-charging-admin-1.0-SNAPSHOT.jar >./log/cf-charging-admin-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 10 /NOBREAK
start java -Xms128m -Xmx400m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-logistics-service-1.0-SNAPSHOT.jar >./log/cf-logistics-service-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 10 /NOBREAK
start java -Xms128m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-logistics-api-1.0-SNAPSHOT.jar >./log/cf-logistics-api-1.0-SNAPSHOT.jar.log  2>&1 &
TIMEOUT /T 10 /NOBREAK
start java -Xms128m -Xmx512m -Dlog4j2.formatMsgNoLookups=true -jar ./jar/cf-logistics-admin-1.0-SNAPSHOT.jar >./log/cf-logistics-admin-1.0-SNAPSHOT.jar.log  2>&1 &

pause
