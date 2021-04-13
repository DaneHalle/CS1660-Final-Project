FROM ubuntu
WORKDIR /code

RUN apt-get update && \
    apt-get upgrade -y 

RUN apt install -y firefox

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y libpci-dev 

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopRStudio ]] ; do\n	while [[ ! -e ./rstudio && ! -e ./stopRStudio ]] ; do\n		sleep 1\n	done\n\n  if [[ ! -e ./stopRStudio ]]\n then\n    rm rstudio && firefox https://rstudio.cloud\nfi\ndone\nrm stopRStudio" >> /tmp/run.sh

CMD bash /tmp/run.sh