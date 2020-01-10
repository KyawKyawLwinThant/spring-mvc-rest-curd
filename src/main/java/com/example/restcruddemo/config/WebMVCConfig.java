package com.example.restcruddemo.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Optional<HttpMessageConverter<?>> foundConverter = converters
                .stream()
                .filter(a -> a instanceof MappingJackson2HttpMessageConverter)
                .findFirst();

        if(foundConverter.isPresent()){
            AbstractJackson2HttpMessageConverter converter
                    =(AbstractJackson2HttpMessageConverter)foundConverter.get();
                    converter.getObjectMapper()
                    .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
                    converter.getObjectMapper()
                            .addMixIn(Object.class,RemoveJSONProperties.class);
        }
    }
    @JsonIgnoreProperties({"hibernateLazyInitializer","{}"})
    private abstract  class RemoveJSONProperties{}
}
