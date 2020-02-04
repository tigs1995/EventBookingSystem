pipeline {
    agent any
    stages {
        stage('--Mvn clean package--') {
                steps {
                    sh "mvn clean package deploy"
                    }
            }
            stage('--Build back-end--') {
                steps {
                    sh "docker build -t event-booking-system ."
                    }
            }
        stage('--Deploy--') {
              steps {
                    sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PSSWRD}"
                    sh "docker tag event-booking-system tigs1995/event-booking-system"
                    sh "docker push tigs1995/event-booking-system"
                    }
              }
    }
}
