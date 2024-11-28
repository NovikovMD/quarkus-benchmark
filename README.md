# quarkus-benchmark project

## Running the benchmark

500 Threads are started without ramp. Total test time: 5 minutes

- select.jmx file calls GET /users.
- GET /users returns 10 users of a random page

```
rm -rf report-jaxrs /tmp/jmeter*log
jmeter -n -t select.jmx -p jmeter.properties -l /tmp/jmeter-<PROJECT_NAME>.log -e -o report-<PROJECT_NAME>
```
Open `report-<PROJECT_NAME>/index.html` file

Ready to go reports are in 'reports' folder.
System:
CPU: Ryzen 7 7700
RAM: 32 GB, 6000 MHz
SSD: M.2, 7400 MB/s read, 6800 MB/s write 
 
