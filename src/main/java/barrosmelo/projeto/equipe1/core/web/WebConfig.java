package barrosmelo.projeto.equipe1.core.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedMethods("*")
		.allowedHeaders("*");
	}

	/*
	 * public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/_site/**", "/v2/api-docs", "/configuration/ui",
	 * "/swagger-resources/**", "/configuration/security", "/swagger-ui.html",
	 * "/webjars/**", "/csrf"); }
	 * 
	 * protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().exceptionHandling().and().authorizeRequests().
	 * anyRequest().fullyAuthenticated().and()
	 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 * }
	 */
}
