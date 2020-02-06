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
                    sh "docker build -t ebs-backend-test ."
                    }
            }
        stage('--Deploy--') {
              steps {
                    sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PSSWRD}"
                    sh "docker tag ebs-backend-test tigs1995/ebs-backend-test"
                    sh "docker push tigs1995/ebs-backend-test"
                    }
              }
    }
}
