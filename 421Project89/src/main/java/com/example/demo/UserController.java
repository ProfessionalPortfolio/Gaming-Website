package com.example.demo;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.Date;
//NOW MAKE THE LIST OF FRIENDS DISPLAY WITH JSON
@Controller
public class UserController {
    ArrayList<User> userList = new ArrayList<User>();
    //ArrayList<User> friendList = new ArrayList();
    User currentUser = new User();


    @PostMapping("/getFriends")
    @ResponseBody
    public ArrayList<String> getFriends()
    {
        ArrayList<String> l = new ArrayList();
        for(int i=0;i<currentUser.friends.size();i++)
        {
            l.add("<strong style=\"font-size:large;\">" + currentUser.friends.get(i).name + "</strong>" + "|" + currentUser.friends.get(i).email);
        }
        return l;
    }
    @GetMapping("/menu")
    public String mainmenu(){
        return "menu";
    }

    @GetMapping("/friends")
    public String friends() {
        return "friends";
    }

    @PostMapping("/friends/addFriend")
    @ResponseBody
    public String addFriend(@RequestParam(name="name")String name)
    {
        String returner = "Unable to find an account with that name. Please try again";
        for(int i=0;i<currentUser.friends.size();i++)
        {
            if(currentUser.friends.get(i).name.equals(name))
            {
                return "That user is already on your Friends List";
            }
            else if(currentUser.name.equals(name))
            {
                return "Can't add yourself as a friend.";
            }
        }
        for(int i=0;i<userList.size();i++)
        {
            if(userList.get(i).name.equals(name))
            {
                currentUser.friends.add(userList.get(i));
                returner = name + " was successfully added as a friend";
                break;
            }
        }
        return returner;

    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    public User findByName(String n)
    {
        User s = new User("bad","bad","bad");

        return s;
    }

    @PostMapping("/login/send")
    @ResponseBody
    public String loginSend(@RequestParam(name="un") String un, @RequestParam(name="pw")String pw)
    {
        String returner = "Invalid username and or password please try again.";
        for(int i=0;i<userList.size();i++)
        {

            if(userList.get(i).name.equals(un)  && userList.get(i).password.equals(pw))
            {
                 returner = "Login Successful click Ok to continue";
                 currentUser = userList.get(i);
                 break;
            }
        }
        return returner;
    }



@PostMapping("/getAllUsers")//repurposed
@ResponseBody
public ArrayList<String> getAllUsers()
{
    ArrayList<String> l = new ArrayList<String>();
    for(int i = 0; i< userList.size(); i++)
    {
        l.add("<strong>"+userList.get(i).name+"</strong>");
    }
    return l;
}

    @GetMapping("/getUser")//repurposed
    @ResponseBody
    public User getUser(@RequestParam(name="id")int val)
    {
        return userList.get(val);
    }


    @PostMapping("/createUser")//repurposed
    @ResponseBody
    public String createUser(@RequestParam(name="name")String name,@RequestParam(name="email")String email, @RequestParam(name="pw")String pw)
    {
        for(int i=0;i<userList.size();i++)
        {
            if(userList.get(i).name.equals(name))
            {
                return "A User with that username already exists. Please try again.";
            }
        }
        User t = new User(name,email,pw);
        userList.add(t);
        return "User successfully created. Redirecting to login.";
    }
    public UserController()
    {
        User d1 = new User("dan",  "dmv5262@psu.edu", "test");
        User d2 = new User("zach",  "test@gmail.com", "test");
        User d3 = new User("avery", "test2@gmail.com", "test");
        User friend = new User("Hub representative", "Hubrep@GameHub.com", "test");
        d1.friends.add(friend);
        d2.friends.add(friend);
        d3.friends.add(friend);
        userList.add(d1);
        userList.add(d2);
        userList.add(d3);

    }

/*
    @DeleteMapping("/deleteUser")//repurposed
    @ResponseBody
    public String deleteUser(@RequestParam(name="id")int id)
    {
        userList.remove(id);
        return "User with id " + id + " has been removed";
    }*/

        /*@RequestMapping(value ="/login/send", method = RequestMethod.POST)
    @ResponseBody
    public String loginSend(@RequestBody User login) throws ServletException
    {
        String jwtToken = "";
        if(login.getName() == null || login.getPassword() == null)
        {
            throw new ServletException("Please fill in username and password");
        }
        String name = login.getName();
        String password = login.getPassword();

        User user = findByName(name);

        if(user == null){
            throw new ServletException("User not found");
        }

        String pwd = user.getPassword();

        if(!password.equals(pwd)){
            throw new ServletException("Invalid login. Please check credentials and try again");
        }

        jwtToken = Jwts.builder().setSubject(name).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }*/


//curl -X POST -d '{}' -u admin:admin http://localhost:8080/changemenu
    //curl -X POST -d '{"type":"test","priceEach":6.0,"description":"test description"}' -u admin:admin https://localhost:8443/createCategory
}
