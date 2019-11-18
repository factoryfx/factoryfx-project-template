package io.github.factoryfx.project.template;

import io.github.factoryfx.factory.SimpleFactoryBase;
import io.github.factoryfx.jetty.builder.JettyServerRootFactory;

/**
 * Base factory for all factories in the project */
public abstract class ServerBaseFactory<L> extends SimpleFactoryBase<L, JettyServerRootFactory> {
}
