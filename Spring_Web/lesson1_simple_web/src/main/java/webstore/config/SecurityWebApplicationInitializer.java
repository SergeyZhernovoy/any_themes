package webstore.config;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityWebApplicationInitializer() {
		super(WebSecurity.class);
	}
}
