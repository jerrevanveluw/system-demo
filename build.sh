#!/bin/bash

WORK_DIR=$(pwd)

cd "${WORK_DIR}"/user && mvn install &
cd "${WORK_DIR}"/todo && mvn install &
cd "${WORK_DIR}"/app/app-common && mvn install && cd ../app-shell/src/main/react && yarn && yarn build &
wait
cd "${WORK_DIR}"/app  && mvn install
