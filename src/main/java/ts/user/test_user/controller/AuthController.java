package ts.user.test_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ts.user.test_user.dto.UserRegisterDto;
import ts.user.test_user.exceptions.ErrorResponse;
import ts.user.test_user.model.User;
import ts.user.test_user.service.UserService;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        if (userService.findByEmail(userRegisterDto.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErrorResponse("User with this email already exists"));
        }

        User user = userService.register(userRegisterDto);
        return ResponseEntity.ok(user);
    }
}

