package com.medical.clinic.dao;

import com.medical.clinic.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface  AppointmentDao  extends JpaRepository<Appointment,Long> {
//
    @Query("Select a from Appointment a where a.reserveAt <= CURRENT_DATE and a.reserveAt >= CURRENT_DATE")
    List<Appointment> findByStartBeforeAndEndAfter();

    @Query("Select a from Appointment a where a.mobile= :mobile and a.reserveAt = :reserveAt ")
    Appointment findByMobileandReserveAt (@Param("mobile")String mobile ,@Param("reserveAt") LocalDate reserveAt);

    Appointment findById(long Id);

//    @Query("Select a from Appointment a where a.reserveAt <= CURRENT_DATE and a.reserveAt >= CURRENT_DATE")
//    List <Appointment> findbyname();

    List <Appointment> findByPatientNameContaining (String patientName);

    @Query("Select a from Appointment a where a.reserveAt = :reserveAt ")
    List <Appointment> findByReserveAt(@Param("reserveAt") LocalDate reserveAt);

}
