FROM openjdk:18-oraclelinux7

RUN yum install coreutils

WORKDIR /root

RUN \
  curl -fL https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-linux.gz | gzip -d > cs && \
  chmod +x cs && \
  yes | ./cs setup

ENV PATH $PATH:/root/.local/share/coursier/bin

RUN \
  yes | yum install wget &&\
  wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo &&\
  yes | yum install apache-maven

RUN echo 'alias ll="ls -al"' >> ~/.bashrc &&\
    yes | yum install less &&\
    yes | yum group install "Development Tools"


ENV PATH /root/.sdkman/candidates/kotlin/current/bin:$PATH

RUN \
  yes | yum install make
