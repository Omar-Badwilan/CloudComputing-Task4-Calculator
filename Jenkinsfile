pipeline {
    agent any
    tools {
        maven 'Maven3'
    }

    stages {

        stage('Clone Repository') {
            steps {
                checkout scm
                echo 'Repository cloned successfully.'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean compile'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo 'Running unit tests...'
                bat 'mvn test'
            }
        }

    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo 'Pipeline completed successfully! All tests passed.'
        }
        failure {
            echo 'Pipeline failed. Check the console output for details.'
        }
    }
}
