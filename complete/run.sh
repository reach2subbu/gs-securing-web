#!/bin/sh
cd ~/project/gs-securing-web/complete
nohup java -jar target/securing-web-complete-0.0.1-SNAPSHOT.jar 2>&1 1>logs.txt &