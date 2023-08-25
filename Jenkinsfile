pipeline {
    agent {
                    docker {
                        args '''
                            -v "${WORKSPACE}":/data/project
                            --entrypoint=""
                            '''
                        image 'jetbrains/qodana-jvm'
                    }
                }
    stages {
        stage('Qodana') {
            environment {
                QODANA_TOKEN = credentials('qodana-token')
            }

            when {
                branch 'main'
            }
            steps {
                sh '''qodana'''
            }
        }
    }
}