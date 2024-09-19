# Use an official Ubuntu as a base image
FROM ubuntu:latest

# Install necessary tools
RUN apt-get update && \
    apt-get install -y git openjdk-17-jdk && \
    apt-get clean

# Set environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

# Set the default shell to bash
SHELL ["/bin/bash", "-c"]