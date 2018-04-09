package com.sd.his.controller;

import com.sd.his.Utill.Notifications;
import com.sd.his.model.Contact;
import com.sd.his.model.Permission;
import com.sd.his.model.Role;
import com.sd.his.model.User;

import com.sd.his.service.CustomConfigService;
import com.sd.his.service.userService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private userService userService;

    @Autowired
    private CustomConfigService customConfigService;

    @Autowired
    private BCryptPasswordEncoder bycrptpasswordencoder;

    @Autowired
    private SimpMessagingTemplate template;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    Notifications notifications = new Notifications(0);

    @GetMapping("/testconf")
    public String testconf() {
        logger.info("con:" + customConfigService.getConfigDetail().get(1));
        return customConfigService.getConfigDetail().get(0);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listUser() {
        return userService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String create(@RequestBody User user) {
        user.setPassword(bycrptpasswordencoder.encode(user.getPassword()));
        user.setRole(userService.findRoleById(1));
        //  user.getContact().setCreated_on(new Date());
        //  user.getContact().setCreated_by(user);
        user.setContact(new Contact(new Date(), user));
        user.setActive(true);
        userService.save(user);
        return user.getEmail();
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        logger.info("token:logout" + authHeader);
        if (authHeader != null) {
            String tokenValue = authHeader.replace("Bearer", "").trim();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            logger.info("token:logout" + accessToken);
            tokenStore.removeAccessToken(accessToken);
        }
    }

    @DeleteMapping(path = {"user/{id}"})
    public User delete(@PathVariable("id") long id) {
        return userService.DeleteProduct(id);
    }


    @RequestMapping(value = "roles/all", method = RequestMethod.GET)
    public List<Role> listRoles() {
        return userService.allRoles();
    }

    @PostMapping("/addroles")
    public void saveRole(@RequestBody Role role) {
        List<Permission> obj = userService.findPermissionById(1);
        role.setPermissions(obj);
        Date date = new Date();
        role.setCreated_On(date);
        role.setDeleted(false);
        userService.saveRole(role);
    }

    @PostMapping("/addpermissions")
    public void savePersmission(@RequestBody Permission permission) {
        permission.setActive(true);
        permission.setCreated_On(new Date());
        permission.setDeleted(false);
        userService.savePermissions(permission);
    }

    @GetMapping("/allpermissions")
    public List<Permission> findAllPermission() {
        return userService.findAllPermissions();
    }

    @GetMapping("/notify")
    public String getNotification() {


        notifications.increment();
        logger.info("counter"+ notifications.getCount());

        template.convertAndSend("/topic/notification", notifications);

        return "Notifications successfully sent to Angular !";
    }


}

