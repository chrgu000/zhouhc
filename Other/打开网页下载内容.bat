@echo off
title automati
cd\
e:
cd JOB
set "Ymd=%date:~,4%-%date:~5,2%-%date:~8,2%"
md E:\JOB\depoly\%ymd%
wget http://120.77.2.93/distribute/nzyy/yard_service_nzyy-2016-12-13.war -p E:\JOB\depoly\%ymd% --http-user=distributor --http-passwd=aoka1234 ¨Cegd-file=yard_service.war
pause