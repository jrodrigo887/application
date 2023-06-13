package com.estudy.application.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estudy.application.entities.User;
import com.estudy.application.repositories.UserRepository;
import com.estudy.application.services.exceptions.DatabaseException;
import com.estudy.application.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User entitUser = userRepository.getReferenceById(id);
        return userRepository.save(updateData(entitUser, user));
    }

    private User updateData(User entiUser, User obj) {
        BeanUtils.copyProperties(obj, entiUser);
        return entiUser;
    }

    /**
     * @param id
     */
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
