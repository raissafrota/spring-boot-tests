package br.com.raissafrota.springboottests.services.Impl;

import br.com.raissafrota.springboottests.domain.User;
import br.com.raissafrota.springboottests.exceptions.ObjectNotFoundException;
import br.com.raissafrota.springboottests.repository.UserRepository;
import br.com.raissafrota.springboottests.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}