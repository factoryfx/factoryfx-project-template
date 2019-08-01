package io.github.factoryfx.project.template;

import io.github.factoryfx.factory.FactoryBase;
import io.github.factoryfx.factory.util.ClasspathBasedFactoryProvider;
import io.github.factoryfx.factory.validator.FactoryStyleValidation;
import io.github.factoryfx.factory.validator.FactoryStyleValidatorBuilder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.status.StatusLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class FactoryValidatorTest {
    static {
        StatusLogger.getLogger().setLevel(Level.OFF);
    }

    @TestFactory
    List<DynamicTest> factoryValidatingTests() {
        List<DynamicTest> result = new ArrayList<>();
        final FactoryStyleValidatorBuilder factoryStyleValidatorBuilder = new FactoryStyleValidatorBuilder();
        for (Class<? extends FactoryBase<?,?>> clazz: new ClasspathBasedFactoryProvider().get(ServerRootFactory.class)){
            if (!Modifier.isAbstract( clazz.getModifiers() )){
                final List<FactoryStyleValidation> factoryValidations = factoryStyleValidatorBuilder.createFactoryValidations(clazz);
                for (FactoryStyleValidation factoryStyleValidation: factoryValidations){

                    result.add(DynamicTest.dynamicTest(clazz.getName()+":"+factoryStyleValidation.getClass().getSimpleName(),
                            () -> Assertions.assertEquals("",factoryStyleValidation.validateFactory().orElse(""))));
                }
            }
        }
        return result;
    }

}
