package br.com.raissafrota.springboottests.services;

import br.com.raissafrota.springboottests.domain.User;
import br.com.raissafrota.springboottests.dto.UserDTO;
import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO obj);

    User update(UserDTO obj);

    void delete(Integer id);

}
