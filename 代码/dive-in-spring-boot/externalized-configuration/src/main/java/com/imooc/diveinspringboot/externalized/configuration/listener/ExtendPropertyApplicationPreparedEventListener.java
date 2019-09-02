package com.imooc.diveinspringboot.externalized.configuration.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaowu.zhou on 2019/9/1.
 */
public class ExtendPropertyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent>{
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {


        ConfigurableEnvironment environment =   event.getApplicationContext().getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> source = new HashMap<>();
//        // 1. from-contextLoaded : 49
//        // 2. from-contextLoaded : 59
//        // 2. from-contextPrepared : 39
//        // 3. from-ApplicationContextInitializer : 29
//        // 4. from-environmentPrepared : 0
//        // 5. from-ApplicationEnvironmentPreparedEvent : 9
//        // 6. from-EnvironmentPostProcessor : 19
//        // application.properties : 1
//        // META-INF/default.properties : 7
        source.put("user.id", "59");
        MapPropertySource propertySource = new MapPropertySource("from-ApplicationPreparedEventListener ", source);
        propertySources.addFirst(propertySource);
    }
}
