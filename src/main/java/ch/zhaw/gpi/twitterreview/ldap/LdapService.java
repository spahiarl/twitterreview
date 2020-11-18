package ch.zhaw.gpi.twitterreview.ldap;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LdapService {
   @Autowired
   private UserRepository userRepository;

   public String getUser(String userName){
        Optional<User> user = userRepository.findById(userName);

        if(user.isPresent()){
            JSONObject userAsJson = new JSONObject(user.get());
            return userAsJson.toString();
        }else{
            return"404";
        }
   }

}
