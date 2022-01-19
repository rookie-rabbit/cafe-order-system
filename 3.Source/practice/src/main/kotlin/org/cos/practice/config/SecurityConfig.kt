package org.cos.practice.config

import lombok.extern.log4j.Log4j2
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import kotlin.Throws
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import java.lang.Exception

@Configuration
@Log4j2
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication().withUser("user1")
            .password("\$2a\$10\$nRzEZH4SoANA/RQyKN5obeM23Ho3N4yhO9QI6GFmp9z9SlHfOyLu.")
            .roles("USER").roles("ADMIN")
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()?.anyRequest()?.authenticated()?.and()?.csrf()?.disable()?.httpBasic()?.and()
            ?.formLogin()?.defaultSuccessUrl("/home", true)?.and()?.logout()?.and()?.exceptionHandling()
            ?.accessDeniedPage("/403")
    }
}