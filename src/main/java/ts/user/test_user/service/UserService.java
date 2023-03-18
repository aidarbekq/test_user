package ts.user.test_user.service;

import ts.user.test_user.dto.UserRegisterDto;
import ts.user.test_user.model.User;

public interface UserService {
    User register(UserRegisterDto userRegisterDto);

    User findByEmail(String email);

    void update(User user);

}
