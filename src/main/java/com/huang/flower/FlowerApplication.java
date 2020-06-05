package com.huang.flower;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.huang.flower.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class FlowerApplication  {

    public static void main(String[] args) {
        SpringApplication.run(FlowerApplication.class, args);
    }

//    /**
//     * session时长设置
//     * @return
//     */
//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer(){
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer Container) {
//                Container.setSessionTimeout(12*60*60);//单位为S
//            }
//        };
//    }

}
