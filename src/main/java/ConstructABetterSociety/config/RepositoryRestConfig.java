package ConstructABetterSociety.config;

import ConstructABetterSociety.domain.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import javax.annotation.PostConstruct;

@Configuration
public class RepositoryRestConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(City.class);
        config.exposeIdsFor(Comment.class);
        config.exposeIdsFor(Country.class);
        config.exposeIdsFor(Place.class);
        config.exposeIdsFor(State.class);
        config.exposeIdsFor(User.class);
    }

    @PostConstruct
    public void init() {
    }
}
