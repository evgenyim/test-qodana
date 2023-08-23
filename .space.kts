job("Qodana") {
  startOn {
    gitPush {
      branchFilter {
        +"refs/heads/main"
      }
    }
    codeReviewOpened{}
  }
  container("jetbrains/qodana-jvm") {
    env["QODANA_TOKEN"] = Secrets("qodana-token")
    shellScript {
      content = """
        qodana \
        --profile-name qodana.recommended
        """.trimIndent()
    }
  }
}