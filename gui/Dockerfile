FROM ubuntu
WORKDIR /code

RUN apt-get update && \
    apt-get upgrade -y

RUN apt install -y firefox

RUN apt-get install -y python3 \
                       python3-pip \
                       python3-tk 

RUN apt-get install -y libsm6 \
                       libpci-dev \
                       libxext6 \
                       libxkbcommon-x11-0 \
                       libxcb-xinerama0 

# COPY requirements.txt requirements.txt
# RUN pip3 install -r requirements.txt

COPY app.py /tmp/app.py

CMD python3 /tmp/app.py