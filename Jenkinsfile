pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'lavanderia' // Nome immagine Docker
        DOCKER_TAG = 'latest'       // Tag dell'immagine Docker
        GIT_BRANCH = 'env/svil'     // Branch da clonare
        GIT_URL = 'https://github.com/valerioc97/ProgettoGestionale.git'
        DOCKER_REGISTRY = 'https://index.docker.io/v1/' // URL Docker Registry
        CREDENTIALS_ID = 'docker-credentials'          // ID credenziali Docker
    }

    stages {
        stage('Check Branch') {
            when {
                branch GIT_BRANCH
            }
            steps {
                echo "Branch corretto: ${GIT_BRANCH}"
            }
        }

        stage('Clone Repository') {
            steps {
                git branch: GIT_BRANCH, url: GIT_URL
            }
        }

        stage('Verify Dockerfile') {
            steps {
                script {
                    if (!fileExists('Dockerfile')) {
                        error 'Dockerfile non trovato. Interrompo la pipeline.'
                    }
                }
            }
        }

        stage('Make mvnw Executable') {
            steps {
                sh 'chmod +x mvnw'
                echo 'File mvnw reso eseguibile.'
            }
        }

        stage('Build Project') {
            steps {
                sh './mvnw clean package -DskipTests'
                echo 'Build del progetto completata con Maven.'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                echo "Immagine Docker ${DOCKER_IMAGE}:${DOCKER_TAG} costruita con successo."
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: CREDENTIALS_ID, url: DOCKER_REGISTRY]) {
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                    echo "Immagine Docker ${DOCKER_IMAGE}:${DOCKER_TAG} pushata su ${DOCKER_REGISTRY}."
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
        cleanup {
            echo 'Pulizia della workspace.'
            cleanWs() // Pulisce la workspace dopo l'esecuzione
        }
    }
}
