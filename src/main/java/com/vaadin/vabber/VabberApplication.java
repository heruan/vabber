package com.vaadin.vabber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;

@Push
@SpringBootApplication
public class VabberApplication implements AppShellConfigurator {

    public static void main(String... args) {
        SpringApplication.run(VabberApplication.class, args);
    }

}
