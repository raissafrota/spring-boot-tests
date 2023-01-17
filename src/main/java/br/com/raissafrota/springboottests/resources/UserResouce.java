package br.com.raissafrota.springboottests.resources;

import br.com.raissafrota.springboottests.domain.User;
import br.com.raissafrota.springboottests.dto.UserDTO;
import br.com.raissafrota.springboottests.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResouce {

    @Autowired
    UserService service;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(modelMapper.map(service.findById(id), UserDTO.class));
    }

}
