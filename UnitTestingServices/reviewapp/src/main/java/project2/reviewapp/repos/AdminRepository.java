package project2.reviewapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project2.reviewapp.models.Admin;
import project2.reviewapp.models.User;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query(value = "select a from Admin a where a.email = :email")
    Admin findByEmail(@Param("email")String email);

    @Transactional
    @Modifying
    @Query(value = "update admins set firstname=:firstname, lastname=:lastname, email=:email where id=:id", nativeQuery = true)
    void updateAdminInfo(@Param("firstname")String firstname, @Param("lastname")String lastname, @Param("email")String email, @Param("id")int id);

    @Transactional
    @Modifying
    @Query(value = "update admins set _password=:password where id=:id", nativeQuery = true)
    void updateAdminPassword(@Param("password")String password, @Param("id")int id);
}
