FROM ubuntu
WORKDIR /root

RUN apt-get update && \
    apt-get upgrade -y

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y firefox
    
RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y python3 \
                       python3-pip

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y default-jdk default-jre \
                       openssh-server openssh-client 
                       
RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y xdotool \
                       xterm \
                       wget \
                       nano

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y rsync

RUN wget https://downloads.apache.org/hadoop/common/hadoop-3.2.1/hadoop-3.2.1.tar.gz && \
    tar xzf hadoop-3.2.1.tar.gz

RUN mv hadoop-3.2.1 /usr/local/hadoop && \
    mkdir /usr/local/hadoop/logs

RUN echo "export HADOOP_HOME=/usr/local/hadoop \nexport HADOOP_INSTALL=/usr/local/hadoop \nexport HADOOP_MAPRED_HOME=/usr/local/hadoop \nexport HADOOP_COMMON_HOME=/usr/local/hadoop \nexport HADOOP_HDFS_HOME=/usr/local/hadoop \nexport YARN_HOME=/usr/local/hadoop \nexport HADOOP_COMMON_LIB_NATIVE_DIR=/usr/local/hadoop/lib/native \nexport PATH=$PATH:/usr/local/hadoop/sbin:/usr/local/hadoop/bin \nexport HADOOP_OPTS=\"-Djava.library.path=/usr/local/hadoop/lib/native\"\nexport HDFS_NAMENODE_USER=root\nexport HDFS_DATANODE_USER=root\nexport YARN_RESOURCEMANAGER_USER=root\nexport YARN_NODEMANAGER_USER=root\nexport HDFS_SECONDARYNAMENODE_USER=root\n" >> /root/.bashrc && \
    cp .bashrc /usr/local/hadoop

RUN echo "export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64 " >> /usr/local/hadoop/etc/hadoop/hadoop-env.sh

RUN echo "export HADOOP_CLASSPATH+=\" /usr/local/hadoop/lib/*.jar\"" >> /usr/local/hadoop/etc/hadoop/hadoop-env.sh

RUN wget https://jcenter.bintray.com/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0.jar -P /usr/local/hadoop/lib

COPY core-site.xml /usr/local/hadoop/etc/hadoop/core-site.xml

RUN mkdir -p /hadoop/hdfs/namenode && \
    mkdir -p /hadoop/hdfs/datanode

COPY hdfs-site.xml /usr/local/hadoop/etc/hadoop/hdfs-site.xml

COPY mapred-site.xml /usr/local/hadoop/etc/hadoop/mapred-site.xml

COPY yarn-site.xml /usr/local/hadoop/etc/hadoop/yarn-site.xml

RUN /usr/local/hadoop/bin/hdfs namenode -format

COPY . .

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopHadoop ]] ; do\n  while [[ ! -e ./hadoop && ! -e ./stopHadoop ]] ; do\n   sleep 1\n done\n\n  if [[ ! -e ./stopHadoop ]]\n then\n    rm hadoop && cp /usr/local/hadoop/.bashrc /root && xterm && rm /root/.bashrc\n fi\ndone\nrm stopHadoop" >> /tmp/run.sh

CMD bash /tmp/run.sh