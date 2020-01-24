pipeline {
    agent any
    stages {
        stage('---Clear---') {
            steps {
                sh "docker stop event-mysql"
                sh "docker stop event-booking-system"
                sh "docker rm event-mysql"
                sh "docker rm event-booking-system"
                sh "docker rmi -f mysql"
                sh "docker rmi -f event-booking-system"
                sh "docker rmi -f mysql"
                sh "docker rmi -f event-booking-system"
                sh "docker system prune -f"
                sh "rm -rf EventBookingSystem"
        stage('---Clean---') {
            steps {
                sh "mvn clean"
            }
        }
        stage('--Test--') {
            steps {
                sh "mvn test"
            }
        }
        stage('--Package--') {
            steps {
                sh "mvn package"
            }
        }
        stage('--Build back-end--') {
            steps {
                sh "docker build -t event-booking-system ."
                }
        }
        stage('--Create network--') {
          steps {
                sh "docker network create app-network"
                }
        }
        stage('--Create SQL Database--') {
          steps {
                sh "docker container run --name event-mysql --network app-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=event-database -d mysql"
                }
        }
        stage('--Containerize back-end--') {
          steps {
                sh "docker run --name event-booking-system --network app-network -d -p 1900:8082 event-booking-system"
                }
          }
    }
}
