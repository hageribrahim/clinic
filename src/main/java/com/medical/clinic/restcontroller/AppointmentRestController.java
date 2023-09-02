package com.medical.clinic.restcontroller;

import com.medical.clinic.services.AppointmentServices;
import com.medical.clinic.vo.AppointmentVO;
import com.medical.clinic.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AppointmentRestController extends BaseController {

    @Autowired
    private AppointmentServices appointmentServices;

    @GetMapping("/home")
    public List<AppointmentVO> home(){
        return appointmentServices.getAppointementList();
    }

    @PostMapping("/takeappointment")
    public ResponseEntity takeAppointment(@RequestBody AppointmentVO request ){
        appointmentServices.insertAppointement(request);
        return successResponse(new ResponseVO(200,"the appotiment reserved"));
    }

    @PostMapping("/cancleappointment")
    public ResponseEntity cancelAppointment(@RequestBody AppointmentVO request ){
       AppointmentVO appointmentVO= appointmentServices.cancleAppointement(request);
       if (appointmentVO == null)
           return successResponse(new ResponseVO(-100,"the appointment is not cancled"));

       else
           return successResponse(new ResponseVO(200,"the appointment cancled"));
    }

    @PostMapping("/filtername")
    public List<AppointmentVO> filtername(@RequestBody AppointmentVO request ){

         return appointmentServices.searchbyPatientName(request.getPatientName());

    }


    @PostMapping("/filtedate")
    public List<AppointmentVO> filterdate(@RequestBody AppointmentVO request ){

        return appointmentServices.searchbydate(request.getReserveAt());

    }

}
