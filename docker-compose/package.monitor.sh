#!/usr/bin/env bash
cd ../cloud/monitor/admin
mvn clean package -DskipTests && mvn docker:build

cd ../hystrix-dashboard
mvn clean package -DskipTests && mvn docker:build

cd ../turbine
mvn clean package -DskipTests && mvn docker:build
