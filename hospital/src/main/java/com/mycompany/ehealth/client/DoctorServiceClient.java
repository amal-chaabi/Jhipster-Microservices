package com.mycompany.ehealth.client;

import com.mycompany.ehealth.client.remoteEntities.*;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@AuthorizedFeignClient(name="doctor")
public interface DoctorServiceClient{

@RequestMapping(method= RequestMethod.GET,value = "/api/doctors")
List<Doctor> getAllDoctors() ;

@RequestMapping(method= RequestMethod.POST,value = "/api/doctors")
List<Doctor> createlDoctors() ;


@RequestMapping(method= RequestMethod.PUT,value = "/api/doctors")
Doctor updateDoctors() ;


@RequestMapping(method= RequestMethod.DELETE,value = "/api/doctors/{id}")
List<Doctor> deleteDoctors(Long id) ;
}
