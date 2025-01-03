pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'noahwoods/gestionale-repo' // Nome immagine Docker
        DOCKER_TAG = 'latest' // Tag dell'immagine Docker
        JAVA_CONTAINER_NAME = 'java-microservice'
    }

   triggers {
        githubPush()
    }
    stages {
        stage('Check Branch') {
            when {
                branch 'env/svil'
            }
            steps {
                echo 'Branch corretto: env/svil'
            }
        }

        stage('Clone Repository') {
            steps {
                git branch: 'env/svil', url: 'https://github.com/valerioc97/ProgettoGestionale.git'
            }
        }

        stage('Make mvnw Executable') {
            steps {
                bat 'icacls mvnw /grant Everyone:F'
            }
        }

        stage('Build Project') {
            steps {
                bat './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'docker-credentials', url: 'https://index.docker.io/v1/']) {
                    bat "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }

        stage('Cleanin up') {
            steps {
                echo 'Clean containers...'
                bat "docker rm -f ${JAVA_CONTAINER_NAME}"
            }
        }

        stage('Pull Docker Image') {
            steps {
                echo 'Pulling Docker image for Java microservice...'
                bat "docker pull ${DOCKER_IMAGE}:${DOCKER_TAG}"
            }
        }

        stage('Run Microservice') {
            steps {
                echo 'Running the microservice container...'
                bat "docker run --network lavanderia-network -d --name ${JAVA_CONTAINER_NAME} -p 9090:8080 ${DOCKER_IMAGE}:${DOCKER_TAG}"
            }
        }

    }

    post {
        success {
            echo 'Pipeline completata con successo!'
        }
        failure {
            echo 'La pipeline ha fallito.'
        }
    }
}
