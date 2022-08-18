package project2.reviewapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.reviewapp.models.Reservation;
import project2.reviewapp.models.User;
import project2.reviewapp.repos.UserRepository;
import project2.reviewapp.services.UserService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    @Value("${server.port}")
    int serverPort;

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    public ResponseEntity getAll(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createUser(@RequestBody User newUser) throws URISyntaxException{
        userRepository.save(newUser);
        return ResponseEntity.created(new URI("http://localhost:"+serverPort+"/reviewapp/users/"+newUser.getId())).build();
    }

    @DeleteMapping(path="{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path="{id}")
    public ResponseEntity getUserById(@PathVariable("id") int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity getById(@PathVariable("id") int id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path="s/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserByEmail(@RequestParam(required = false) String email){
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path="{id}")
    public ResponseEntity updateUserInfo(@PathVariable("id") int id, @RequestBody User userDetails){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setFirstname(userDetails.getFirstname());
            user.get().setLastname(userDetails.getLastname());
            user.get().setEmail(userDetails.getEmail());
            userRepository.updateUserInfo(userDetails.getFirstname(), userDetails.getLastname(), userDetails.getEmail(), id);
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path="{id}/reset")
    public ResponseEntity resetUserPassword(@PathVariable("id")int id, @RequestBody String password){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setPassword(password);
            userRepository.updateUserPassword(password, id);
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }



}
