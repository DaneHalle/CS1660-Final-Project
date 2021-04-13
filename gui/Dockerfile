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
    apt-get install -y python3-tk \
                       libsm6 \
                       libpci-dev \
                       libxext6 \
                       libxkbcommon-x11-0 \
                       libxcb-xinerama0 

COPY app.py /tmp/app.py

CMD python3 /tmp/app.py