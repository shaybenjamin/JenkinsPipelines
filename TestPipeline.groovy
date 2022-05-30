node("linux") {
    def customImage = ""
    stage("create dockerfile") {
        sh """
        tee Dockerfile <<-'EOF'
        FROM ubuntu:latest
        RUN touch file-01.txt
EOF
        """
    }
    stage("build docker") {
        customImage = docker.build("shay-test")
    }
    stage("verify dockers") {
        sh "docker images"
    }
}
