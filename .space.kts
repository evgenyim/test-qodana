job("Qodana") {
  startOn {
    gitPush {
      anyBranchMatching {
        +"main"
        +"test"
      }
    }
    codeReviewOpened{}
  }
  container("jetbrains/qodana-jvm") {
    env["QODANA_TOKEN"] = "{{ project:qodana-token }}"
    shellScript {
      content = "qodana --baseline qodana.sarif.json"
    }
  }
}