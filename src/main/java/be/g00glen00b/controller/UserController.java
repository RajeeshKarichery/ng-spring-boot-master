package be.g00glen00b.controller;

import java.util.List;

//import org.atmosphere.cpr.AtmosphereResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.g00glen00b.model.User;
import be.g00glen00b.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	  private UserRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	  public List<User> findItems() {


		/*AtmosphereResource resource = (AtmosphereResource) request.getAttribute(ApplicationConfig.ATMOSPHERE_RESOURCE);

		//suspending resource to keep connection
		resource.suspend();

		//find broadcaster, second parameter says to create broadcaster if it doesn't exist
		Broadcaster broadcaster = BroadcasterFactory.getDefault().lookup(userId,true);

		//saving resource for notifications
		broadcaster.addAtmosphereResource(resource);

		long nCount = notificationService.countNewPopup(new Long(userId));
		List<Notification> notifications = notificationService.findMostRecentPopup(new Long(userId));
		List<String> response = new ArrayList<String>();
		response.add(""+nCount);
		for (Notification n:notifications) {
			response.add(n.getMessage());
		}
		return response;*/

		return (List<User>) repo.findAll();
	  }
	  
	  @RequestMapping(method = RequestMethod.POST)
	  public User addItem1(@RequestBody User user) {
		System.out.println("Add user called");  
		user.setId(null);
	    return repo.save(user);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public User updateItem(@RequestBody User updatedItem, @PathVariable Integer id) {
		  updatedItem.setId(id);
		  return repo.save(updatedItem);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteItem(@PathVariable Integer id) {
	    repo.delete(id);
	  }

}
