package dk.standards.examples.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Provides factory methods for various beans.
 *
 */
public class Factory {
    static final String THE_HEADER = "some header";
    static final String THE_PARAMETER = "some parameter";
    static final List<String> HEADERS =  new ArrayList<>(Arrays.asList("Header1", "Header2"));

    /**
     * Because the factory method creates a request scoped bean the bean will be proxied by the container
     * @see <a href="http://docs.jboss.org/cdi/spec/1.1/cdi-spec.html#client_proxies">CDI Client proxies</a>
     * @see <a href="http://docs.jboss.org/cdi/spec/1.1/cdi-spec.html#unproxyable">CDI Unproxiable</a>
     */
    @Produces
    @RequestScoped
    @Header
    public List<String> createRequestHeaders() {
        return HEADERS;
    }

//    Not allowed since RequestScoped is a "normal scope" and String is unproxiable because it's a declared final
//    @Produces @RequestScoped @Header
//    public String createRequestHeader() {
//        return "";
//    }

    @Produces @Header
    private String headerFactory() {
        return THE_HEADER;
    }


//    Can't coexist with the other headerFactory even though their method signatures are different
//    because both methods are elegible for injection into @Header String injection points.
//    @Produces @Header
//    private String headerFactory(String something) {
//        return THE_HEADER + " Something";
//    }

    @Produces @Parameter
    private String parameterFactory() {
        return THE_PARAMETER;
    }

}
