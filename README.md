# Adventurer Journey - Back End
Please complete the story below and create a program to solve the problem. Commit any work back to the remote no later than 48 hours before the next interview.

*Please use whatever languages, references and tooling you would like to complete the story.*

## Story Instructions
You are an adventurer standing in the center of a map facing North, and you’re trying to weave through the terrain to your final destination. You have the directions to your destination indicating the number of steps and the direction to travel.

Adventurer Path & Instructions - [./Adventurer Path.md](./Adventurer%20Path.md)

Given the Path Instructions above, programmatically parse the instructions and determine what is the Euclidean (straight line) distance from your starting point to the destination in steps?

**Tech Notes:**
- Use whatever languages, references and tooling you would like.
- Provide any needed instructions to run program.
- Do not round to the nearest step.
- After program executes the answer should be returned.

## Developer Notes

Prerequisite: Have Java 8+ installed on the System

### Instructions to Run Program using the JAR file
1. Clone the repository
2. Navigate to the root directory
3. Run the following command: `java -jar adventurer.jar`

### Instructions to Build and Run Program using the source code
1. Clone the repository
2. Navigate to the directory adventurer
3. Run the following command: `javac -d bin src/main/Main.java src/main/PathHelper.java`
4. Navigate to the directory adventurer/bin
5. Run the following command: `java Main`

### Tests
1. Tests are located in the directory `adventurer/src/test`

### Assumptions
1. The adventurer starts at the origin (0, 0) facing North.
2. The adventurer turns to face the direction in which they will be moving.
3. The distance can be an integer or a decimal number.
4. If an invalid direction or no distance is provided, it is skipped, assuming a distance of 0.
5. The directions are capital letters.



