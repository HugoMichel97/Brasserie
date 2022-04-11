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
					.antMatchers(HttpMethod.GET, "/api/achat/**").permitAll()//authenticated()
					.antMatchers(HttpMethod.POST, "/api/achat").permitAll()//hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT, "/api/achat/**").hasRole("CLIENT")
					.antMatchers(HttpMethod.PATCH, "/api/achat/**").hasRole("CLIENT")
					.antMatchers(HttpMethod.DELETE, "/api/achat/**").hasRole("CLIENT")
					
					// Client :
					.antMatchers(HttpMethod.GET, "/api/client").permitAll()//hasRole("BRASSEUR")
					.antMatchers(HttpMethod.GET, "/api/client/getInfoReg/{id}").permitAll()//hasRole("CLIENT")
					.antMatchers(HttpMethod.GET, "/api/client/{id}/**").permitAll()//authenticated()
					.antMatchers(HttpMethod.DELETE, "/api/client/**").permitAll()//hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT, "/api/client/**").permitAll()//hasRole("CLIENT")
					.antMatchers(HttpMethod.POST, "/api/client").permitAll()
					.antMatchers(HttpMethod.PATCH, "/api/client/**").permitAll()//authenticated()
					
					// Brasseur :
					.antMatchers("/api/brasseur/**").hasRole("BRASSEUR")
					
					// Evenement :
					.antMatchers(HttpMethod.GET, "/api/evenement/{id}/getResa").permitAll()//hasRole("BRASSEUR")
					.antMatchers(HttpMethod.GET, "/api/evenement/**").permitAll()
					.antMatchers(HttpMethod.POST, "/api/evenement").permitAll()//hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PUT, "/api/evenement/**").permitAll()//hasRole("BRASSEUR")
					.antMatchers(HttpMethod.DELETE, "/api/evenement/**").permitAll()//hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PATCH, "/api/evenement/**").permitAll()//hasRole("BRASSEUR")
					
					// InfoReglement :
					.antMatchers("/api/infoReglement/**").hasRole("CLIENT")
					
					// Ingredient :
					.antMatchers("/api/ingredient/**").hasRole("BRASSEUR")
					
					// Note :
					.antMatchers(HttpMethod.GET, "/api/note/**").permitAll()
					.antMatchers(HttpMethod.POST, "/api/note").hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT, "/api/note/**").hasRole("CLIENT")
					.antMatchers(HttpMethod.DELETE, "/api/note/**").authenticated()
					.antMatchers(HttpMethod.PATCH, "/api/note/**").hasRole("CLIENT")
					
					// Produit :
					.antMatchers(HttpMethod.GET, "/api/produit/**").permitAll()
					.antMatchers(HttpMethod.POST, "/api/produit").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PUT, "/api/produit/**").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.DELETE, "/api/produit/**").hasRole("BRASSEUR")
					.antMatchers(HttpMethod.PATCH, "/api/produit/**").hasRole("BRASSEUR")
					
					// Reservation :
					.antMatchers(HttpMethod.GET, "/api/reservation/**").permitAll()//hasRole("BRASSEUR")
					.antMatchers(HttpMethod.POST, "/api/reservation").permitAll()//hasRole("CLIENT")
					.antMatchers(HttpMethod.PUT, "/api/reservation/**").permitAll()//hasRole("CLIENT")
					.antMatchers(HttpMethod.DELETE, "/api/reservation/**").permitAll()//hasRole("CLIENT")
					.antMatchers(HttpMethod.PATCH, "/api/reservation/**").permitAll()//hasRole("CLIENT")
					
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
