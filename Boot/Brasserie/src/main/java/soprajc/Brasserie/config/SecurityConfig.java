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
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
					.antMatchers(HttpMethod.GET , "/api/achat/**").authenticated()
					.antMatchers(HttpMethod.GET , "/api/achat").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.POST , "/api/achat").authenticated()
					.antMatchers(HttpMethod.PUT , "/api/achat/**").authenticated()
					.antMatchers(HttpMethod.DELETE , "/api/achat/**").authenticated()
					
					// Client :
					.antMatchers(HttpMethod.GET, "/api/client").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.GET, "/api/client/getResa").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.GET, "/api/client/getAchat").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.GET, "/api/client/**").authenticated()
					.antMatchers(HttpMethod.DELETE, "/api/client/**").hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT, "/api/client/**").hasRole("CLIENT")
					.antMatchers(HttpMethod.POST, "/api/client").permitAll()
					
					// Evenement :
					.antMatchers(HttpMethod.GET, "/api/evenement/**").permitAll()
					.antMatchers(HttpMethod.POST, "/api/evenement").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PUT, "/api/evenement/**").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.DELETE, "/api/evenement/**").hasRole("BRASSEUR")
					
					// InfoReglement :
					.antMatchers("/api/InfoReglement/**").authenticated()
					
					// Ingredient :
					.antMatchers("/api/ingredient/**").hasRole("BRASSEUR")
					
					// Note :
					.antMatchers(HttpMethod.GET, "/api/note/**").permitAll()
					.antMatchers(HttpMethod.POST, "/api/note").hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT, "/api/note/**").hasRole("CLIENT")
					.antMatchers(HttpMethod.DELETE, "/api/note/**").authenticated()
					
					// Produit :
					.antMatchers(HttpMethod.GET, "/api/produit/**").permitAll()
					.antMatchers(HttpMethod.POST, "/api/produit").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PUT, "/api/produit/**").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.DELETE, "/api/produit/**").hasRole("BRASSEUR")
					
					// Reservation :
					.antMatchers(HttpMethod.GET, "/api/reservation/**").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.POST, "/api/reservation").hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT, "/api/reservation/**").hasRole("CLIENT")
					.antMatchers(HttpMethod.DELETE, "/api/reservation/**").hasRole("CLIENT")
					
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
