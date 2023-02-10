package com.example.lobster.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lobster.dao.LobsterRepository;
import com.example.lobster.handlers.RecordNotFoundException;
import com.example.lobster.model.Lobster;


@Service
public class LobsterService {

	@Autowired
	LobsterRepository lobsterRepository;

	public Lobster save(Lobster lobster) {
		if (lobster.getId() == null) {
			lobster = lobsterRepository.save(lobster);
			return lobster;
		} else {
			Optional<Lobster>lobsterOptional = lobsterRepository.findById(lobster.getId());

			if (lobsterOptional.isPresent()) {
				Lobster newEntity = lobsterOptional.get();
				newEntity.setName(lobster.getName());
				newEntity.setType(lobster.getType());
				newEntity = lobsterRepository.save(newEntity);
				return newEntity;
			} else {
				throw new RecordNotFoundException("No lobster record exist for given id");
			}
		}
	}

	public List<Lobster> findAll() {
		List<Lobster> result = (List<Lobster>) lobsterRepository.findAll();

		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Lobster>();
		}
	}

	public void deleteById(Integer id) {

		Optional<Lobster> employee = lobsterRepository.findById(id);
		if (employee.isPresent()) {
			lobsterRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Lobster record exist for given id");
		}
	}


	void deleteAll() {
		lobsterRepository.deleteAll();
	}

}
