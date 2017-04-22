#FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8
FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD cloud-eureka1-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]