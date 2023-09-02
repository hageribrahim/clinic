package com.medical.clinic.vo;


import com.medical.clinic.model.Appointment;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AppointmentVO {
    private Long id;
    private String patientName;
    private String mobile;
    private Boolean cancle;
    private String reason;
    private LocalDate canceledAt;
    private LocalDate reserveAt;


    public static AppointmentVO toVO(Appointment appointment){
        AppointmentVO appointmentVO = new AppointmentVO();
        appointmentVO.setId(appointment.getId());
        appointmentVO.setPatientName(appointment.getPatientName());
        appointmentVO.setMobile(appointment.getMobile());
        appointmentVO.setReserveAt(appointment.getReserveAt());
        appointmentVO.setCancle(appointment.getCancle());
        appointmentVO.setCanceledAt(appointment.getCanceledAt());
        appointmentVO.setReason(appointment.getReason());

        return appointmentVO;
    }

    public static List<AppointmentVO> toVOsList(List<Appointment> appointments) {
        List<AppointmentVO> AppointmentVOs = new ArrayList<>();

        for (Appointment appointment : appointments) {
            AppointmentVOs.add(toVO(appointment));
        }
        return AppointmentVOs;
    }
}
