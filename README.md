# mychess

## About

As a player, I want to see the chessboard with all the pieces in their starting positions, so that I can begin playing
the game.

The backend should provide a representation of the chessboard with the initial setup of pieces.
As a player, I want to be able to select a piece and see the valid moves it can make, so that I can plan my next move.

The backend should determine the valid moves for a selected piece based on the rules of chess.
As a player, I want the backend to validate my moves and prevent me from making illegal moves, so that the game is fair
and follows the rules.

The backend should validate each move according to the rules of chess, considering factors like piece movement,
capturing opponent pieces, castling, and special moves like en passant.
As a player, I want to be notified if I'm in check, so that I can take appropriate action to protect my king.

The backend should detect when a player's king is under attack (in check) and inform the player accordingly.
As a player, I want the backend to detect when a checkmate occurs, so that the game can be declared as over and a winner
determined.

The backend should detect if a player's king is in checkmate, meaning there are no valid moves to prevent the king from
being captured, and declare the game as over.
As a player, I want the backend to detect when a stalemate occurs, so that the game can be declared as a draw.

The backend should detect if a stalemate situation arises, where a player has no valid moves but their king is not in
check, and declare the game as a draw.
As a player, I want the backend to handle turn-based gameplay, so that each player takes turns making moves.

The backend should manage the turns of the players, allowing them to make moves one at a time.
As a player, I want the backend to track the game state, so that I can view the progress of the game and determine its
outcome.

The backend should store and update the current state of the game, including the positions of all pieces on the board
and information about ongoing play, such as check, checkmate, stalemate, or draw.
As a player, I want to have the option to save the game and resume it later, so that I can continue playing from where I
left off.

The backend can optionally provide functionality to save and load game states, allowing players to save their progress
and resume the game at a later time.

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
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── thiagoferraz
│   │   │           └── mychess
│   │   │               ├── controllers
│   │   │               │   ├── BoardController.java
│   │   │               │   ├── GameController.java
│   │   │               │   └── PieceController.java
│   │   │               ├── model
│   │   │               │   ├── entities
│   │   │               │   │   ├── Board.java
│   │   │               │   │   ├── Game.java
│   │   │               │   │   ├── Move.java
│   │   │               │   │   ├── Piece.java
│   │   │               │   │   └── Player.java
│   │   │               │   ├── enums
│   │   │               │   │   ├── PieceColour.java
│   │   │               │   │   └── PieceType.java
│   │   │               │   ├── repositories
│   │   │               │   │   ├── BoardRepository.java
│   │   │               │   │   ├── GameRepository.java
│   │   │               │   │   └── PieceRepository.java
│   │   │               │   └── tos
│   │   │               │       └── Position.java
│   │   │               └── MychessApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── thiagoferraz
│                   └── mychess
│                       └── MychessApplicationTests.java
```

#### Class diagram

![mychess](https://github.com/thiagoferrax/mychess/assets/43149895/979b9c05-5f00-4ebc-a054-6172cdcb44fb)

#### Tech stack

* [Spring Boot](http://spring.io/projects/spring-boot) for creating the RESTful Web Services
* [MockMVC](https://spring.io/guides/gs/testing-web/) for testing the Web Layer
* [Mockito](https://site.mockito.org/) for testing the Services Layer
* [MySQL](https://www.mysql.com/) as database
* [Maven](https://maven.apache.org/) for managing the project's build
* [Docker](https://www.docker.com/) for building and managing the application distribution using containers

## Install

#### Download the repository

```sh
$ git clone https://github.com/thiagoferrax/mychess.git
```

#### With docker and docker-compose installed

```sh
$ cd mychess && docker-compose up
```

## License

MIT © [thiagoferrax](https://github.com/thiagoferrax).
