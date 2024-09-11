/* groovylint-disable-next-line CompileStatic, NglParseError */
pipeline {
    agent any
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

        stage('Deploy to Production') {
            steps {
                timeout(time:5, unit:'DAYS') {
                    input message:'是否部署到生产环境?' , submitter:'admin'
                }

                build job: 'deploy-to-production'
            }
            post {
                success {
                    echo '代码成功部署到生产环境'
                }

                failure {
                    echo ' 部署失败'
                }
            }
        }

    }
}
