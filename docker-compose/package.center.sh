#!/usr/bin/env bash
cd ../cloud/center/eureka
mvn clean package -DskipTests && mvn docker:build

cd ../bus
mvn clean package -DskipTests && mvn docker:build

cd ../config
mvn clean package -DskipTests && mvn docker:build
