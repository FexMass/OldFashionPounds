# Challenge 

Write a library (package OldFashionPound) implementing the 4 arithmetic operations (sum, subtraction, multiplication and division) for pre-1970 UK prices.
Under the old money system of UK, before 1970, there were 12 pence in a shilling and 20 shillings, or 240 pence, in a pound. Thus,
a price in the OldUK Money system was expressed in Pounds, Shillings and Pence. For example "12p 6s 10d" is 12 Pounds, 6 Shillings and 10 Pence.  


## Project overview

Project contains simple mathematical implementation for basic calculation of pounds, shillings and pence. 
Its console application which accept format of entry as follows:

Xp Ys Zd + Xp Ys Zd
Xp Ys Zd - Xp Ys Zd
Xp Ys Zd * multipler
Xp Ys Zd / divider

Permitted operators: + - * /

Format must be followed, othervise error message will appear.

Overview of exmples and how it should work: 

Example SUM: 5p 17s 8d + 3p 4s 10d= 9p 2s 6d
Example SUBTRACTION: 5p 17s 8d - 3p 4s 10d= 2p 12s 10d

Subtractions giving negative results should be managed.

For multiplication and division no decimal is necessary
Example MULTIPLICATION: 5p 17s 8d * 2 = 11p 15 s 4d
Example DIVISION: 5p 17s 8d / 3 = 1p 19s 2d (2d) (2 pence as remainder - the remainder should be represented between parenthesis)
Another Example DIVISION: 18p 16s 1d / 15 = 1p 5s 0d   (1s 1d) (1 Shillings and 1 penny as remainder - the remainder should be represented between parenthesis)

The library should be able to receive and produce strings in the format "Xp Ys Zd", as in the examples

## Getting Started

Clone the project to your machine and put it in some directory of preference.
Executing CMD mvn package for building project dependencies
mvn clean package

this packaging is jar, so jar will be created where the project is situated under target folder. To run it navigate to target folder and type: java -jar OldFashionPound-1.0-SNAPSHOT-jar-with-dependencies.jar

### Prerequisites

- Java 1.8 and above (Oracle or OpenJDK)
- Maven 3.6.0 or above
- JUnit 5

## Running the tests

mvn test

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## IDE

* Intellij (Ultimate)

## Author

* **Massimo Gruicic** 
