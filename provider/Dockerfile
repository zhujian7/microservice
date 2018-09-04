# 版本信息
FROM primetoninc/jdk:1.8

# change path to your repo dir
COPY target/provider-0.0.1-SNAPSHOT.jar  /provider.jar

EXPOSE 8080

CMD ["java", "-jar", "/provider.jar"]
