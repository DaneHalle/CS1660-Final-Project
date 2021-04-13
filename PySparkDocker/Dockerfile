FROM ubuntu
WORKDIR /root

RUN apt-get update && \
    apt-get upgrade -y

RUN DEBIAN_FRONTEND=noninteractive \
    apt install -y firefox \
				   openjdk-8-jdk 

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y python3 \
    				   python3-pip \
    				   xterm

COPY requirements.txt requirements.txt
RUN pip3 install -r requirements.txt

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopSpark ]] ; do\n    while [[ ! -e ./pyspark && ! -e ./stopSpark ]] ; do\n      sleep 1\n   done\n\n  if [[ ! -e ./stopSpark ]]\n then\n    rm pyspark && xterm -e /bin/bash -l -c \"pyspark\"\nfi\ndone\nrm stopSpark" >> /tmp/run.sh

CMD bash /tmp/run.sh
