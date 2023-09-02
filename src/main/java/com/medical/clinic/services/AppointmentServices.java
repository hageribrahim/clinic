package com.medical.clinic.services;

import com.medical.clinic.dao.AppointmentDao;
import com.medical.clinic.model.Appointment;
import com.medical.clinic.vo.AppointmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentServices {

    @Autowired
   private AppointmentDao appointmentDao;

    public Appointment insertAppointement(AppointmentVO appointmentVO){
        Appointment appointment = new Appointment();
        appointment.setPatientName(appointmentVO.getPatientName());
        appointment.setCancle(false);
        appointment.setReserveAt(appointmentVO.getReserveAt());
        appointment.setMobile(appointmentVO.getMobile());
        appointment.setCanceledAt(null);
        return  appointmentDao.save(appointment);
    }

    public List<AppointmentVO> getAppointementList (){
        List<Appointment> appointments =appointmentDao.findByStartBeforeAndEndAfter();
        return AppointmentVO.toVOsList(appointments);
    }

    public AppointmentVO cancleAppointement(AppointmentVO appointmentVO) {
        Appointment appointment = appointmentDao.findByMobileandReserveAt(appointmentVO.getMobile(),appointmentVO.getReserveAt());
        if (appointment != null){
            appointment.setCancle(appointmentVO.getCancle());
            appointment.setReason(appointmentVO.getReason());
            appointment.setCanceledAt(LocalDate.now());
            appointmentDao.save(appointment);
          //  if (appointmentDao.findById(appointment.getId())!=null) {
              //  return appointmentVO= null;
           // }
            return appointmentVO.toVO(appointment);
        }

     else
      return null  ;
    }

    public List<AppointmentVO> searchbyPatientName ( String patientName){
        List<Appointment> appointments =appointmentDao.findByPatientNameContaining(patientName);
        return AppointmentVO.toVOsList(appointments);
    }

    public List<AppointmentVO> searchbydate( LocalDate reserveAt){
        List<Appointment> appointments =appointmentDao.findByReserveAt(reserveAt);
        return AppointmentVO.toVOsList(appointments);
    }
}
