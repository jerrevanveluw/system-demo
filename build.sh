#!/usr/bin/env bash

WORK_DIR=$(pwd)

cd ${WORK_DIR}/user && mvn clean install &
cd ${WORK_DIR}/todo && mvn clean install &
wait
cd ${WORK_DIR}/app  && mvn clean install && \
cd ${WORK_DIR}      && docker-compose build
