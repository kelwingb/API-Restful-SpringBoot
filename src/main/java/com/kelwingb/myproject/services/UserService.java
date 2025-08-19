package com.kelwingb.myproject.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelwingb.myproject.models.User;
import com.kelwingb.myproject.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  
  public User findById(Long id) {
    Optional<User> user = this.userRepository.findById(id);
    if (user.isPresent()) {
      return user.get();
    } else {
    return user.orElseThrow(() -> new RuntimeException(
      "Usuário não encontrado! id: " + id + ", tipo: " + User.class.getName()
    ));
    }
  }
    
    @Transactional
    public User create(User obj) {
      obj.setId(null);
      obj = this.userRepository.save(obj);
      return obj;
    }
    @Transactional
    public User update (User obj) {
      User newObj = findById(obj.getId());
      newObj.setPassword(obj.getPassword());
      return this.userRepository.save(newObj);
    }

    public void delete(Long id) {
      findById(id);
      try {
        this.userRepository.deleteById(id);
      } catch (Exception e) {
        throw new RuntimeException("Não é possível excluir o usuário com id: " + id + ", pois ele possui tarefas associadas.");
      }
    }
}