package be.g00glen00b.controller;



import be.g00glen00b.model.Item;
import be.g00glen00b.repository.ItemRepository;
import be.g00glen00b.websocket.ToastService;
import org.atmosphere.cpr.MetaBroadcaster;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class HomeController {

  private final MetaBroadcaster broadcaster;
  
  private final Log log = LogFactory.getLog(getClass());

  @Autowired
  private ItemRepository repo;


  @Autowired
  public HomeController(MetaBroadcaster metaBroadcaster) {
    if (metaBroadcaster == null) {
      throw new NullPointerException("metaBroadcaster must not be null");
    }
    this.broadcaster = metaBroadcaster;
  }

  /**
   * Home action.
   * 
   * @return the index page.
   */
  /*@RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
    return "index";
  }*/

  /**
   * Broadcast a message to all registered clients.
   * 
   * @param message to broadcast.
   */
  @RequestMapping(value = "/broadcast/{message}", method = RequestMethod.GET)
  @ResponseStatus(value = HttpStatus.OK)
  public void broadcast(@PathVariable("message") String message) {
	log.info("HomeController::broadcast message ="+message );
    //broadcaster.broadcastTo(ToastService.PATH, message);
   // (List<Item>) = repo.findAll();
    //broadcaster.broadcastTo(ToastService.PATH,repo.findAll());

    //String abc = [{"id":23,"checked":false,"description":"rubb"},{"id":25,"checked":false,"description":"box"}];
    /*Item it = new Item();
    it.setDescription("ABC");
    it.setChecked(true);
    it.setId(10);*/

   // String data = "[{\"id\":23,\"checked\":false,\"description\":\"rubb\"} , {\"id\":25,\"checked\":false,\"description\":\"box\"}  ]";

    try {
    ObjectMapper mapper = new ObjectMapper();
    //JSONArray jsonArray = new JSONArray();
    Iterable<Item> iterator = repo.findAll();
      String jsonInString="[";


    for(Item item: iterator) {
      log.info("HomeController::broadcast item ="+item.getDescription() );
      jsonInString  += mapper.writeValueAsString(item);
      jsonInString  +=",";
     // jsonArray.add(item);


    }

      jsonInString = jsonInString.substring(0,jsonInString.length()-1);

      jsonInString += "]";
    //String data = jsonArray.toJSONString();

      broadcaster.broadcastTo(ToastService.PATH, jsonInString);

    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }



  }

}
