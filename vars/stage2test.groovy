def call(String imageName) {
    withCredentials ([usernamePassword(credentialsId: "dockerhub-cred", usernameVariable: "username", passwordVariable: "password")]) {


    sh "docker build -t $imageName ."
    sh "docker tag $imageName $imageName':$BUILD_NUMBER'"
    sh "docker push $imageName':$BUILD_NUMBER' "
    sh "docker rmi $imageName':$BUILD_NUMBER' "
    }
}

