destroy:
	docker-compose down && docker rmi demo-build
.PHONY: destroy

build:
	docker build -t demo-build . && docker run --name demo-build --rm -v $(shell pwd):/build -v ~/.m2:/root/.m2 demo-build && docker-compose build
.PHONY: build

run:
	docker-compose up --detach
.PHONY: run
