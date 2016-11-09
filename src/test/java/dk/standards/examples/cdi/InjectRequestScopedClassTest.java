package dk.standards.examples.cdi;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.jglue.cdiunit.InRequestScope;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.List;

import static dk.standards.examples.cdi.Factory.HEADERS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * Demonstrate injection of a request scoped class
 *
 */
@SuppressWarnings("CdiInjectionPointsInspection")
@RunWith(CdiRunner.class)
@AdditionalClasses(Factory.class)
public class InjectRequestScopedClassTest {

    @Inject @Header
    private List<String> headersInRequest;

    @Test @InRequestScope
    public void shouldInjectRequestScopedClass() throws Exception {
//        Doesn't work because the injected headersInRequest is proxied and according to the CDI 1.1 specification:
//        The behavior of all methods declared by java.lang.Object, except for toString(), is undefined for a client proxy.
//        assertThat(headersInRequest, equalTo(HEADERS));
        assertThat(headersInRequest, contains(HEADERS.get(0), HEADERS.get(1)));
    }

}
