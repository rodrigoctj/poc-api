package br.com.aguiabranca.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;

import br.com.aguiabranca.model.Empresa;

@Configuration
public class SpringRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
        config.exposeIdsFor(Empresa.class);
    }

}
