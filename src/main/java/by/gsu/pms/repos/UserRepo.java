package by.gsu.pms.repos;

import by.gsu.pms.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User getFirstByUsername(String username);
    User getFirstById(Long id);
}
