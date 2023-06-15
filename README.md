# mychess

## About

mychess is a chess application that allows players to play the game of chess online. It provides a user-friendly
interface for players to interact with the chessboard and make their moves. The application includes various features to
ensure a fair and enjoyable gaming experience, including move validation, check detection, checkmate detection,
stalemate detection, turn-based gameplay, and the ability to save and resume games.

## Features

* Display of the chessboard with all pieces in their starting positions.
* Selection of a piece to view its valid moves.
* Validation of moves to prevent illegal moves.
* Notification of check status to take appropriate action.
* Detection of checkmate to declare the game over and determine a winner.
* Detection of stalemate to declare the game as a draw.
* Turn-based gameplay to allow players to take turns making moves.
* Tracking of game state to view the progress and outcome of the game.
* Optional saving and loading of game states to resume games later.

## Architecture overview

#### Project structure

```
├── docker-compose.yml
├── Dockerfile
├── HELP.md
├── LICENSE
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── thiagoferraz
    │   │           └── mychess
    │   │               ├── authentication
    │   │               │   ├── ApplicationConfiguration.java
    │   │               │   ├── AuthenticationController.java
    │   │               │   ├── AuthenticationResponse.java
    │   │               │   ├── AuthenticationService.java
    │   │               │   ├── JwtAuthenticationFilter.java
    │   │               │   ├── JwtService.java
    │   │               │   ├── RegisterRequest.java
    │   │               │   ├── Role.java
    │   │               │   └── SecurityConfiguration.java
    │   │               ├── chessboard
    │   │               │   ├── ChessboardController.java
    │   │               │   ├── Chessboard.java
    │   │               │   ├── ChessboardRepository.java
    │   │               │   └── ChessboardService.java
    │   │               ├── exceptions
    │   │               │   ├── ExceptionHandlerController.java
    │   │               │   ├── FieldMessage.java
    │   │               │   ├── MoveNotAllowedException.java
    │   │               │   ├── StandardError.java
    │   │               │   └── ValidationError.java
    │   │               ├── game
    │   │               │   ├── GameController.java
    │   │               │   ├── Game.java
    │   │               │   ├── GameRepository.java
    │   │               │   ├── GameService.java
    │   │               │   └── GameStatus.java
    │   │               ├── move
    │   │               │   ├── MoveController.java
    │   │               │   ├── Move.java
    │   │               │   ├── MoveRepository.java
    │   │               │   └── MoveService.java
    │   │               ├── MychessApplication.java
    │   │               ├── piece
    │   │               │   ├── PieceColour.java
    │   │               │   ├── PieceController.java
    │   │               │   ├── Piece.java
    │   │               │   ├── PieceRepository.java
    │   │               │   ├── PieceService.java
    │   │               │   ├── PieceType.java
    │   │               │   └── Position.java
    │   │               └── player
    │   │                   ├── Player.java
    │   │                   └── PlayerRepository.java
    │   └── resources
    │       ├── application.properties
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── thiagoferraz
                    └── mychess
                        └── game
                            ├── GameControllerTest.java
                            └── GameServiceTest.java
```

#### Class diagram

![mychess](https://github.com/thiagoferrax/mychess/assets/43149895/bbb2795e-b2cd-4515-a639-b05f05f067ae)

#### Tech stack

* [Spring Boot](http://spring.io/projects/spring-boot) for creating the RESTful Web Services
* [MockMVC](https://spring.io/guides/gs/testing-web/) for testing the Web Layer
* [Mockito](https://site.mockito.org/) for testing the Services Layer
* [MySQL](https://www.mysql.com/) as database
* [Maven](https://maven.apache.org/) for managing the project's build
* [Docker](https://www.docker.com/) for building and managing the application distribution using containers
* [React](https://react.dev/) for building the frontend application, also using SVG (Scalable Vector Graphics)

## Install

#### Download the repository

```sh
$ git clone https://github.com/thiagoferrax/mychess.git
```

#### With docker and docker-compose installed

```sh
$ cd mychess && docker-compose up
```
## Swagger UI Documentation

To access the Swagger UI documentation for this project, please follow the steps below:

1. Make sure that the project is running locally on your machine.
2. Open your web browser and navigate to [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
3. This interactive interface provides a comprehensive overview of the API endpoints, request/response schemas, and allows you to interact with the API directly.
4. It's a helpful tool for testing and exploring the functionality of the project.

## License

MIT © [thiagoferrax](https://github.com/thiagoferrax).
