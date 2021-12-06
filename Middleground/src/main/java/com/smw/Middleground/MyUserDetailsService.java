package com.smw.Middleground;

import com.smw.Middleground.Database.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String sql_init = "INSERT INTO `middleground`.`rbac` (`id`, `username`, `password`, `role`) VALUES ('1', 'admin', '" + encoder.encode("123456") + "', 'ADMIN');";
//        jdbcTemplate.update(sql_init);
//        sql_init = "INSERT INTO `middleground`.`rbac` (`id`, `username`, `password`, `role`) VALUES ('2', 'user', '" + encoder.encode("654321") + "', 'USER');";
//        jdbcTemplate.update(sql_init);

        String sql = "SELECT * FROM middleground.login WHERE username=\"" + username + "\"";

        List<MyUser> listUsers = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(MyUser.class));
        for (MyUser user: listUsers) {
            return (user.returnUserDetails());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
