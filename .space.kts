job("Qodana") {
  startOn {
    gitPush {
      branchFilter {
        +"main"
        +"test"
      }
    }
    codeReviewOpened{}
  }
  container("jetbrains/qodana-jvm") {
    env["QODANA_TOKEN"] = Secrets("qodana-token")
    shellScript {
      content = "qodana --baseline qodana.sarif.json"
    }
  }
}