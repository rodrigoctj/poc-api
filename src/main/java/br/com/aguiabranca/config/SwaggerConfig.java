package br.com.aguiabranca.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	private final ServletContext servletContext;

    @Autowired
    public SwaggerConfig(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.host("http://localhost:8080")
					.pathProvider(new RelativePathProvider(servletContext) {
				        @Override
				        public String getApplicationBasePath() {
				            return "/";
				        }
				    })
					.select()				
					.apis(RequestHandlerSelectors.basePackage("br.com.aguiabranca.controller"))					
					.paths(PathSelectors.any())					
				.build();
	}

}
