import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.qodana
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.10"

project {

    vcsRoot(TestVcsRoot)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    params {
        password("env.QODANA_TOKEN", "credentialsJSON:6b9ed493-6b74-42ee-abec-155a64c726e4")
    }

    vcs {
        root(TestVcsRoot)
    }

    steps {
        qodana {
            name = "Qodana Step"
            reportAsTests = true
            linter = jvmCommunity {
            }
            additionalDockerArguments = "-e QODANA_TOKEN=%env.QODANA_TOKEN%"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object TestVcsRoot : GitVcsRoot({
    name = "https://github.com/evgenyim/test-qodana.git#refs/heads/main"
    url = "https://github.com/evgenyim/test-qodana.git"
    branch = "refs/heads/main"
    branchSpec = """
        refs/heads/test
        refs/heads/another
    """.trimIndent()
})
