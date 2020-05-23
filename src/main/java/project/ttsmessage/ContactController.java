package project.ttsmessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/send")
@CrossOrigin(value = "*")
public class ContactController {

    @Autowired
    ContactService contactService;

    @RequestMapping(method = RequestMethod.POST)
    public void sendMessage(@RequestBody Contact contact) {
        contactService.sendMessage(contact);
    }

}
