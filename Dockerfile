FROM adoptopenjdk:11-jre-hotspot as builder
## 리눅스 상에서
WORKDIR deploy
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:11-jre-hotspot
COPY --from=builder /deploy/dependencies /home
COPY --from=builder /deploy/spring-boot-loader /home
COPY --from=builder /deploy/snapshot-dependencies /home
COPY --from=builder /deploy/application /home
EXPOSE 8080
WORKDIR /home
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "org.springframework.boot.loader.JarLauncher"]



