package kea.dk.useremployee.repository;

import kea.dk.useremployee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
        @Query("select u from User u where u.email=:email")
        User findByEmail(@Param("email") String email);
}

