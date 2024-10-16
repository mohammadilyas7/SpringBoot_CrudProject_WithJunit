package example.User_Service.repository;

import example.User_Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,String>{
    User findByEmail(String email);
}