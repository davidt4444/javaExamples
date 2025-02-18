// UserRepository.java (Database operations)
package com.ads.bus.repository;

import com.ads.bus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUniqueId(String uniqueId);
}