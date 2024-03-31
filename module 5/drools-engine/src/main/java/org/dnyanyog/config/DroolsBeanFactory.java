package org.dnyanyog.config;

import java.util.Arrays;
import java.util.List;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class DroolsBeanFactory {

  private KieServices kieServices = KieServices.Factory.get();

  public KieSession getKieSession() {

    KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());

    kb.buildAll(); // Build all rules, meaning compile and make executable available

    // Release if needed for kie service to pull modules/rule engine for specific versions
    ReleaseId krDefaultReleaseId = kieServices.getRepository().getDefaultReleaseId();

    // Create container/runtime for rule execution. This will act as kie session factory
    KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);

    return kieContainer.newKieSession();
  }

  private KieFileSystem getKieFileSystem() {

    // KIE - Knowleg is everything
    // kieFileSystem - Represents a virtual file system where Drools resources, such as rule files
    // (DRL files), are stored.

    KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
    List<String> rules = Arrays.asList("org/dnyanyog/rules/discountRules.drl");

    for (String rule : rules) {
      kieFileSystem.write(ResourceFactory.newClassPathResource(rule));
    }
    return kieFileSystem;
  }
}
