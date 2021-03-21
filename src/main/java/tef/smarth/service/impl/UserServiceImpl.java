package tef.smarth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tef.smarth.entity.UserEntity;
import tef.smarth.repository.UserRepository;
import tef.smarth.service.UserService;

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
    public List findAll() {
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
        // user.setRoles(Collections.singleton(Role.getDefaultRoleInstance()));
        userRepository.save(userEntity);
    }

    public UserEntity obtainCurrentPrincipleUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername());
    }

}


//    public static User getDefaultInspectorInstance() {
////        if (defaultInspectorByRegistrationInstance == null) {
////            synchronized (User.class) {
////                if (defaultInspectorByRegistrationInstance == null) {
////                    defaultInspectorByRegistrationInstance = new User();
////                    defaultInspectorByRegistrationInstance.setId(1L);
////                }
////            }
////        }
////        return defaultInspectorByRegistrationInstance;
////    }
