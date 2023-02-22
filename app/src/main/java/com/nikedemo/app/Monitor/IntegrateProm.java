package com.nikedemo.app.integrateprom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IntegrateProm {

    final static Logger logger = LoggerFactory.getLogger(IntegrateProm.class);

    public static void main(String[] args) {
        SpringApplication.run(IntegrateProm.class, args);
    }

    @GetMapping("/something")
    public ResponseEntity<String> createLogs() {
        logger.warn("Just checking");
        return ResponseEntity.ok().body("All Ok");
    }
}
