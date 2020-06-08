package com.study.shop.config;

import com.study.shop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         //this.inMemoryAuthentication(auth);
         //this.jdbcAuthentication(auth);
        this.userDetailAuthentication(auth);

    }
//
//    // 内存身份认证
//    private void inMemoryAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("test").password(encoder.encode("test"))
//                .roles("common").and().withUser("admin").password(encoder.encode("admin")).roles("vip");
//    }
//
//    @Autowired
//    private DataSource dataSource;

    // JDBC身份认证
//    private void jdbcAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        String userSQL = "select Username,Password,Valid from Customer where Username = ?";
//        String authoritySQL = "select c.username,a.authority from Customer c,Authority a,"
//                + "CustomerAuthority ca where CustomerId=c.id " + "and ca.AuthorityId=a.id and c.username =?";
//        String userSQL = "select Username,Password,email from user where Username = ?";
//        String authoritySQL = "select Username, authority from user where Username = ?";
//        auth.jdbcAuthentication().passwordEncoder(encoder)
//                .dataSource(dataSource)
//                .usersByUsernameQuery(userSQL)
//                .authoritiesByUsernameQuery(authoritySQL);
//    }

     @Autowired
     private UserDetailsServiceImpl userDetailsService;

    private void userDetailAuthentication(AuthenticationManagerBuilder auth) throws Exception {
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         auth.userDetailsService(userDetailsService).passwordEncoder(encoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // this.authorizeRequests(http);
        // this.formLogin(http);
        // this.logout(http);
        // this.rememberMe(http);
        //http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
        // http.csrf().disable();


        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login/**").permitAll()
                .anyRequest().authenticated();

        //自定义用户登入
        http.formLogin()
                .loginPage("/userLogin").permitAll()
                .usernameParameter("name").passwordParameter("pwd")
                .defaultSuccessUrl("/")
                .failureUrl("/userLogin?error");

    }

//    // 自定义用户授权管理
//    private void authorizeRequests(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                // 放行
//                .antMatchers("/").permitAll()
//                // 需要对static文件夹下静态资源进行统一放行
//                .antMatchers("/login/**").permitAll().antMatchers("/detail/common/**").hasRole("common")
//                .antMatchers("/detail/vip/**").hasRole("vip").anyRequest().authenticated();
//        // .and()
//        // .formLogin();
//    }
//
//    // 自定义用户登录
//    private void formLogin(HttpSecurity http) throws Exception {
//        http.formLogin().loginPage("/userLogin").permitAll().usernameParameter("name").passwordParameter("pwd")
//                .defaultSuccessUrl("/").failureUrl("/userLogin?error");
//    }
//
//    // 自定义用户退出控制
//    private void logout(HttpSecurity http) throws Exception {
//        http.logout().logoutUrl("/mylogout").logoutSuccessUrl("/");
//    }
//
//    // 定制Remember-me记住我功能
//    private void rememberMe(HttpSecurity http) throws Exception {
//        http.rememberMe().rememberMeParameter("rememberme").tokenValiditySeconds(600)
//                // 对cookie信息进行持久化管理
//                .tokenRepository(tokenRepository());
//    }
//
//    /**
//     * 持久化Token存储
//     *
//     * @return
//     */
//    @Bean
//    public JdbcTokenRepositoryImpl tokenRepository() {
//        JdbcTokenRepositoryImpl jr = new JdbcTokenRepositoryImpl();
//        jr.setDataSource(dataSource);
//        return jr;
//    }
}
