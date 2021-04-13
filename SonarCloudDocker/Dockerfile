FROM ubuntu
WORKDIR /code

RUN apt-get update && \
    apt-get upgrade -y 

RUN apt install -y firefox

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y libpci-dev 

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopSonarCloud ]] ; do\n	while [[ ! -e ./sonarcloud && ! -e ./stopSonarCloud ]] ; do\n		sleep 1\n	done\n\n	if [[ ! -e ./stopSonarCloud ]]\n	then\n		rm sonarcloud && firefox https://sonarcloud.io/sessions/new\nfi\ndone\nrm stopSonarCloud" >> /tmp/run.sh

CMD bash /tmp/run.sh
