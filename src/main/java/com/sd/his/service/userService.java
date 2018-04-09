package com.sd.his.service;

import com.sd.his.model.Permission;
import com.sd.his.model.Role;
import com.sd.his.model.User;
import com.sd.his.repositiories.PermissionRepo;
import com.sd.his.repositiories.RoleRepo;
import com.sd.his.repositiories.UserRepo;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service(value ="userService")
@Transactional
public class userService implements UserDetailsService {


    private UserRepo userrepo;
    private PermissionRepo permissionRepo;
    private RoleRepo roleRepo;



    userService(UserRepo userRepo, PermissionRepo permissionRepo, RoleRepo roleRepo) {
        this.userrepo = userRepo;
        this.permissionRepo = permissionRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userrepo.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        //  logger.info("loadd:" + userId +"roles:"+ role);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isActive(), true, true, true, getAuthorities(user.getRole()));

    }

    private List<SimpleGrantedAuthority> getRoles(List<Role> authlist) {
        return authlist.stream()
                .map(x -> new SimpleGrantedAuthority(x.getName()))
                .collect(Collectors.toList());
    }

    //testing
    private Collection<? extends GrantedAuthority> getAuthorities(
            List<Role> roles) {

        List<String> perm = getPrivileges(roles);
        return getGrantedAuthorities(perm);
    }


    private List<String> getPrivileges(List<Role> roles) {
        List<String> privileges = new ArrayList<>();
        List<Permission> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPermissions());
        }
        for (Permission item : collection) {
            privileges.add(item.getName());

        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    public List<Permission> findAllPermissions() {
        return permissionRepo.findAll();
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public User DeleteProduct(long id) {

        User user = findOne(id);
        if (user != null) {
            userrepo.delete(user);
        }
        return user;
    }

    public User findOne(long id) {
        return userrepo.findById(id);
    }

    public User save(User user) {
        return userrepo.save(user);
    }

    public List<Role> findRoleById(Integer id) {
      return roleRepo.findById(id);
    }

    public List<Permission> findPermissionById(Integer id) {

        return permissionRepo.findById(id);
    }


  //  @PreAuthorize("hasAuthority('api')")
    public List<Role> allRoles() {
        return roleRepo.findAll();
    }

    public void saveRole(Role role) {
        role.setName("ROLE_" + role.getName().toUpperCase());
        roleRepo.save(role);
    }

    public void savePermissions(Permission permission) {
        permission.setName("MANAGE_" + permission.getName().toUpperCase());
        permissionRepo.save(permission);
    }



}
