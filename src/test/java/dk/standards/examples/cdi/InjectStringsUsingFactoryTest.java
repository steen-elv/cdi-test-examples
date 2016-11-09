package dk.standards.examples.cdi;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static dk.standards.examples.cdi.Factory.THE_HEADER;
import static dk.standards.examples.cdi.Factory.THE_PARAMETER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Demonstrating how to inject properties of type String using factory methods.
 * @see Factory
 */
@SuppressWarnings("CdiInjectionPointsInspection")
@RunWith(CdiRunner.class)
@AdditionalClasses(Factory.class)
public class InjectStringsUsingFactoryTest {
    @Inject @Header
    private String aHeader;

    @Inject @Parameter
    private String aParameter;


    @Test
    public void shouldInjectHeader() throws Exception {
        assertThat(aHeader, is(THE_HEADER));
    }

    @Test
    public void shouldInjectParameter() throws Exception {
        assertThat(aParameter, is(THE_PARAMETER));
    }

}
