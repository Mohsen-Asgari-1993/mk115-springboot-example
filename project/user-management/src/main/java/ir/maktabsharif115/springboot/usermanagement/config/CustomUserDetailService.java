package ir.maktabsharif115.springboot.usermanagement.config;

import ir.maktabsharif115.springboot.usermanagement.domain.BaseUser;
import ir.maktabsharif115.springboot.usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<BaseUser> optionalUser = userService.findByUsername(username);
        if (optionalUser.isPresent()) {
            BaseUser user = optionalUser.get();
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException(username + " not found");
    }
}
