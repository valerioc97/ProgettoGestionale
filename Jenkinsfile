pipeline {
    agent any

    environment {
        DOCKER_REPO = 'estionale-repo'
        DOCKER_IMAGE = 'noahwoods/gestionale-repo' // Nome immagine Docker
        DOCKER_TAG = 'latest' // Tag dell'immagine Docker

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
                // Cambia il permesso di esecuzione su Windows
                bat 'icacls mvnw /grant Everyone:F' // Cambia i permessi per l'esecuzione del file mvnw su Windows
            }
        }

        stage('Build Project') {
            steps {
                bat './mvnw clean package -DskipTests' // Compila il progetto con Maven su Windows
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ." // Costruisce l'immagine Docker su Windows
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'docker-credentials', url: 'https://index.docker.io/v1/']) {
                    bat "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}" // Push dell'immagine Docker su Windows
                }
            }
        }

        stage('Pull Docker Images') {
                    steps {
                        script {
                            // Esegui il pull dell'immagine del microservizio Java
                            sh "docker pull $DOCKER_REPO/$DOCKER_IMAGE:$DOCKER_TAG"
                        }
                    }
                }

                       stage('Run Java Microservice Container') {
                           steps {
                               script {
                                   // Avvia il container del microservizio Java
                                   sh "docker run --name lavanderia-lavanderia -d -p 8080:8080 $DOCKER_REPO/$DOCKER_IMAGE:$DOCKER_TAG"
                               }
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
