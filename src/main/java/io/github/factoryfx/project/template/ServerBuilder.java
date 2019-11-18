package io.github.factoryfx.project.template;

import io.github.factoryfx.jetty.builder.JettyFactoryTreeBuilder;

/**
 * Utility class to construct the factory tree */
public class ServerBuilder {

    public static JettyFactoryTreeBuilder build() {
        JettyFactoryTreeBuilder builder= new JettyFactoryTreeBuilder((jetty, ctx)-> {
            jetty.withHost("localhost").withPort(8080).withResource(ctx.get(ExampleResourceFactory.class));
        });
        builder.addSingleton(ExampleResourceFactory.class,ctx->{
            ExampleResourceFactory resource = new ExampleResourceFactory();
            resource.text.set("Hello World");
            return resource;
        });
        // register more factories here
        return builder;
    }
}
