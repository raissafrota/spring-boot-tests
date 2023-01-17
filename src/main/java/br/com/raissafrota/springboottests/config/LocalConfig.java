package br.com.raissafrota.springboottests.config;

import br.com.raissafrota.springboottests.domain.User;
import br.com.raissafrota.springboottests.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void iniciarBancoDeDados() {
        User u1 = new User(null, "Raissa", "raissa@email.com", "123");
        User u2 = new User(null, "Maria", "maria@email.com", "456");

        repository.saveAll(List.of(u1, u2));
    }
}
