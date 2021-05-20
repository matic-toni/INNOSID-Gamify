package projectR.backend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${admin.password}")
	private String adminPassword;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		http
		.cors().and().csrf().disable()
		.authorizeRequests()
		.antMatchers("ranking/**",
					 "events",
					 "events/**",
					 "images/**",
					 "questions").anonymous()
        .antMatchers("/questions/add", "/questions/manage", "/questions/delete/**", "/questions/update/**",
        			 "/events/add", "/events/manage", "/events/delete/**", "/events/update/**", "/events/images/**",
        			 "/forms/add", "/forms/manage", "forms/delete/**", "forms/update/**",
        			 "/images/upload", "/images/manage", "/images/upload", "/images/delete/**",
        			 "/speeches/**",
        			 "/speakers/**",
        			 "/index").authenticated()
        .and()
        .formLogin()
        .and()
        .logout();
        
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	            .withUser("admin").password(adminPassword).roles("ADMIN");
	}
	
}
