package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ChatRoomController {
    ArrayList<String> ChatRoomChat = new ArrayList<>();
    ArrayList<String> userList = new ArrayList<>();
    @Autowired UserController uc;



    @GetMapping("/chatroom")
    public String openChat() {
        return "Chatroom";
    }

    @PostMapping("chatroom/newUser")
    @ResponseBody
    public ArrayList<String> NewUser(@RequestParam(name="name")String name)
    {
        for(int i =0; i<userList.size(); i++)
        {
            if(userList.get(i).equals(name))
            {
                return userList;
            }
        }
        userList.add(name);
        return userList;
    }

    @PostMapping("chatroom/currentUser")
    @ResponseBody
    public String CurrentUser()
    {
        return uc.currentUser.name;
    }

    @GetMapping("chatroom/getChatUsers")
    @ResponseBody
    public ArrayList<String> getChatUsers()
    {
        return userList;
    }


    @GetMapping("chatroom/getChatUser")
    @ResponseBody
    public String getChatUser(@RequestParam(name="id")int id)
    {

        return userList.get(id);
    }


    @PostMapping("chatroom/getMessages")
    @ResponseBody
    public ArrayList<String> allChat()
    {
        return ChatRoomChat;
    }

    @PostMapping("chatroom/sendMessages")
    @ResponseBody
    public String sendChat(@RequestParam(name="name")String name)
    {
        String theFullLine = "<" + uc.currentUser.name + "> " + name;

        ChatRoomChat.add(theFullLine);

        return theFullLine;
    }

    @DeleteMapping("chatroom/removeUser")
    @ResponseBody
    public String deleteMessage(@RequestParam(name="name")String name)
    {
        String x = "";
        int flag = 0;

        for(int i =0;i<userList.size();i++)
        {
            if (userList.get(i).equals(name))
            {
                userList.remove(i);
                x = name;
                flag = -1;
                break;
            }
            else
            {
                flag = 0;
            }
        }
        if(flag==-1)
        {
            return "<Server> User with id " + x + " has been removed from the chat.";
        }
        else
        {
            return "<Server> No user found, nothing will be removed.";
        }

    }

    public ChatRoomController()
    {
        ChatRoom c1 = new ChatRoom("test user", "ExampleText");

    }



}
