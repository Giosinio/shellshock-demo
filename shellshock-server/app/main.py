from fastapi import FastAPI, Request
import os
import subprocess

app = FastAPI()


@app.get("/")
async def root():
    return {"message": "Hello World"}


@app.post("/user-agent")
async def save_user_agent(request: Request):
    user_agent = request.headers.get('User-Agent')
    os.environ['USER_AGENT'] = user_agent
    subprocess.run('echo "$(date): Request to %s" >> request.log' % request.url.path, shell=True)
    return {"message": "User-Agent saved"}

