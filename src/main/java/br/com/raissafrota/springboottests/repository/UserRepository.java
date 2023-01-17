package br.com.raissafrota.springboottests.repository;

import br.com.raissafrota.springboottests.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
