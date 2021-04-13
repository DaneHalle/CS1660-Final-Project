FROM ubuntu
WORKDIR /root

RUN apt-get update && \
    apt-get upgrade -y 

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y firefox

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y libpci-dev 

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopTableau ]] ; do\n	while [[ ! -e ./tableau && ! -e ./stopTableau ]] ; do\n		sleep 1\n	done\n\n  if [[ ! -e ./stopTableau ]]\n then\n    rm tableau && firefox https://sso.online.tableau.com/public/idp/SSO\nfi\ndone\nrm stopTableau" >> /tmp/run.sh

CMD bash /tmp/run.sh
