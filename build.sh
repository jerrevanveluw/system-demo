#!/bin/bash

WORK_DIR=$(pwd)

cd "${WORK_DIR}"/user && mvn clean install && \
cd "${WORK_DIR}"/userdailyfable && mvn clean install && \
cd "${WORK_DIR}"/todo && mvn clean install && \
cd "${WORK_DIR}"/app/app-common && mvn clean install && \
cd "${WORK_DIR}"/app/app-shell/src/main/react && yarn && yarn build && \
cd "${WORK_DIR}"/app/app-shell/src/main/webcomponents && npm i && npm run build && \
cd "${WORK_DIR}"/app && mvn clean install
