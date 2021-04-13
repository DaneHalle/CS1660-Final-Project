FROM ubuntu
WORKDIR /root

RUN apt-get update && \
    apt-get upgrade -y

RUN DEBIAN_FRONTEND=noninteractive \
    apt install -y firefox \
                   xterm

RUN DEBIAN_FRONTEND=noninteractive \
    apt install -y software-properties-common \
                   apt-transport-https \
                   wget

RUN wget -q https://packages.microsoft.com/keys/microsoft.asc -O- | apt-key add -
	
RUN add-apt-repository "deb [arch=amd64] https://packages.microsoft.com/repos/vscode stable main"

RUN apt-get update && \
    apt-get upgrade -y

RUN apt install -y code

COPY . .

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopVSCode ]] ; do\n	while [[ ! -e ./vscode && ! -e ./stopVSCode ]] ; do\n		sleep 1\n	done\n\n  if [[ ! -e ./stopVSCode ]]\n then\n    rm vscode && xterm -e /bin/bash -l -c \"export  DONT_PROMPT_WSL_INSTALL=1; code --user-data-dir\"\nfi\ndone\nrm stopVSCode" >> /tmp/run.sh

CMD bash /tmp/run.sh
