/* groovylint-disable-next-line CompileStatic */
pipeline {
    tools {
        maven 'Local Maven'
    }
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo '开始存档...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
    }
}
