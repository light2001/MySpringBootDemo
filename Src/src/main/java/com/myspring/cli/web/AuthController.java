package com.myspring.cli.web;

import com.myspring.cli.model.User;
import com.myspring.cli.pojo.RegisterUser;
import com.myspring.cli.repo.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.Map;
import java.util.Optional;

/**
 * Created by echisan on 2018/6/23
 */
@RestController
@RequestMapping("/auth")
@Api(value="权限认证",tags="权限认证")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private EntityManager entityManager;
    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        User user = new User();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        User save = userRepository.save(user);
        return save.toString();
    }



    @PostMapping("/MyRegister")
    public String register(@RequestBody RegisterUser registerUser){
        User user = new User();
        user.setUsername(registerUser.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.getPassword()));
        user.setRole("ROLE_USER");
        User save = userRepository.save(user);
        return save.toString();
    }

    @PostMapping("/TestLogin")
    public String TestLogin(@RequestBody RegisterUser registerUser){
        User queryUser=new User();
        queryUser.setUsername(registerUser.getUsername());
        Example<User> example = Example.of(queryUser);
        Optional<User> op = userRepository.findOne(example);
        if (op.isPresent()) {
            User user = op.get();
            if (bCryptPasswordEncoder.matches(registerUser.getPassword(),user.getPassword())) {
                return "登陆成功";
            } else {
                return "登陆失败";
            }
        }
        else
        {
            return null;
        }

    }

}
