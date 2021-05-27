package com.nab.core.auth.basic;

import com.nab.model.User;
import com.nab.user.db.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class BasicAuthService {

    private final UserRepository userRepository;

   private ThreadLocal<Optional<User>> users = new ThreadLocal<>();


    public BasicAuthService(UserRepository userRepository) {
         this.userRepository = userRepository;
    }

    public void setAuthenticatedUser(HttpServletRequest request) {
        // get auth header;
        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (BasicAuthToken.isBasicAuthToken(auth)) {
            BasicAuthToken token = BasicAuthToken.parse(auth);
            this.users.set(userRepository.findByUsername(token.login)
                    .filter(u -> token.password.equals(u.getPassword())));
        } else {
            this.users.set(Optional.empty());
        }
    }

    public Optional<User> getAuthenticatedUser() {
        return users.get();
    }


}
