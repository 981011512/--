#!/bin/bash
IP=$1
DBIP=$2
DBUSER=$3
DBPWD=$4
RDIP=$5
RDPWD=$6
MGIP=$7
MGUSER=$8
MGPWD=$9

find /www/java/cf_bak/ -type f -regex ".*\.yml\|.*\.properties" |xargs perl -pi -e"s/zookeeper:\/\/47.100.11.151/zookeeper:\/\/${IP}/g"

find /www/java/cf_bak/ -type f -regex ".*\.yml\|.*\.properties" |xargs perl -pi -e"s/mysql:\/\/47.100.11.151/mysql:\/\/${DBIP}/g"

find /www/java/cf_bak/ -type f -regex ".*\.yml\|.*\.properties" |xargs perl -pi -e"s/username: caifeng/username: ${DBUSER}/g"

find /www/java/cf_bak/ -type f -regex ".*\.yml\|.*\.properties" |xargs perl -pi -e"s/password: P8CMBiepXSLRfGAL/password: ${DBPWD}/g"

find /www/java/cf_bak/ -type f -regex ".*\.yml\|.*\.properties" |xargs perl -pi -e"s/host: 47.100.11.151/host: ${RDIP}/g"

find /www/java/cf_bak/ -type f -regex ".*\.yml\|.*\.properties" |xargs perl -pi -e"s/password: gebixiaowang/password: ${RDPWD}/g"

find /www/java/cf_bak/ -type f -regex ".*\.yml\|.*\.properties" |xargs perl -pi -e"s/mongodb:\/\/caifeng:caifEng666@47.100.11.151:27017\/\?authSource=caifeng/mongodb:\/\/${MGUSER}:${MGPWD}@${MGIP}:27017\/\?authSource=caifeng/g"
