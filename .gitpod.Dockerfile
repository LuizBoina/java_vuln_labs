FROM gitpod/workspace-full:latest

USER gitpod

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    sdk install java 17.0.3-ms && \
    sdk default java 17.0.3-ms"

RUN bash -c "for folder in */; do [ "$folder" != "dependencies/" ] && (cd "$folder" && mvn install -s settings.xml -DskipTests); done"