package reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reviewapp.models.User;
import reviewapp.repo.UserRepo;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<User> getAllUsers() { //Finds all users
        return userRepo.findAll();
    }

    public Optional<User> getUserById(int id) { //Finds user by ID
            return userRepo.findById(id);
        }

    public User saveUser(User user){ //Saves User
        return userRepo.save(user);
    }
    }
