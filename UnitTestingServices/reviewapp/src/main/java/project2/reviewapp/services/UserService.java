package project2.reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import project2.reviewapp.models.User;
import project2.reviewapp.repos.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<User> getAllUsers() { //Finds all users
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) { //Finds user by ID
            return userRepository.findById(id);
        }

    public User saveUser(User user){ //Saves User
        return userRepository.save(user);
    }
    }
