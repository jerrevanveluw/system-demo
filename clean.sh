#!/usr/bin/env bash

WORK_DIR=$(pwd)

cd "${WORK_DIR}"/user && mvn clean &
cd "${WORK_DIR}"/todo && mvn clean &
cd "${WORK_DIR}"/app  && mvn clean &
wait
