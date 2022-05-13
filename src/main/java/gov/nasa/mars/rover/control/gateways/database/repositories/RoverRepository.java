package gov.nasa.mars.rover.control.gateways.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.nasa.mars.rover.control.gateways.database.entities.RoverData;

public interface RoverRepository extends JpaRepository<RoverData, Long>, JpaSpecificationExecutor<RoverData>  {

}
