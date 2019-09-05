#!/usr/bin/env bash
cd ../cloud/gateway
mvn clean package -DskipTests && mvn docker:build