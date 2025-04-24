//import jetbrains.buildServer.configs.kotlin.*
//import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
//import jetbrains.buildServer.configs.kotlin.buildSteps.qodana
//import jetbrains.buildServer.configs.kotlin.triggers.vcs
//import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot
//
///*
//The settings script is an entry point for defining a TeamCity
//project hierarchy. The script should contain a single call to the
//project() function with a Project instance or an init function as
//an argument.
//
//VcsRoots, BuildTypes, Templates, and subprojects can be
//registered inside the project using the vcsRoot(), buildType(),
//template(), and subProject() methods respectively.
//
//To debug settings scripts in command-line, run the
//
//    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate
//
//command and attach your debugger to the port 8000.
//
//To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
//-> Tool Windows -> Maven Projects), find the generate task node
//(Plugins -> teamcity-configs -> teamcity-configs:generate), the
//'Debug' option is available in the context menu for the task.
//*/
//
//version = "2023.05"
//
//project {
//
//    vcsRoot(TestVcsRoot)
//
//    buildType(Build)
//}
//
//object Build : BuildType({
//    name = "Build"
//
//    vcs {
//        root(TestVcsRoot)
//    }
//
//    steps {
//        qodana {
//            name = "Qodana Step"
//            reportAsTests = true
//            linter = jvmCommunity {
//            }
//            cloudToken = "credentialsJSON:a24fbb87-a029-4176-8e41-56d05f2d4748"
//        }
//    }
//
//    triggers {
//        vcs {
//        }
//    }
//
//    features {
//        perfmon {
//        }
//    }
//})
//
//object TestVcsRoot : GitVcsRoot({
//    name = "https://github.com/evgenyim/test-qodana.git#refs/heads/main"
//    url = "https://github.com/evgenyim/test-qodana.git"
//    branch = "refs/heads/main"
//    branchSpec = """
//        refs/heads/test
//        refs/heads/another
//    """.trimIndent()
//})
