package soprajc.Brasserie.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// configuration urls
		// @formatter:off
		
		http.antMatcher("/api/**")
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.csrf().ignoringAntMatchers("/api/**")
				.and()
				.authorizeHttpRequests()
					.antMatchers("/api/vehicule/**").permitAll()
					.antMatchers(HttpMethod.GET , "/api/**").authenticated()
					.antMatchers("/api/**").hasRole("CLIENT")
				.and()
				.httpBasic();
					
		
//		http.antMatcher("/**")
//				.authorizeHttpRequests()
//					.antMatchers("/vehicule/**").permitAll()
//					.antMatchers("/activite/**").hasRole("CLIENT")
//					.anyRequest().authenticated()
//				.and()
//				.formLogin();
		// @formatter:on

	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// configuration methode d'authentification
		//@formatter:off
//		user en memoire		
//		auth.inMemoryAuthentication()
//				.withUser("user").password("{noop}user").roles("user")
//				.and()
//				.withUser("admin").password("{noop}admin").roles("admin");
		
		//requete sql
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//					.usersByUsernameQuery("select mail,password,true from  compte where mail=?")
//					.authoritiesByUsernameQuery("select mail,'ROLE_'||type_compte from compte  where mail=?");
//		
		
		
		//service spring
		auth.userDetailsService(userDetailsService);
		
		// @formatter:on

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
