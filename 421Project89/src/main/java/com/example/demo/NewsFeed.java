package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
//Controller for NewsHolder class
@Controller
public class NewsFeed {
    private ArrayList<NewsHolder> postings;
    @Autowired UserController uc;

    public NewsFeed() {
        postings = new ArrayList<>();
        NewsHolder item0 = new NewsHolder(0, "John", "I am John and I made this post");
        NewsHolder item1 = new NewsHolder(1, "John", "I am also John and I posted this");
        NewsHolder item2 = new NewsHolder(2, "Smith", "I am Smith; I am not John");
        NewsHolder item3 = new NewsHolder(3, "What", "I have no clue what I am but I exist");

        postings.add(item0);
        postings.add(item1);
        postings.add(item2);
        postings.add(item3);
    }

    @PostMapping("NewsFeed/GetAll")
    @ResponseBody
    public ArrayList<String> getAllPostings() {
        ArrayList<String> l = new ArrayList();
        for(int i=0;i<postings.size();i++)
        {
            l.add("<strong>"+postings.get(i).userName + "</strong>|" + postings.get(i).messageBody + "|" + postings.get(i).ID);
        }
        return l;
    }

    @RequestMapping("NewsFeed/GetPostByName")
    @ResponseBody
    public ArrayList<NewsHolder> getPostsFromUser(@RequestParam(name="userName") String userName) {
        ArrayList<NewsHolder> result = new ArrayList<>();
        for (NewsHolder item : postings) {
            if (item.getUserName().equals(userName)) {
                result.add(item);
            }
        }
        if (result.isEmpty()) {
            return null;
        }
        else {
            return result;
        }
    }

    @GetMapping("/NewsFeed")
    public String newsFeed() {
        return "NewsFeed";
    }

    @PostMapping("NewsFeed/CreatePost")
    @ResponseBody
    public String newPost(@RequestParam("message") String message) {
        int id = postings.size();
        String name = uc.currentUser.name;
        NewsHolder item = new NewsHolder(id, name, message);
        postings.add(item);
        return "Your post has been added";
    }

    @RequestMapping("NewsFeed/UpdatePost")
    @ResponseBody
    public String updatePost(@RequestParam(name="index") int index, @RequestParam(name="newText") String newText) {
        postings.get(index).setMessageBody(newText);
        return "Your post has been updated";
    }

    @RequestMapping("NewsFeed/DeletePost")
    @ResponseBody
    public String deletePost(@RequestParam(name="index") int index) {
        postings.remove(index);
        return "Your post has been deleted";
    }
}