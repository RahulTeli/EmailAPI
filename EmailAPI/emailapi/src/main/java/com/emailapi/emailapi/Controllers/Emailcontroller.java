package com.emailapi.emailapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailapi.emailapi.Model.Emailmodel;
import com.emailapi.emailapi.Model.Emailresponse;
import com.emailapi.emailapi.Service.Emailservice;

@RestController
@CrossOrigin
public class Emailcontroller {

    @Autowired
    Emailservice em ;

    @RequestMapping("/welcome")
    public String wel()
    {
        return "Heyyy buddy";
    }

    @PostMapping("/sendmail")  //request is taking by these handler
    public ResponseEntity<?> sendemail(@RequestBody Emailmodel emmodel)
    {
        boolean rs = em.sendEmail(emmodel.getTo(), emmodel.getSubject(), emmodel.getMessage());
        if(rs)
        {
           
            return ResponseEntity.ok(new Emailresponse("Email sent Successfully"));  //creating object and sending as message
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Emailresponse("Email not sent "));
        }
        
        

    }

}
