GRADLE=./gradlew

.PHONY: build

install:
	$(GRADLE) clean install
run-dist:
	./build/install/app/bin/app
check-updates:
	$(GRADLE) dependencyUpdates
lint:
	$(GRADLE) checkstyleMain
build:
	$(GRADLE) clean build