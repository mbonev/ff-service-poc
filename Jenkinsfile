def myBuildVersion = new Date().format('yyyyMMddHHmmss') + '-b' + env.BUILD_NUMBER

node {
    try {

        stage('Prepare environment') {
            checkout scm
            sh './gradlew clean'
        }

        stage('Build the service') {
            sh './gradlew assemble'
        }

        stage('Run unit tests') {
            sh './gradlew test'
        }
        
        stage('Run integration tests') {
            sh './gradlew intTest'
        }

        echo 'build passed...'
    } catch (e) {
        echo 'build failed'
    }
}

