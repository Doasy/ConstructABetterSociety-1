package ConstructABetterSociety.config;

import ConstructABetterSociety.domain.User;
import ConstructABetterSociety.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    BasicUserDetailsService basicUserDetailsService;

    @Autowired
    UserRepository userRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(basicUserDetailsService)
                .passwordEncoder(User.passwordEncoder);

        User user = new User();
        user.setEmail("admin@hi.cat");
        user.setNickname("admin");
        user.setPassword("password");
        userRepository.save(user);
    }
}