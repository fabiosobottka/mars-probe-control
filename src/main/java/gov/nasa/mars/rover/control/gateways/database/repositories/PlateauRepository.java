package gov.nasa.mars.rover.control.gateways.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.nasa.mars.rover.control.gateways.database.entities.PlateauData;

public interface PlateauRepository extends JpaRepository<PlateauData, Long>, JpaSpecificationExecutor<PlateauData> {

}
