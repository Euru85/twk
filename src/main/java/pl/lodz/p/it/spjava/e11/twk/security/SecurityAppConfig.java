package pl.lodz.p.it.spjava.e11.twk.security;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

/**
 *
 * @author Marcin Kwapisz
 */
@FacesConfig
@ApplicationScoped
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/faces/login/customFormLogin.xhtml",
                errorPage = "/faces/login/customFormLoginError.xhtml",
                useForwardToLogin = false
        ))
public class SecurityAppConfig {

}
