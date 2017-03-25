package br.org.catolicasc.cubeworks.springmvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
import br.org.catolicasc.cubeworks.springmvc.converter.RoleToUserProfileConverter;
 
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.org.catolicasc.cubeworks.springmvc")
public class AppConfig extends WebMvcConfigurerAdapter{
     
    @Autowired
    RoleToUserProfileConverter roleToUserProfileConverter;
     
    /**
     * Configura os ViewResolvers do spring para retornarem as views desejadas.
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }
     
    /**
     * Configura os ResourceHandlers para servirem recursos estáticos
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
     
    /**
     * Configura o Converter para ser utilizado.
     * Neste exemplo ele é usado para convertir de id para UserProfile
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
    }
     
 
    /**
     * Configura o MessageSource para procurar por mensagens nos arquivos de configuração
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
     
    /**Opcional. Usado quando tivermos '.' nas @PathVariables 
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}
