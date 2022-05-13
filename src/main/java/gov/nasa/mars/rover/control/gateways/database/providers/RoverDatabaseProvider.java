package gov.nasa.mars.rover.control.gateways.database.providers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import gov.nasa.mars.rover.control.controllers.dto.response.RoverResponseDTO;
import gov.nasa.mars.rover.control.domain.Direction;
import gov.nasa.mars.rover.control.domain.Plateau;
import gov.nasa.mars.rover.control.domain.Position;
import gov.nasa.mars.rover.control.domain.Rover;
import gov.nasa.mars.rover.control.gateways.database.entities.PlateauData;
import gov.nasa.mars.rover.control.gateways.database.entities.RoverData;
import gov.nasa.mars.rover.control.gateways.database.repositories.PlateauRepository;
import gov.nasa.mars.rover.control.gateways.database.repositories.RoverRepository;
import gov.nasa.mars.rover.control.utils.Pagination;

@Component
public class RoverDatabaseProvider {

	@Autowired
	private RoverRepository repository;

	@Autowired
	private PlateauRepository plateauRepository;

	public Rover createRover(final Rover rover) {

		final PlateauData plateauData = plateauRepository.getById(rover.getPlateau().getId());
		RoverData roverData = buildRoverDate(rover, plateauData);
		roverData = repository.save(roverData);

		return convertToDomain(roverData);
	}
	
	public void update(final Rover rover) {
		
		final RoverData data = repository.getById(rover.getId());
		updateData(data, rover);
		repository.save(data);
	}

	private void updateData(final RoverData data, final Rover rover) {
		data.setPositionX(rover.getPosition().getX());
		data.setPositionY(rover.getPosition().getY());
		data.setDirection(rover.getDirection().name());
		data.setUpdatedAt(LocalDateTime.now());
	}

	public Pagination<RoverResponseDTO> getAllWithPagination(final Integer pageNumber, final Integer pageSize) {

		final Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("createdAt").ascending());

		final var result = repository.findAll(pageable);

		final var pagination = new Pagination<>(result.getContent(), result.getNumber(), result.getSize(),
				result.getTotalElements());

		return pagination.map(e -> convertToDto(e));
	}
	
	public Rover getById(final Long roverId) {
		final var result = repository.getById(roverId);
		return convertToDomain(result);
	}

	private Rover convertToDomain(final RoverData roverData) {

		final Long id = roverData.getId();
		final Plateau plateau = convertToDomain(roverData.getPlateau());
		final Direction direction = Direction.valueOf(roverData.getDirection());
		final Long positionX = roverData.getPositionX();
		final Long positionY = roverData.getPositionY();

		final Position position = new Position(positionX, positionY);
		final Rover rover = new Rover(id, plateau, direction);
		rover.registerPosition(position);

		return rover;
	}
	
	private RoverResponseDTO convertToDto(final RoverData roverData) {

		final Long id = roverData.getId();
		final Long positionX = roverData.getPositionX();
		final Long positionY = roverData.getPositionY();
		final RoverResponseDTO rover = new RoverResponseDTO(id, positionX, positionY, roverData.getDirection());
		return rover;
	}

	private Plateau convertToDomain(final PlateauData plateauData) {

		final Position upperRightPosition = new Position(plateauData.getUpperRightPositionX(),
				plateauData.getUpperRightPositionY());

		final Position bottomLeft = new Position(plateauData.getBottomLeftPositionX(),
				plateauData.getBottomLeftPositionY());

		return new Plateau(plateauData.getId(), upperRightPosition, bottomLeft);
	}

	private RoverData buildRoverDate(final Rover rover, final PlateauData plateau) {

		final Direction direction = rover.getDirection();
		final Long positionX = rover.getPosition().getX();
		final Long positionY = rover.getPosition().getY();
		return new RoverData(null, plateau, direction.name(), positionX, positionY, LocalDateTime.now(), null);
	}

}
