# UniversityEventManagmentApplication

## Framework and Language used
* Springboot
* Java

## Project Summary
* This is a SpringBoot-based project for managing Student and Events, with endpoints for adding, retrieving, updating, and deleting information.

## Student attributes
* studentId
* firstName
* lastName
* age
* department

## Event attributes
* eventId
* eventName
* locationOfEvent
* date
* startTime
* endTime

## controller
* StudentController
* EventController

## Service
* StudentService
* EventService

## Model
* Student
* Event

## Repository
* StudentRepository
* EventRepository
* Used CrudRepository and Custom Query method

## Data Structure used
* ArrayList

## Validation
* First character of first name should be capital.
* All characters of last name must be alphabets
* Age must be between 18 to 25.
