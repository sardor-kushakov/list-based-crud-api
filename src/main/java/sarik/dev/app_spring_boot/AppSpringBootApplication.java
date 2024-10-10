package sarik.dev.app_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AppSpringBootApplication - Spring Boot ilovasi uchun asosiy klass.
 * Ushbu klass Spring Boot ilovasini ishga tushirish va konfiguratsiya qilish uchun
 * javobgar.
 *
 * @author SARDOR KUSHAKOV
 * @version 1.0.0
 * @see <a href="https://github.com/sardor-kushakov/list-based-crud-api">GitHub repository</a>
 */
@SpringBootApplication
public class AppSpringBootApplication {
    // Spring Boot ilovasini ishga tushirish
    public static void main(String[] args) {
        SpringApplication.run(AppSpringBootApplication.class, args);
    }
}
