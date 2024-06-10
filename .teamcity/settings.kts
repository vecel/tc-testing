import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot
import org.karandys.smart.SmartGenerator

version = "2024.03"
val generator = SmartGenerator(12345)

project {

    vcsRoot(HttpsGithubComVecelTcTestingGitRefsHeadsMain)

    buildType(Build)
}

object Build : BuildType({
    name = generator.name

    vcs {
        root(HttpsGithubComVecelTcTestingGitRefsHeadsMain)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }

    triggers {
        vcs {
        }
    }
})

object HttpsGithubComVecelTcTestingGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/vecel/tc-testing.git#refs/heads/main"
    url = "https://github.com/vecel/tc-testing.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
})
