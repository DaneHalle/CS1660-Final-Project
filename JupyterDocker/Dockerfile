FROM ubuntu
WORKDIR /code

RUN apt-get update && \
    apt-get upgrade -y

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get install -y libpci-dev \
    				   firefox

RUN echo "#!/bin/bash\nwhile [[ ! -e ./stopJupyter ]] ; do\n	while [[ ! -e ./jupyter && ! -e ./stopJupyter ]] ; do\n		sleep 1\n	done\n\n  if [[ ! -e ./stopJupyter ]]\n then\n    rm jupyter && firefox https://mybinder.org/v2/gh/jupyterlab/jupyterlab-demo/master\nfi\ndone\nrm stopJupyter" >> /tmp/run.sh

CMD bash /tmp/run.sh