package reviewapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reviewapp.models.Location;
import reviewapp.repo.LocationRepo;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public List<Location> getAllLocations(){ //Finds all locations
        return locationRepo.findAll();
    }

    public Optional<Location> getLocationByID(int id){ //Finds location by ID
        return locationRepo.findById(id);
    }

    public Location saveLocation(Location location){ //Saves Location
        return locationRepo.save(location);
    }

}
