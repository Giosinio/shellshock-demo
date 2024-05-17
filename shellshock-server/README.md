# Deploy Fast-API Shellshock-vulnerable service using Docker

## Pre-requisites
1. You should have Docker installed on your machine. You can check by running the following command, which displays the
version of Docker you have: ```docker --version```
2. Also, you need a Linux sub-system, I'm using Ubuntu 20.04.

## Setup
1. Open a terminal in the root of this project.
2. Run the following command which will create the docker image called `django_shellshock`:
```bash
   docker build -t django-shellshock-image .
```
3. Now that we have the image, run the following command to start the container that contains the vulnerable server:
```bash
   docker run -p 80:80  --name django-shellshock django-shellshock-image
```
4. If everything worked correctly, by accessing `http://localhost:80`, you should see the following response:
```json
{"message":"Hello World"}
```