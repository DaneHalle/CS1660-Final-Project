FROM ubuntu
WORKDIR /root

RUN apt-get update && \
    apt-get upgrade -y 

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y markdown \
    				   nano \
    				   xterm

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopMarkdown ]] ; do\n	while [[ ! -e ./markdown && ! -e ./stopMarkdown ]] ; do\n		sleep 1\n	done\n\n  if [[ ! -e ./stopMarkdown ]]\n then\n    rm markdown && xterm -e /bin/bash -l -c \"nano MarkdownDocker.md\"\nfi\ndone\nrm stopMarkdown" >> /tmp/run.sh

CMD bash /tmp/run.sh
