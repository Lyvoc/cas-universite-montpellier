package org.apereo.cas.validation;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.Assert.*;

/**
 * @author Scott Battaglia
 * @since 3.0.0
 */
@Slf4j
public class Cas20WithoutProxyingValidationSpecificationTests {

    private Cas20WithoutProxyingValidationSpecification validationSpecification;

    @BeforeEach
    public void setUp() {
        this.validationSpecification = new Cas20WithoutProxyingValidationSpecification();
    }

    @Test
    public void verifySatisfiesSpecOfTrue() {
        assertTrue(this.validationSpecification.isSatisfiedBy(CoreValidationTestUtils.getAssertion(true), new MockHttpServletRequest()));
    }

    @Test
    public void verifyNotSatisfiesSpecOfTrue() {
        this.validationSpecification.setRenew(true);
        assertFalse(this.validationSpecification.isSatisfiedBy(CoreValidationTestUtils.getAssertion(false), new MockHttpServletRequest()));
    }

    @Test
    public void verifySatisfiesSpecOfFalse() {
        assertTrue(this.validationSpecification.isSatisfiedBy(CoreValidationTestUtils.getAssertion(false), new MockHttpServletRequest()));
    }

    @Test
    public void verifyDoesNotSatisfiesSpecOfFalse() {
        assertFalse(this.validationSpecification.isSatisfiedBy(
                CoreValidationTestUtils.getAssertion(false, new String[] {"test2"}), new MockHttpServletRequest()));
    }

    @Test
    public void verifySettingRenew() {
        final var validation = new Cas20WithoutProxyingValidationSpecification(
                true);
        assertTrue(validation.isRenew());
    }
}
