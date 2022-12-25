#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/GuessPrice/guess-price/src
COPY build.gradle.kts /home/GuessPrice/guess-price
RUN gradle -b /home/GuessPrice/guess-price/build.gradle.kts bootRun
EXPOSE 8080