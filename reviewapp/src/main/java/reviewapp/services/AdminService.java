package reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reviewapp.models.Admin;
import reviewapp.repo.AdminRepo;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<Admin> getAllAdmins() { //Finds all Admins
        return adminRepo.findAll();
    }

    public Optional<Admin> getAdminById(int id){ //Finds admin by ID
        return adminRepo.findById(id);
    }

    public Admin saveAdmin(Admin admin){ //Saves Admin
        return adminRepo.save(admin);
    }
}
