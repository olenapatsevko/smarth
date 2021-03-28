package tef.smarth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tef.smarth.entity.RoleEntity;
import tef.smarth.entity.UserEntity;
import tef.smarth.repository.RoleRepository;
import tef.smarth.service.RoleService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> findAll() {
        return StreamSupport.stream(roleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public RoleEntity findById(Integer id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public RoleEntity save(RoleEntity complaint) {
        return roleRepository.save(complaint);
    }

    @Autowired
    public void setComplaintRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleEntity> findAllByUser(UserEntity userEntity) {
        return roleRepository.findAllByUsers(userEntity);
    }
}