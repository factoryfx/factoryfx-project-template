package io.github.factoryfx.project.template;

import io.github.factoryfx.factory.attribute.types.StringAttribute;

import java.lang.Override;

/**
 * Factory for the example resource
 */
public class ExampleResourceFactory extends ServerBaseFactory<ExampleResource> {
    public final StringAttribute text = new StringAttribute();
    @Override
    public ExampleResource createImpl() {
        return new ExampleResource(text.get());
    }
}
