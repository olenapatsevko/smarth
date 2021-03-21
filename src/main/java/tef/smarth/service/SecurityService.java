package tef.smarth.service;


import tef.smarth.entity.RoleEntity;

import java.util.Set;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLoginAfterReg(String username, String password);

    Set<RoleEntity> getLoggedUserRoles();

    void login(String username, String password);
}
