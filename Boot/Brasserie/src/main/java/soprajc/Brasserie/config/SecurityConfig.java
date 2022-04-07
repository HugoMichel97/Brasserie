package soprajc.Brasserie.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
					// Achat :
					.antMatchers(HttpMethod.GET ).hasRole("BRASSEUR")
					.antMatchers(HttpMethod.POST).hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT).hasRole("CLIENT")
					.antMatchers(HttpMethod.DELETE).hasRole("CLIENT")
					.antMatchers(HttpMethod.PATCH).hasRole("CLIENT")
					
					// Client :
					.antMatchers(HttpMethod.GET, "/api/client").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.GET, "/api/client/getResa").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.GET, "/api/client/getAchat").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.GET, "/api/client/{id}/**").authenticated()
					.antMatchers(HttpMethod.DELETE).hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT).hasRole("CLIENT")
					.antMatchers(HttpMethod.POST).permitAll()
					.antMatchers(HttpMethod.PATCH).authenticated()
					
					// Brasseur :
					.antMatchers("/api/brasseur/**").hasRole("BRASSEUR")
					
					// Evenement :
					.antMatchers(HttpMethod.GET).permitAll()
					.antMatchers(HttpMethod.POST).hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PUT).hasRole("BRASSEUR")
					.antMatchers(HttpMethod.DELETE).hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PATCH).hasRole("BRASSEUR")
					
					// InfoReglement :
					.antMatchers("/api/infoReglement/**").hasRole("CLIENT")
					
					// Ingredient :
					.antMatchers("/api/ingredient/**").hasRole("BRASSEUR")
					
					// Note :
					.antMatchers(HttpMethod.GET).permitAll()
					.antMatchers(HttpMethod.POST).hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT).hasRole("CLIENT")
					.antMatchers(HttpMethod.DELETE).authenticated()
					.antMatchers(HttpMethod.PATCH).hasRole("CLIENT")
					
					// Produit :
					.antMatchers(HttpMethod.GET).permitAll()
					.antMatchers(HttpMethod.POST).hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PUT).hasRole("BRASSEUR")
					.antMatchers(HttpMethod.DELETE).hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PATCH).hasRole("BRASSEUR")
					
					// Reservation :
					.antMatchers(HttpMethod.GET).hasRole("BRASSEUR")
					.antMatchers(HttpMethod.POST).hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT).hasRole("CLIENT")
					.antMatchers(HttpMethod.DELETE).hasRole("CLIENT")
					.antMatchers(HttpMethod.PATCH).hasRole("CLIENT")
					
				.and()
				.httpBasic();
		// @formatter:on
	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//service spring
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
