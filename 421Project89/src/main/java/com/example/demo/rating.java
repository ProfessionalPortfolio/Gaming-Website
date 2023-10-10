package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
//Controller for Review class
@Controller
public class rating {
    private HashMap<String, ArrayList> Reviews = new HashMap<>();
    @Autowired UserController uc;

    //gets reviews for a game, type name of game as Catname param
    @GetMapping("Review/Get/Category")
    @ResponseBody
    public ArrayList<Review> getReviewsofgames(@RequestParam(name="Catname") String name) {
        if (Reviews.containsKey(name)) {
            ArrayList<Review> game =Reviews.get(name);
            return game;
        }

        else{

            return null;
        }

    }

    @GetMapping("/review")
    public String reviewx() {
        return "Review";
    }

    @PostMapping("Review/newCategory")
    @ResponseBody
    public int createnewgame(@RequestParam(name="Catname") String name){
        if (Reviews.containsKey(name)) {
            return 1;
        }

        else{
            ArrayList<Review> reviewofgames = new ArrayList<>();
            Reviews.put(name,reviewofgames);
            return 2;
        }


    }

    @PostMapping("Review/Make")
    @ResponseBody
    public String createReview(@RequestParam(name ="Gamename") String name, @RequestBody Review review){

        if (Reviews.containsKey(name)) {
            ArrayList<Review> answer =Reviews.get(name);
            Reviews.remove(name);
            review.setUserID(uc.currentUser.getName());
            answer.add(review);
            Reviews.put(name,answer);
            uc.currentUser.getName();
            return name;

        }

        else{
            return "Fail";
        }

    }


    @DeleteMapping("Review/Delete/Category")
    @ResponseBody
    public String deleteReview(@RequestParam (name="Catname") String name){
        if (Reviews.containsKey(name)) {
            Reviews.remove(name);
            return name;
        }

        else{
            return "Fail";
        }
    }










}
