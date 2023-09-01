job("Qodana") {
  startOn {
    gitPush {
      anyBranchMatching {
        + "main"
        + "refs/heads/test"
      }
    }
    codeReviewOpened{}
  }
  container("jetbrains/qodana-jvm") {
    env["QODANA_TOKEN"] = "{{ project:qodana-token }}"
    shellScript {
      content = "qodana"
    }
  }
}