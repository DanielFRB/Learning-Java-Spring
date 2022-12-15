package com.dfrb.springsecurity.security;

import com.dfrb.springsecurity.auth.ApplicationUserService;
import com.dfrb.springsecurity.jwt.JwtConfig;
import com.dfrb.springsecurity.jwt.JwtTokenVerifier;
import com.dfrb.springsecurity.jwt.JwtUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     ApplicationUserService applicationUserService,
                                     SecretKey secretKey, JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
//                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
//                .antMatchers("/api/v1/**").hasRole(CLIENT.name())
//                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(CLIENT_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(CLIENT_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(CLIENT_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .anyRequest()
                .authenticated();
//                .and()
//                .httpBasic() Eliminado por el uso de formLogin
/*                .formLogin() Eliminado por el Uso de JWT
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/products", true)
                    .usernameParameter("username")
                    .passwordParameter("password")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("Clavemuyseguraaqui")
                    .rememberMeParameter("remember-me")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login");*/
    }

  /*  protected UserDetailsService userDetailsService() {
        UserDetails danielUser = User.builder()
                .username("daniel")
                .password(passwordEncoder.encode("123456"))
//                .roles(CLIENT.name())
                .authorities(CLIENT.getSimpleGrantedAuthority())
                .build();
        UserDetails yanethUser = User.builder()
                .username("yaneth")
                .password(passwordEncoder.encode("om27032002"))
//                .roles(ADMIN.name())
                .authorities(ADMIN.getSimpleGrantedAuthority())
                .build();
        UserDetails oswaldoUser = User.builder()
                .username("oswaldo")
                .password(passwordEncoder.encode("om27032002"))
//                .roles(ADMINTRAINEE.name())
                .authorities(ADMINTRAINEE.getSimpleGrantedAuthority())
                .build();
        return new InMemoryUserDetailsManager(
                danielUser,
                yanethUser,
                oswaldoUser
        );
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
}
