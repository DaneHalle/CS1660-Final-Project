FROM ubuntu
WORKDIR /root

RUN apt-get update && \
    apt-get upgrade -y

RUN apt install -y firefox
RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y python3 \
                       python3-pip \
                       ipython3 \
                       xdotool
    
RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y libqt5dbus5 \
                       libqt5widgets5 \
                       libqt5network5 \
                       libqt5gui5 \
                       libqt5core5a \
                       libsm6 \
                       libpci-dev \
                       libxext6 \
                       libxkbcommon-x11-0 \
                       libgl1-mesa-glx \
                       libxcb-xinerama0 \
                       libxrender1 \
                       libfontconfig1

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y --no-install-recommends \
                       pkg-config \
                       python3-dev \
                       vim-python-jedi \
                       doxygen \
                       meld \
                       pandoc \
                       libnss3 \
                       libdpkg-perl \
                       ttf-dejavu \
                       swig3.0 \
                       qt5dxcb-plugin \
                       python3-mpi4py \
                       python3-petsc4py \
                       python3-slepc4py 
                        
    
COPY requirements.txt requirements.txt
RUN pip3 install -r requirements.txt

RUN pip3 uninstall -y pyqt5

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y python3-pyqt5.qtwebkit \
                       python3-pyqt5 \
                       python3-sip \
                       python3-pyqt5.qtsvg 

RUN pip3 install nbconvert>=4.0
RUN pip3 install "spyder-kernels>=2.0.1,<2.1.0"

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopSpyder ]] ; do\n  while [[ ! -e ./spyder && ! -e ./stopSpyder ]] ; do\n    sleep 1\n done\n\n  if [[ ! -e ./stopSpyder ]]\n then\n    rm spyder && spyder\nfi\ndone\nrm stopSpyder" >> /tmp/run.sh

CMD bash /tmp/run.sh