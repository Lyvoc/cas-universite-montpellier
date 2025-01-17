package org.apereo.cas.authentication;

import org.apereo.cas.authentication.principal.Principal;
import org.apereo.cas.services.RegisteredService;

import java.util.Optional;

/**
 * This is {@link SurrogateAuthenticationPrincipalBuilder}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
public interface SurrogateAuthenticationPrincipalBuilder {

    /**
     * Default bean name.
     */
    String BEAN_NAME = "surrogatePrincipalBuilder";

    /**
     * Build surrogate principal principal.
     *
     * @param surrogate         the surrogate
     * @param primaryPrincipal  the primary principal
     * @param registeredService the registered service
     * @return the principal
     */
    Principal buildSurrogatePrincipal(String surrogate, Principal primaryPrincipal, RegisteredService registeredService);

    /**
     * Build surrogate principal principal without a service.
     *
     * @param surrogate        the surrogate
     * @param primaryPrincipal the primary principal
     * @return the principal
     */
    default Principal buildSurrogatePrincipal(final String surrogate, final Principal primaryPrincipal) {
        return buildSurrogatePrincipal(surrogate, primaryPrincipal, null);
    }

    /**
     * Build surrogate authentication result.
     *
     * @param authenticationResultBuilder the authentication result builder
     * @param mutableCredential           the mutable credential
     * @param registeredService           the registered service
     * @return the optional
     */
    Optional<AuthenticationResultBuilder> buildSurrogateAuthenticationResult(AuthenticationResultBuilder authenticationResultBuilder,
                                                                             Credential mutableCredential,
                                                                             RegisteredService registeredService);
}
