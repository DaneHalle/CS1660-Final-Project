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
    apt-get install -y libsm6 \
                       libpci-dev \
                       libxext6 \
                       libxkbcommon-x11-0 \
                       libgl1-mesa-glx \
                       xdotool
    
RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y libqt5dbus5 \
                       libqt5widgets5 \
                       libqt5network5 \
                       libqt5gui5 \
                       libqt5core5a \
                       libxcb-xinerama0

COPY requirements.txt requirements.txt
RUN pip3 install -r requirements.txt

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopOrange ]] ; do\n    while [[ ! -e ./orange && ! -e ./stopOrange ]] ; do\n      sleep 1\n   done\n\n  if [[ ! -e ./stopOrange ]]\n then\n    rm orange && orange-canvas\nfi\ndone\nrm stopOrange" >> /tmp/run.sh

CMD bash /tmp/run.sh