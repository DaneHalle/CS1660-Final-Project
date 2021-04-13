FROM ubuntu
WORKDIR /code

RUN apt-get update && \
    apt-get upgrade -y

RUN apt install -y firefox
RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y python3 \
                       python3-pip \
                       openjdk-8-jdk \
                       openssh-server openssh-client 
RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y xdotool \
                       xterm \
                       wget \
                       nano

RUN adduser hdoop
RUN su - hdoop

RUN mkdir /home/hdoop/.ssh
RUN ssh-keygen -t rsa -P '' -f /home/hdoop/.ssh/id_rsa

RUN cat /home/hdoop/.ssh/id_rsa.pub >> /home/hdoop/.ssh/authorized_keys && \
    chmod 0600 /home/hdoop/.ssh/authorized_keys

RUN wget https://downloads.apache.org/hadoop/common/hadoop-3.2.1/hadoop-3.2.1.tar.gz && \
    tar xzf hadoop-3.2.1.tar.gz

RUN echo "#Hadoop Related Options\nexport HADOOP_HOME=/code/hadoop-3.2.1\nexport HADOOP_INSTALL=$HADOOP_HOME\nexport HADOOP_MAPRED_HOME=$HADOOP_HOME\nexport HADOOP_COMMON_HOME=$HADOOP_HOME\nexport HADOOP_HDFS_HOME=$HADOOP_HOME\nexport YARN_HOME=$HADOOP_HOME\nexport HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native\nexport PATH=$PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin\nexport HADOOP_OPTS\"-Djava.library.path=$HADOOP_HOME/lib/native\"\n" >> /home/hdoop/.bashrc

RUN echo "export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64" >> /code/hadoop-3.2.1/etc/hadoop/hadoop-env.sh

RUN echo "<configuration>\n<property>\n  <name>hadoop.tmp.dir</name>\n  <value>/home/hdoop/tmpdata</value>\n</property>\n<property>\n  <name>fs.default.name</name>\n  <value>hdfs://127.0.0.1:9000</value>\n</property>\n</configuration>\n" >> /code/hadoop-3.2.1/etc/hadoop/core-site.xml

RUN mkdir dfsdata && \
    mkdir dfsdata/namenode && \
    mkdir dfsdata/datanode

RUN echo "<configuration>\n<property>\n  <name>dfs.data.dir</name>\n  <value>/code/dfsdata/namenode</value>\n</property>\n<property>\n  <name>dfs.data.dir</name>\n  <value>/code/dfsdata/datanode</value>\n</property>\n<property>\n  <name>dfs.replication</name>\n  <value>1</value>\n</property>\n</configuration>\n" >> /code/hadoop-3.2.1/etc/hadoop/hdfs-site.xml

RUN echo "<configuration> \n<property> \n  <name>mapreduce.framework.name</name> \n  <value>yarn</value> \n</property> \n</configuration>\n" >> /code/hadoop-3.2.1/etc/hadoop/mapred-site.xml

RUN echo "<configuration>\n<property>\n  <name>yarn.nodemanager.aux-services</name>\n  <value>mapreduce_shuffle</value>\n</property>\n<property>\n  <name>yarn.nodemanager.aux-services.mapreduce.shuffle.class</name>\n  <value>org.apache.hadoop.mapred.ShuffleHandler</value>\n</property>\n<property>\n  <name>yarn.resourcemanager.hostname</name>\n  <value>127.0.0.1</value>\n</property>\n<property>\n  <name>yarn.acl.enable</name>\n  <value>0</value>\n</property>\n<property>\n  <name>yarn.nodemanager.env-whitelist</name>   \n  <value>JAVA_HOME,HADOOP_COMMON_HOME,HADOOP_HDFS_HOME,HADOOP_CONF_DIR,CLASSPATH_PERPEND_DISTCACHE,HADOOP_YARN_HOME,HADOOP_MAPRED_HOME</value>\n</property>\n</configuration>\n" >> /code/hadoop-3.2.1/etc/hadoop/yarn-site.xml

# RUN hdfs namenode -format

# RUN sh /code/hadoop-3.2.1/sbin/start-yarn.sh
# RUN sh /code/hadoop-3.2.1/sbin/start-yarn.sh

COPY . .

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopHadoop ]] ; do\n  while [[ ! -e ./hadoop && ! -e ./stopHadoop ]] ; do\n   sleep 1\n done\n\n  if [[ ! -e ./stopHadoop ]]\n then\n    rm hadoop && xterm\n fi\ndone\nrm stopHadoop" >> /tmp/run.sh

CMD bash /tmp/run.sh
#CMD xterm # -e /bin/bash -l -c \"su hdoop; cd; source .bashrc;\"