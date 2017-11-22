package spring_boot.bookpub;/**
 * @author Sergey Zhernovoy
 * create on 22.11.2017.
 */

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import spring_boot.formatters.BookFormater;
import spring_boot.repositories.BookRepository;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{

    @Autowired
    private BookRepository bookRepository;

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        return new LocaleChangeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new BookFormater(bookRepository));
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false)
                  .setUseTrailingSlashMatch(true);
    }

    //First approach
    //@Bean
    //public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter(){
    //      return new ByteArrayHttpMessageConverter();
    //}

//Second approach
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.clear();
//        converters.add(new ByteArrayHttpMessageConverter());
//    }
}

    