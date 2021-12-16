package json;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class Json {
    public void addUser(User user){
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("src/main/resources/jsonFiles/users.json"));
            var typeReference = new TypeReference<List<User>>() {};
            List<User> users = mapper.readValue(inputStream,typeReference);
//            int lastUserIdgetter = users.get(users.size()-1).getUserId();
            user.setUserId(users.size());
            users.add(user);
            mapper.writeValue(new File("src/main/resources/jsonFiles/users.json"), users);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int login(String username, String password){
        int userId = 0;
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("src/main/resources/jsonFiles/users.json"));
            var typeReference = new TypeReference<List<User>>() {};
            List<User> users = mapper.readValue(inputStream,typeReference);
            for (User u : users){
                if(username.equals(u.getUserName()) && password.equals(u.getPassword())){
                    userId = u.getUserId();
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userId;
    }

    public User getUser(int userId){
        User user = new User();
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File("src/main/resources/jsonFiles/users.json"));
            var typeReference = new TypeReference<List<User>>() {};
            List<User> users = mapper.readValue(inputStream,typeReference);
            user = users.get(userId);
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
