package ServeurGestionContacts.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ServeurGestionContacts.Entities.Contact;
import ServeurGestionContacts.Repositories.ContactRepository;

@RestController
@CrossOrigin("*")
public class ContactRestService {
	@Autowired
private ContactRepository contactRepository;
	
@RequestMapping(value="/contacts",method=RequestMethod.GET)
public List<Contact> getContacts(){
	return contactRepository.findAll();
}

@RequestMapping(value="/chercherContacts",method=RequestMethod.GET)
public Page<Contact> chercher(
		@RequestParam(name="mc",defaultValue="") String mc,
		@RequestParam(name="page",defaultValue="0") int page,
		@RequestParam(name="size",defaultValue="5") int size){
				
	return contactRepository.chercher("%"+mc+"%",new PageRequest(page, size));
}

@GetMapping("/contacts/{id}")
Contact getContact(@PathVariable Long id) {
    return contactRepository.findById(id).get();
}
@RequestMapping(value="/contacts", method=RequestMethod.POST)
public Contact save(@RequestBody Contact C) {
	 return contactRepository.save(C);
}
@DeleteMapping("/contacts/{id}")
void delete(@PathVariable Long id) {
    contactRepository.deleteById(id);
}

@PutMapping("/contacts/{id}")
Contact update(@PathVariable Long id,@RequestBody Contact c) {
   c.setId(id);
	return contactRepository.save(c);
}

}

