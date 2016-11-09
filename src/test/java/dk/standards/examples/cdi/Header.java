package dk.standards.examples.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Steen on 09-11-2016.
 *
 */
@Retention(RUNTIME)
@Qualifier
public @interface Header {
}
