package br.com.raissafrota.springboottests.services;

import br.com.raissafrota.springboottests.domain.User;
import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

}
