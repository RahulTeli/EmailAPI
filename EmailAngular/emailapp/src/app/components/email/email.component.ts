import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailservService } from 'src/app/services/emailserv.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent {

  constructor(private email:EmailservService,private snack:MatSnackBar){}//creating object of emailservice component and snack bar 
  Data = {
    to:"",
    subject:"",
    message:""
  }
  
  hid:boolean = false;
  
  dosubmit()
  {
    if(this.Data.to=="" || this.Data.message=="")
    {
      this.snack.open("Enter Details","cancel");
      return;
    }
    console.log("submitting....")
    this.hid = true;
    this.email.sendMail(this.Data).subscribe(  //calling sendMail()method of emailservice component by passing data object 
    reseponse =>{
      this.snack.open("Message Sent Successfully...","cancel")
      console.log(reseponse);
      this.hid = false;
    },
    error =>
    {
      console.log(error);
      this.snack.open("Something went Wrong!","cancel")
      this.hid = false;
    }

    )
  }
}
