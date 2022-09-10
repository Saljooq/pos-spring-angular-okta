package com.example.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
// import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(Principal principal, OAuth2AuthenticationToken authentication) {
        return "<h1>Hello, " + principal.getName() + "!" + authentication.getPrincipal().getAttribute("email") + "</h1>";
    }

    @GetMapping("/api/userProfile")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public <A extends AbstractOAuth2TokenAuthenticationToken<AbstractOAuth2Token>> Map<String, Object> getUserDetails(A authentication) {
        return authentication.getTokenAttributes();
    }

    //For JWT only
    @GetMapping("/api/userProfileJWT")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public Map<String, Object> getUserDetails(JwtAuthenticationToken authentication) {
        return authentication.getTokenAttributes();
    }

    //For Opaque Token only
    // @GetMapping("/api/userProfileOpaque")
    // @PreAuthorize("hasAuthority('SCOPE_profile')")
    // public Map<String, Object> getUserDetails(BearerTokenAuthentication authentication) {
    //     return authentication.getTokenAttributes();
    // }

    @GetMapping("/api/messages")
    // @PreAuthorize("hasAuthority('SCOPE_email')")
    public Map<String, Object> messages(JwtAuthenticationToken auth) {

        Map<String, Object> result = new HashMap<>();
        result.put("messages", Arrays.asList(
                new Message("I am a robot. My email is =>" + auth.getTokenAttributes().get("sub") + "   other attr: " + auth.getTokenAttributes().toString()),
                new Message("Hello, world!")
        ));

        return result;
    }
}

class Message {
    public Date date = new Date();
    public String text;

    Message(String text) {
        this.text = text;
    }
}
@Configuration
class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

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