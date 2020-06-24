package com.myspring.cli.web;

import com.myspring.cli.model.User;
import com.myspring.cli.pojo.JwtRequest;
import com.myspring.cli.pojo.RegisterUser;
import com.myspring.cli.repo.UserRepository;
import com.myspring.cli.service.UserDetailsServiceImpl;
import com.myspring.cli.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.xml.transform.Result;
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


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;



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


    /**
     *  获取 客户端来的 username password 使用秘钥加密成 json web token
     * */
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("用户已禁止登陆", e);
        } catch (BadCredentialsException e) {
            throw new Exception("用户名不存在/密码无效", e);
        }
    }

    @PostMapping(value = "/login")
    @ApiOperation(value="登录", notes = "登录接口")
    public Result login(@RequestBody JwtRequest authenticationRequest)  throws Exception {

        this.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return null;
    }


}
