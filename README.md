# ToDoApp
Dockerized Springboot Todo app designed for kids. This application is designed to be simple and easy to use. As the application evolves, parents will have access to their kids Todo lists through Mutual account linking. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development purposes. 

### Prerequisities
1. Clone the project to your local environment
```
git clone https://github.com/lakshmibaskaran/ToDoApp.git
```
2. You need maven installed on your environment
  #### Mac (homebrew):
  ```
  brew install maven
  ```
  #### Ubuntu:
  ```
  sudo apt-get install maven
  ```
3. You need docker to be installed:
  #### Windows:
  https://download.docker.com/win/stable/Docker%20for%20Windows%20Installer.exe
  #### Mac:
  https://download.docker.com/mac/stable/Docker.dmg
  #### Ubuntu:
  https://docs.docker.com/install/linux/docker-ce/ubuntu/

4. Installing
  ONce you have maven and docker installed on your environment, install the project dependencies via:
  ```
  mvn install
  ```
5. Build docker image:
  ```
  docker-compose build
  ```
### Running
6. Start docker:
  ```
  docker-compose up
  ```
  Or run the application from the main method directly or from a command line:
  ```
  mvn spring-boot:run
  ```
  Your server should now be running on http://localhost:8080/Login
