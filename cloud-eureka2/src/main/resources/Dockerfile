#FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8
FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD cloud-eureka2-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#时间同步设置
RUN apk update && apk add curl bash tree tzdata \
    && cp -r -f /usr/share/zoneinfo/Hongkong /etc/localtime \
    && echo -ne "Alpine Linux 3.4 image. (`uname -rsv`)\n" >> /root/.built
# Define bash as default command
CMD ["/bin/bash"]