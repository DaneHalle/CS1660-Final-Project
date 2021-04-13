# CS1660-Final-Project

## How to start running this

1. Run XLaunch as described in Docker Homework from earlier in the semester
2. Set your shell's DISPLAY variable to be your IP:0.0
	1. For Windows: `$env:DISPLAY=<YOUR_IP>:0.0`
	2. For Linux/MacOS: `export DISPLAY=<YOUR_IP>:0.0`
3. Run `docker-compose up --build` and wait (May take a **long** time)
	1. *Note: I ran into some issues where the build just fails for no good reason but have thrown that up to unstable network issues. If build fails, please retry once or twice.*


## Features 

- Shared volume in local folder of name `./MicroServices` between all containers.
	- This means there is a shared directory representative to the `/root` directory on each container.
	- **Hadoop, Spyder, and Jupyter Notebook can read/write files from local host for extra-credit.**
- A custom solution docker image for each Micro Service container.
- A Python GUI that opens each Micro Service by placing an expected file into the shared system where the docker container has a script running looking for that file in order to execute and start the program/browser/terminal. The file is then removed upon start. 
- Upon closure of the Python GUI, expected stop files are placed into the shared system where the docker container's script is looking for in order to stop the script and remove the stop file. 
