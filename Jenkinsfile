pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'noahwoods/gestionale-repo' // Nome immagine Docker
        DOCKER_TAG = 'latest' // Tag dell'immagine Docker
        JAVA_CONTAINER_NAME = 'java-microservice'
    }

    stages {
        stage('Check Branch') {
            when {
                branch 'env/svil' // Esegui solo se il branch è env/svil
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
                // Cambia il permesso di esecuzione su Linux
                sh 'chmod +x mvnw' // Rendi il file mvnw eseguibile su Linux
            }
        }

        stage('Build Project') {
            steps {
                sh './mvnw clean package -DskipTests' // Compila il progetto con Maven su Linux
            }
        }

        stage('Build Docker Image') {
            steps {
                // Costruisce l'immagine Docker su Linux
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'docker-credentials', url: 'https://index.docker.io/v1/']) {
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}" // Push dell'immagine Docker su Linux
                }
            }
        }

        stage('Clean up') {
            steps {
                echo 'Clean containers...'
                // Rimuove il container esistente se presente
                sh "docker rm -f ${JAVA_CONTAINER_NAME} || true" // Il comando non fallisce se il container non esiste
            }
        }

        stage('Pull Docker Image') {
            steps {
                echo 'Pulling Docker image for Java microservice...'
                sh "docker pull ${DOCKER_IMAGE}:${DOCKER_TAG}" // Pull dell'immagine dal Docker Hub
            }
        }

        stage('Run Microservice') {
            steps {
                echo 'Running the microservice container...'
                sh "docker run --network lavanderia-network -d --name ${JAVA_CONTAINER_NAME} -p 9090:8080 ${DOCKER_IMAGE}:${DOCKER_TAG}" // Esegui il microservizio
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
