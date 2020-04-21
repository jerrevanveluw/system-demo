docker build -t demo-build . && docker run -it --rm -v %cd%:/build -v ~/.m2:/root/.m2 demo-build bash
