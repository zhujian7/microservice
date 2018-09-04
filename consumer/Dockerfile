# 版本信息
FROM primetoninc/jdk:1.8

# change path to your repo dir
COPY target/consumer-0.0.1-SNAPSHOT.jar  /consumer.jar

EXPOSE 8081

CMD ["java", "-jar", "/consumer.jar"]
