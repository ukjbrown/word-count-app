# Word Counter

## Purpose
This application will produce an occurrence count for each word in a given input text file.

## Known limitations
* Words separated only by punctuation will be joined as a single word (e.g. **hello/world** becomes **helloworld**)
* Apostrophes/single quotes are removed resulting in plurals and possessives being treated as the same word (e.g. **dog's** and **dogs**)

## How to build

### Pre-requisites
* Java 17
* Maven 3.8.x

### Build
* Run ```mvn package``` from within the root directory of the project.

## How to run
Run ```java -jar target/word-count-app-1.0-SNAPSHOT.jar <path_to_input_file>```