# System-Demo

### Dependencies
* ./.env (with some characters to act as password i.e. POSTGRES_PASSWORD=your_secret_here)
* docker
* docker-compose
* (make)

### Start
```
make build
make run
```
or:
```
docker build -t demo-build .
docker run --name demo-build --rm -v $(shell pwd):/build -v ~/.m2:/root/.m2 demo-build
docker-compose build
docker-compose up --detach
```
Visit either:
 * http://localhost/users
 * http://localhost/todos

To view the demo

### Cleanup
```
make destroy
```
or:
```
docker-compose down && docker rmi demo-build
```
