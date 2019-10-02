package ServeurGestionContacts;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import  ServeurGestionContacts.Repositories.ContactRepository;
import ServeurGestionContacts.Entities.Contact;

@SpringBootApplication
public class ServeurGestionContactsApplication  implements CommandLineRunner{
	@Autowired 
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServeurGestionContactsApplication.class, args);
	}
	
	
	@Override
	public void run(String... arg0) throws Exception {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    contactRepository.save(new Contact("Safa", "RABHI",df.parse("16/01/1996"), "safa.rabhi@gmail.com", 28002679, "safapc/images/im.jpeg"));
    contactRepository.save(new Contact("Marwa", "RABHI",df.parse("16/01/1996"), "marwa.rabhi@gmail.com", 28002679, "marwapc/images/im.jpeg"));
    contactRepository.save(new Contact("Aymen", "RABHI",df.parse("16/01/1996"), "aymen.rabhi@gmail.com", 28002679, "aymenpc/images/im.jpeg"));
	
   /* Contact R1 = new Contact("Safa", "RABHI",df.parse("16/01/1996"), "safa.rabhi@gmail.com", 28002679, "safapc/images/im.jpeg");
    contactRepository.save(R1);*/
    contactRepository.findAll().forEach(c->{
	  System.out.println(c.getNom());
	  });
	}
}






