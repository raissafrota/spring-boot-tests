package br.com.raissafrota.springboottests.services.Impl;

import br.com.raissafrota.springboottests.domain.User;
import br.com.raissafrota.springboottests.dto.UserDTO;
import br.com.raissafrota.springboottests.exceptions.DataIntegratyViolationException;
import br.com.raissafrota.springboottests.exceptions.ObjectNotFoundException;
import br.com.raissafrota.springboottests.repository.UserRepository;
import br.com.raissafrota.springboottests.services.UserService;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(modelMapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return repository.save(modelMapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema!");
        }
    }
}
