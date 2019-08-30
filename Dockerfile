FROM maven:3-jdk-8

WORKDIR /build

COPY build.sh /build

ENTRYPOINT ["/build/build.sh"]
