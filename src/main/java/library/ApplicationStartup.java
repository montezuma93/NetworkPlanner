package library;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        System.out.println("Initializing library...");
        new Library();
        System.out.println("Library initialized");

    }
}

