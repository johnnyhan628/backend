package base.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    return http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/login", "/join").permitAll()
        .requestMatchers("/sitecontrol").hasRole("ADMIN") //"/admin" 경로는 공격 타겟이 되기 쉬우므로 비표준 경로 사용
        .requestMatchers("/mypage").hasAnyRole("ADMIN", "USER")
      )
      .formLogin(Customizer.withDefaults())
      .csrf(csrf -> csrf.disable())
      .build();
  }
}