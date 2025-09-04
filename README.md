# migrate-from-camunda-junit4

This branch is the result of

`lars@wintermute migrate-from-camunda-junit4 % mvn org.openrewrite.maven:rewrite-maven-plugin:6.17.0:run \
-Drewrite.recipeArtifactCoordinates=org.operaton:migrate-camunda-recipe:1.0.0-rc-1-SNAPSHOT \
-Drewrite.activeRecipes=org.operaton.rewrite.spring.MigrateSpringBootApplication
[INFO] Scanning for projects...
[INFO]
[INFO] ---------< org.cachescrubber.demo:migrate-from-camunda-junit4 >---------
[INFO] Building migrate-from-camunda-junit4 1.0.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] >>> rewrite:6.17.0:run (default-cli) > process-test-classes @ migrate-from-camunda-junit4 >>>
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ migrate-from-camunda-junit4 ---
[INFO] Copying 2 resources from src/main/resources to target/classes
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ migrate-from-camunda-junit4 ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 1 source file with javac [debug target 21] to target/classes
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ migrate-from-camunda-junit4 ---
[INFO] Copying 2 resources from src/test/resources to target/test-classes
[INFO]
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ migrate-from-camunda-junit4 ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 1 source file with javac [debug target 21] to target/test-classes
[INFO]
[INFO] <<< rewrite:6.17.0:run (default-cli) < process-test-classes @ migrate-from-camunda-junit4 <<<
[INFO]
[INFO]
[INFO] --- rewrite:6.17.0:run (default-cli) @ migrate-from-camunda-junit4 ---
[INFO] Using active recipe(s) [org.operaton.rewrite.spring.MigrateSpringBootApplication]
[INFO] Using active styles(s) []
[INFO] Validating active recipes...
[INFO] Project [migrate-from-camunda-junit4] Resolving Poms...
[INFO] Project [migrate-from-camunda-junit4] Parsing source files
[INFO] Running recipe(s)...
[WARNING] Changes have been made to pom.xml by:
[WARNING]     org.operaton.rewrite.ReplaceCamundaDependencies
[WARNING]         org.openrewrite.java.dependencies.ChangeDependency: {oldGroupId=org.camunda.bpm, oldArtifactId=camunda-engine-plugin-spin, newGroupId=org.operaton.bpm, newArtifactId=operaton-engine-plugin-spin, newVersion=1.0.0-beta-5}
[WARNING]         org.openrewrite.java.dependencies.ChangeDependency: {oldGroupId=org.camunda.bpm.springboot, oldArtifactId=camunda-bpm-spring-boot-starter-rest, newGroupId=org.operaton.bpm.springboot, newArtifactId=operaton-bpm-spring-boot-starter-rest, newVersion=1.0.0-beta-5}
[WARNING]         org.openrewrite.java.dependencies.ChangeDependency: {oldGroupId=org.camunda.bpm.springboot, oldArtifactId=camunda-bpm-spring-boot-starter-webapp, newGroupId=org.operaton.bpm.springboot, newArtifactId=operaton-bpm-spring-boot-starter-webapp, newVersion=1.0.0-beta-5}
[WARNING]         org.openrewrite.java.dependencies.ChangeDependency: {oldGroupId=org.camunda.bpm.springboot, oldArtifactId=camunda-bpm-spring-boot-starter-test, newGroupId=org.operaton.bpm.springboot, newArtifactId=operaton-bpm-spring-boot-starter-test, newVersion=1.0.0-beta-5}
[WARNING]         org.openrewrite.java.dependencies.ChangeDependency: {oldGroupId=org.camunda.spin, oldArtifactId=camunda-spin-dataformat-all, newGroupId=org.operaton.spin, newArtifactId=operaton-spin-dataformat-all, newVersion=1.0.0-beta-5}
[WARNING]         org.openrewrite.java.dependencies.ChangeDependency: {oldGroupId=org.camunda.bpm, oldArtifactId=camunda-bom, newGroupId=org.operaton.bpm, newArtifactId=operaton-bom, newVersion=1.0.0-beta-5, changeManagedDependency=true}
[WARNING] Changes have been made to src/main/resources/application.yaml by:
[WARNING]     org.openrewrite.java.spring.ChangeSpringPropertyKey: {oldPropertyKey=camunda.bpm, newPropertyKey=operaton.bpm}
[WARNING] Changes have been made to src/test/java/org/cachescrubber/demo/WorkflowTest.java by:
[WARNING]     org.operaton.rewrite.ChangePackage
[WARNING]         org.openrewrite.java.ChangePackage: {oldPackageName=org.camunda.bpm, newPackageName=org.operaton.bpm, recursive=true}
[WARNING] Changes have been made to src/test/resources/application.yaml by:
[WARNING]     org.openrewrite.java.spring.ChangeSpringPropertyKey: {oldPropertyKey=camunda.bpm, newPropertyKey=operaton.bpm}
[WARNING] Please review and commit the results.
[WARNING] Estimate time saved: 20m
`