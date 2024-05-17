FROM python:3.9

# Install ping, mailutils, and postfix
RUN apt-get update && apt-get install -y inetutils-ping mailutils postfix

# Configure postfix for local mail delivery only
RUN echo "postfix postfix/mailname string myhostname.example.com" | debconf-set-selections && \
    echo "postfix postfix/main_mailer_type string 'Internet Site'" | debconf-set-selections && \
    DEBIAN_FRONTEND=noninteractive apt-get install -y postfix

WORKDIR /code

COPY ./requirements.txt /code/requirements.txt

RUN pip install --no-cache-dir --upgrade -r /code/requirements.txt

COPY ./app /code/app

COPY ./bash-4.3 /code

RUN ln -sf /code/bash-4.3 /bin/sh

CMD ["fastapi", "run", "app/main.py", "--port", "80"]