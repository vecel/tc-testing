import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

version = "2024.03"

project {

    vcsRoot(HttpsGithubComVecelTcTestingGitRefsHeadsMain)

    buildType(Build)
}

object Build : BuildType({
    name = "MyBuild"

    vcs {
        root(HttpsGithubComVecelTcTestingGitRefsHeadsMain)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = custom {
                path = "/opt/homebrew/Cellar/maven/3.9.6/libexec"
            }
            jdkHome = "%env.JDK_11%"
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
