package by.gsu.pms.repos;

import by.gsu.pms.beans.FlightClass;
import by.gsu.pms.beans.Registration;
import by.gsu.pms.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface RegistrationRepo extends CrudRepository<Registration, Long> {
    List<Registration> findAll();
    List<Registration> getAllByUser(User user);
    List<Registration> getAllByUserAndDate(User user, Date date);
    List<Registration> getAllByUserAndFlightClass(User author, FlightClass flightClass);
    Registration getFirstById(long id);
}
