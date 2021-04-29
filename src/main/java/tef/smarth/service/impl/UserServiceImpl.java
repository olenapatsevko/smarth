package tef.smarth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tef.smarth.entity.UserEntity;
import tef.smarth.repository.UserRepository;
import tef.smarth.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserEntity> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public UserEntity findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public void registerUser(UserEntity userEntity) {
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    @Transactional
    public UserEntity updateCurrentUser(UserEntity userEntity){
        UserEntity currentUser1 = obtainCurrentPrincipleUser();
        UserEntity currentUser = userRepository.findByUsername(currentUser1.getUsername());
        if (userEntity.equals(currentUser)){
            return currentUser;
        }
        if (!userEntity.getEmail().equals(currentUser.getEmail())){
            currentUser.setEmail(userEntity.getEmail());
        }
        if (!userEntity.getFirstName().equals(currentUser.getFirstName())){
            currentUser.setFirstName(userEntity.getFirstName());
        }
        if (!userEntity.getLastName().equals(currentUser.getLastName())){
            currentUser.setLastName(userEntity.getLastName());
        }
        if (!userEntity.getUsername().equals(currentUser.getUsername())){
            currentUser.setUsername(userEntity.getUsername());
        }
        if (!userEntity.getPassword().isBlank() && !bCryptPasswordEncoder.encode(userEntity.getPassword()).equals(currentUser.getPassword())){
            currentUser.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        }
        if (!userEntity.getBirthday().equals(currentUser.getBirthday())){
            currentUser.setBirthday(userEntity.getBirthday());
        }

        return userRepository.save(currentUser);
    }

    public UserEntity obtainCurrentPrincipleUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername());
    }

}