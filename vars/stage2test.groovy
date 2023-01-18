def call() {
    sh "/opt/apache-maven-3.6.3/bin/mvn clean package -DskipTests=true"
    echo " inside call func"
    withSonarQubeEnv("sonar") {
        sh "/opt/apache-maven-3.6.3/bin/mvn sonar:sonar"
        }

}
       