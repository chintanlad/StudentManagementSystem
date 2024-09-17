package com.project.security;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	
	@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
       
       jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username,password,active from users where username=?");
 
      

       jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
    		   "select u.username,r.role from users u,authorities r where u.user_id=r.user_id and username=?");
        return jdbcUserDetailsManager;
   }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(configurer ->
    configurer
    
    		// student
            .requestMatchers(HttpMethod.GET, "/student/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/student").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/student/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/student/**").hasRole("ADMIN")
            
            
            // department
            .requestMatchers(HttpMethod.GET, "/department/**").hasAnyRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/department").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/department/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/department/**").hasRole("ADMIN")
            
            
            //semester
            .requestMatchers(HttpMethod.GET, "/semester/**").hasAnyRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/semester").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/semester/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/semester/**").hasAnyRole("ADMIN")
            
            
            //result
            .requestMatchers(HttpMethod.GET, "/result/**").hasAnyRole( "ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/result/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/result/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/result").hasAnyRole("ADMIN")
            
            
            //subject
            .requestMatchers(HttpMethod.GET, "/subject/**").hasAnyRole("DOCTOR", "ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/subject/**").hasAnyRole("ADMIN", "DOCTOR")
            .requestMatchers(HttpMethod.PUT, "/subject/**").hasAnyRole("ADMIN", "DOCTOR")
            .requestMatchers(HttpMethod.POST, "/subject").hasAnyRole("ADMIN", "DOCTOR")
            
            // users
            .requestMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
            
            // roles
            .requestMatchers(HttpMethod.DELETE, "/roles/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/roles/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.POST, "/roles").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET, "/roles/**").hasRole("ADMIN")
            
    		);

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
