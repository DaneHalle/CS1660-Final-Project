# CS1660-Final-Project

## How to start running this

1. Run XLaunch as described in Docker Homework from earlier in the semester
2. Set your shell's DISPLAY variable to be your IP:0.0
	1. For Windows: `$env:"DISPLAY=<YOUR_IP>:0.0"`
	2. For Linux/MacOS: `export DISPLAY=<YOUR_IP>:0.0`
3. Run `docker-compose up --build` and wait (May take a **long** time...Around 30 minutes when I did a build with no cached layers)
	1. *Note: I ran into some issues where the build just fails for no good reason but have thrown that up to unstable network issues. If build fails, please retry once or twice.*

## Important Notes

Spyder: When opened, it gives an error saying that it is missing a dependency. Upon investigation, I found this is a bug in recent release of Spyder. See [here](https://stackoverflow.com/questions/66983909/you-have-missing-dependencies-mandatory-spyder-kernels-2-0-1-2-1-0-2-0)

## Features 

- Shared volume in local folder of name `./MicroServices` between all containers.
	- This means there is a shared directory representative to the `/root` directory on each container.
	- **Hadoop, Spyder, and Jupyter Notebook can read/write files from local host for extra-credit.**
- A custom solution docker image for each Micro Service container.
- A Python GUI that opens each Micro Service by placing an expected file into the shared system where the docker container has a script running looking for that file in order to execute and start the program/browser/terminal. The file is then removed upon start. 
	- An example of the script running on each container in the `runExample.sh` file.
- Upon closure of the Python GUI, expected stop files are placed into the shared system where the docker container's script is looking for in order to stop the script and remove the stop file. 

## Video 

[Code Walkthrough and Demo](https://pitt-my.sharepoint.com/:v:/g/personal/dmh148_pitt_edu/Efu2fplOHkhJu5qXP-RhIF8BCYrX5IMaeOat_ZM9ZjGP8w?e=oFsSkS)