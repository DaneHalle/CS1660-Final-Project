FROM ubuntu
WORKDIR /code


RUN apt-get update && \
    apt-get upgrade -y 

RUN apt install -y firefox

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y python3 \
    				   python3-pip \
    				   xterm 

RUN pip3 install --upgrade tensorflow

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopTensorflow ]] ; do\n	while [[ ! -e ./tensorflow && ! -e ./stopTensorflow ]] ; do\n		sleep 1\n	done\n\n  if [[ ! -e ./stopTensorflow ]]\n then\n    rm tensorflow && xterm -e /bin/bash -l -c \"python3\"\nfi\ndone\nrm stopTensorflow" >> /tmp/run.sh

CMD bash /tmp/run.sh
