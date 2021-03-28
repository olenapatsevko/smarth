package tef.smarth.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tef.smarth.dto.RegistrationRequest;
import tef.smarth.repository.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Data
public class RegistrationValidator {

    @Autowired
    private UserRepository userRepository;

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public boolean isValid(RegistrationRequest request) {
        return validateFields(request) & validateEmail(request.getEmail()) & validateUserExists(request);
    }

    private boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validateUserExists(RegistrationRequest request) {
        return userRepository.findByUsername(request.getUsername()) == null &&
                userRepository.findByEmail(request.getEmail()) == null;
    }

    private boolean validateFields(RegistrationRequest request) {
        return request.getBirthday() != null &&
                request.getBloodGroup() != null &&
                request.getFirstName() != null &&
                request.getLastName() != null &&
                request.getPassword() != null &&
                request.getUsername() != null;
    }
}
