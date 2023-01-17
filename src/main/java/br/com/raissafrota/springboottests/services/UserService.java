package br.com.raissafrota.springboottests.services;

import br.com.raissafrota.springboottests.domain.User;

public interface UserService {

    User findById(Integer id);

}
