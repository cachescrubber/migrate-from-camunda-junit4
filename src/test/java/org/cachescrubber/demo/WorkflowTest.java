package org.cachescrubber.demo;

import static org.operaton.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;

import org.junit.jupiter.api.Test;
import org.operaton.bpm.engine.RuntimeService;
import org.operaton.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkflowTest {

  @Autowired
  public RuntimeService runtimeService;

  @Test
  void shouldExecuteHappyPath() {
    // given
    String processDefinitionKey = "migrate-from-camunda-junit4-process";

    // when
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);

    // then
    assertThat(processInstance).isStarted()
        .task()
        .hasDefinitionKey("say-hello")
        .hasCandidateUser("admin")
        .isNotAssigned();
  }

}
