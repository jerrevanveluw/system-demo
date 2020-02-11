#!/bin/bash

WORK_DIR=$(pwd)

cd "${WORK_DIR}"/user && mvn clean && \
cd "${WORK_DIR}"/userdailyfable && mvn clean && \
cd "${WORK_DIR}"/todo && mvn clean && \
cd "${WORK_DIR}"/app  && mvn clean && \
cd "${WORK_DIR}"/app/app-shell/src/main/react && yarn clean
