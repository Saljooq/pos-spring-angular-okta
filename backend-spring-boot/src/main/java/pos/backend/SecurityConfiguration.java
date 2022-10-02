package pos.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests(authorize -> authorize.antMatchers("/api/public/**").permitAll());

        http.authorizeRequests((requests) -> requests.anyRequest().authenticated());

        // // enables OAuth redirect login
        // http.oauth2Login();
    
        // // enables OAuth Client configuration
        // http.oauth2Client();
    
        // enables REST API support for JWT bearer tokens
        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        http.cors();
    
        return http.build();
    }

}


@Configuration
class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}