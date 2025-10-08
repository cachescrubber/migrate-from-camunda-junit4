package org.cachescrubber.demo;

import org.operaton.bpm.engine.RuntimeService;
import org.operaton.bpm.engine.runtime.ProcessInstance;
import org.operaton.bpm.spring.boot.starter.test.helper.AbstractProcessEngineRuleTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.operaton.bpm.engine.test.assertions.bpmn.BpmnAwareTests.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WorkflowTest extends AbstractProcessEngineRuleTest {

  @Autowired
  public RuntimeService runtimeService;

  @Test
  public void shouldExecuteHappyPath() {
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
