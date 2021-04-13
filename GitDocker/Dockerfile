FROM ubuntu
WORKDIR /root

RUN apt-get update && \
    apt-get upgrade -y 
    
RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y git \
    				   xterm

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopGit ]] ; do\n	while [[ ! -e ./git && ! -e ./stopGit ]] ; do\n		sleep 1\n	done\n\n	if [[ ! -e ./stopGit ]]\n	then\n		rm git && xterm\n	fi\ndone\nrm stopGit" >> /tmp/run.sh

CMD bash /tmp/run.sh