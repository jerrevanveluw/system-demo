# System-Demo

### Dependencies
* `.env` file in the root of this project (with some characters to act as password i.e. POSTGRES_PASSWORD=your_secret_here)
* docker
* docker compose
* (make)
* (maven)
* (jdk 11)
* (node 12)

### Start
```
make build
make run
```
or:
```
docker build -t demo-build .
docker run --name demo-build --rm -v $(pwd):/build -v ~/.m2:/root/.m2 demo-build
docker compose build
docker compose up --detach
```
or:
```
./build.sh
docker compose up --build --detach
```
Visit either:
 * http://localhost
 * http://localhost/todos
 * http://localhost/users
 * http://localhost:8081/api
 * http://localhost:8082/api

To view the demo

### Cleanup
```
make destroy
```
or:
```
docker compose down && docker rmi demo-build
```
