package project2.reviewapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project2.reviewapp.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
