package project2.reviewapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.reviewapp.models.Admin;
import project2.reviewapp.repos.AdminRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "admin")
public class AdminController {
    @Value("${server.port}")
    int serverPort;
    private AdminRepository adminRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllAdmin(){
        List<Admin> allAdmin = adminRepository.findAll();
        return ResponseEntity.ok(allAdmin);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAdmin(@RequestBody Admin newAdmin) throws URISyntaxException {
        adminRepository.save(newAdmin);
        return ResponseEntity.created(new URI("http://localhost:"+serverPort+"/reviewapp/admin/"+newAdmin.getId())).build();
    }

    @DeleteMapping(path="{id}")
    public ResponseEntity deleteAdmin(@PathVariable("id")int id){
        Optional<Admin> admin = adminRepository.findById(id);
        if(admin.isPresent()){
            adminRepository.delete(admin.get());
            return ResponseEntity.ok(admin.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path="{id}")
    public ResponseEntity getAdminById(@PathVariable("id") int id){
        Optional<Admin> admin = adminRepository.findById(id);
        if(admin.isPresent()){
            return ResponseEntity.ok(admin.get());
        }
        return ResponseEntity.notFound().build();
    }

//    @PutMapping(path="{id}")
//    public ResponseEntity updateAdminInfo(@PathVariable("id") int id, @RequestBody Admin adminDetails){
//        Optional<Admin> admin = adminRepository.findById(id);
//        if(admin.isPresent()){
//            admin.get().setFirstname(adminDetails.getFirstname());
//            admin.get().setLastname(adminDetails.getLastname());
//            admin.get().setEmail(adminDetails.getEmail());
//            adminRepository.updateAdminInfo(adminDetails.getFirstname(), adminDetails.getLastname(), adminDetails.getEmail(), id);
//            return ResponseEntity.ok(admin.get());
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PutMapping(path="{id}/reset")
//    public ResponseEntity resetAdminPassword(@PathVariable("id")int id, @RequestBody String password){
//        Optional<Admin> admin = adminRepository.findById(id);
//        if(admin.isPresent()){
//            admin.get().setPassword(password);
//            adminRepository.updateAdminPassword(password, id);
//            return ResponseEntity.ok(admin.get());
//        }
//        return ResponseEntity.notFound().build();
//    }
}
