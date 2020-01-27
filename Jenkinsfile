pipeline {
    agent any
    stages {
        stage('---Clear---') {
            steps {
                //sh "docker stop event-booking-system"
                //sh "docker rm event-booking-system"
                //sh "docker rmi -f event-booking-system"
            }
        }
        stage('--Build back-end--') {
            steps {
                sh "docker build -t event-booking-system ."
                }
        }
        stage('--Containerize back-end--') {
          steps {
                sh "docker run --name event-booking-system --network app-network -d -p 1900:8082 event-booking-system"
                }
          }
    }
}
