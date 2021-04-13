FROM ubuntu
WORKDIR /code

RUN apt-get update && \
    apt-get upgrade -y

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y libpci-dev \
    				   firefox

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopIBM ]] ; do\n	while [[ ! -e ./ibm && ! -e ./stopIBM ]] ; do\n		sleep 1\n	done\n\n  if [[ ! -e ./stopIBM ]]\n then\n    rm ibm && firefox https://welcome.oda.sas.com/login\nfi\ndone\nrm stopIBM" >> /tmp/run.sh

CMD bash /tmp/run.sh