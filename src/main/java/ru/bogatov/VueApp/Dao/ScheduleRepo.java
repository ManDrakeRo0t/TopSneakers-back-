package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.Schedule;
@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {
}
