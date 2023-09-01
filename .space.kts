job("Qodana") {
  startOn {
    gitPush {
      anyBranchMatching {
        + "refs/heads/main"
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