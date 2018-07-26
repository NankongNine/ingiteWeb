package org.nankong.igniteweb.dao;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//扫描basePackages包下的类，让这些类能够被注解为SpringData的仓库接口
@EnableIgniteRepositories(basePackages = {"org.nankong.data.repository"})
public class IgniteClient {
    private static final Logger logger = LoggerFactory.getLogger(IgniteClient.class);

    private IgniteConfiguration igniteConfiguration;
    public static Ignite ignite;
    public IgniteConfiguration getIgniteConfiguration() {
        return igniteConfiguration;
    }
    public void setIgniteConfiguration(IgniteConfiguration igniteConfiguration) {
        this.igniteConfiguration = igniteConfiguration;
    }
    //IgniteRepositoryBeanFactory指定要名为igniteInstance的Bean,可查看源代码
    @Bean
    public Ignite igniteInstance() {
        ignite = Ignition.start(igniteConfiguration);
        return ignite;
    }
    public void destroy() {
        logger.info("断开与ignite的连接！");
        ignite.close();
    }
}