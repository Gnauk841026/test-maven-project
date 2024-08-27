pipeline {
    tools {
        maven 'Local Maven'
        jdk 'Local JDK'
    }
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean package'
                    } else {
                        bat 'mvn clean package'
                    }
                }
            }
            post {
                success {
                    echo '開始存檔...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage('Deploy to staging') {
            steps{
                build job: 'deploy-to-staging'

            }
        }
    }
}
