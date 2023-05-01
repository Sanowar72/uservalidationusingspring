package com.geekster.UniversityEventManagment.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.geekster.UniversityEventManagment.model.Event;

@Repository
public interface EventRepo extends CrudRepository<Event,Long>{

    public List<Event> findByDate(String date);
}