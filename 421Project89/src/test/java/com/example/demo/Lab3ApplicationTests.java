package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@SpringBootTest
class Lab3ApplicationTests {

    @Test
    void contextLoads() {
    }

    /*@Test
    public void testChangeMenu()
    {
        String menuJson = "{\"Menu\":\"test\"}";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(menuJson,header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/changemenu", HttpMethod.POST, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }*/
    @Test
    public void happyTestDeleteUser()
    {
        //String test = "{\"type\":\"pizza\"}";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/deleteUser?id=0", HttpMethod.DELETE, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }
    @Test
    public void unhappyTestDeleteUser()
    {
        String test = "{\"type\":\"THISWONTWORK\"}";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/deleteUser?index=a", HttpMethod.DELETE, entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
    }
    @Test
    public void happyTestUpdateUser()
    {
        String test = "{\"type\":\"testType\",\"priceEach\":7,\"description\":\"everything pizza\"}";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(test,header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/updateUser?id=0", HttpMethod.PUT, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }
    @Test
    public void unhappyTestUpdateUser()
    {
        String test = "{\"type\":\"THISWONTEXIST\"}";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(test,header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/updateUser?id=testType", HttpMethod.PUT, entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
    }
    @Test
    public void happyTestCreateUser()
    {
        String test = "{\"name\":\"testTypeCreate\",\"id\":5,\"email\":\"everythingpizza@gmail.com\"}";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(test,header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/createUser", HttpMethod.POST, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());

    }
    @Test
    public void unhappyTestCreateUser()
    {
        String test = "{\"name\rtgggdggrthrhyh\"teiukughtstTypeCreate\",\"id\":5,\"email\"gfbb:\"rggdfgrgdgdfgfd@gmail.com\"}";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/createUser", HttpMethod.POST, entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
    }
    @Test
    public void testGetUsers()
    {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/getAllUsers", HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }
    @Test
    public void happyTestGetUser()
    {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/getUser?id=0", HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }
    @Test
    public void unhappyTestGetUser()
    {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
       // header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/getUser?id=a", HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
    }

    //averys tests below

    @Test
    void testcaseCatPositive(){
        String Catjson="";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/newCategory?Catname=Wow", HttpMethod.POST,entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }
    //Test to make sure a duplicate category isn't maid
    @Test
    void testcaseCatNegative(){
        String menujson="";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(menujson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/newCategory?Catname=Wow", HttpMethod.POST,entity, String.class);

        Assertions.assertEquals("2", r.getBody());
    }
    //Test with no input
    @Test
    void testcaseCatNegative2(){
        String Catjson="";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/newCategory", HttpMethod.POST,entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
    }
    //Review/make tests
    // Test with valid inputs.
    @Test
    void testcaseReviewPositive(){
        String Catjson="{\"UserID\":\"12\",\"Rating\":\"6\",\"Text_writing\":\"good\",\"Game_Title\":\"World of war\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/Make?Gamename=Wow", HttpMethod.PUT,entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }
    //test for incorrect input
    @Test
    void testcaseReviewNegative(){
        String Catjson="{\"UserID\":\"13\",\"Rating\":\"twenty\",\"Text_writing\":\"good\",\"Game_Title\":\"World of war\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/Make?Gamename=Wow", HttpMethod.PUT,entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
    }
    //Test for reviewing non existent game
    @Test
    void testcaseReviewNon(){
        String Catjson="{\"UserID\":\"15\",\"Rating\":\"20\",\"Text_writing\":\"good\",\"Game_Title\":\"World of war\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/Make?Gamename=Larry", HttpMethod.PUT,entity, String.class);
        Assertions.assertEquals("Fail", r.getBody());
    }
    // Get Review by games
    //Normal get
    @Test
    void testcaseGetGood(){
        String Catjson="";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/Get/Category?Catname=Wow", HttpMethod.GET,entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }
    //Getting game that doesn't exist
    @Test
    void testcaseGetBad(){
        String Catjson="";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/Get/Category?Catname=jack", HttpMethod.GET,entity, String.class);
        Assertions.assertEquals(null, r.getBody());
    }
    //Sending request without specifying game
    @Test
    void testcaseGetnone(){
        String Catjson="";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/Get/Category", HttpMethod.GET,entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
    }
    //Delete Category
    // Positive delete test
    @Test
    void deletepositiveCat(){
        String Catjson="";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/Delete/Category?Catname=Wow", HttpMethod.DELETE,entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());

    }

    //trying to delete non existent game
    @Test
    void deletenegativeCat(){
        String Catjson="";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/Delete/Category?Catname=jason", HttpMethod.DELETE,entity, String.class);
        Assertions.assertEquals("Fail", r.getBody());

    }
    // delete test without param
    @Test
    void deletenullCat(){
        String Catjson="";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin","admin");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(Catjson, headers);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/Review/Delete/Category", HttpMethod.DELETE,entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());

    }
    
    @Test
    void testGetAll() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/getAll", HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }

    @Test
    void testGetPostsFromUser1() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/getPostsFromUser?userName=John", HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }

    @Test
    void testGetPostsFromUser2() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/getPostsFromUser?userName=Smith", HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }

    @Test
    void testGetPostsFromUser3() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/getPostsFromUser?userName=What", HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }

    /*@Test
    void testNewPost1() {
        NewsFeed tester = new NewsFeed();
        NewsHolder testObject = new NewsHolder(4, "Myself", "Post body");
        Assertions.assertEquals(tester.newPost(testObject), "Your post has been added");
    }

    @Test
    void testNewPost2() {
        NewsFeed tester = new NewsFeed();
        NewsHolder testObject = new NewsHolder(5, "Yourself", "Post body of you");
        Assertions.assertEquals(tester.newPost(testObject), "Your post has been added");
    }

    @Test
    void testNewPost3() {
        NewsFeed tester = new NewsFeed();
        NewsHolder testObject = new NewsHolder(6, "Thyself", "Better prepare");
        Assertions.assertEquals(tester.newPost(testObject), "Your post has been added");
    }*/

    @Test
    void testUpdatePost1() {
        NewsFeed tester = new NewsFeed();
        int index = 0;
        String update = "I am the first update test";
        Assertions.assertEquals(tester.updatePost(index, update), "Your post has been updated");
    }

    @Test
    void testUpdatePost2() {
        NewsFeed tester = new NewsFeed();
        int index = 1;
        String update = "I am the second update test";
        Assertions.assertEquals(tester.updatePost(index, update), "Your post has been updated");
    }

    @Test
    void testUpdatePost3() {
        NewsFeed tester = new NewsFeed();
        int index = 2;
        String update = "I am the third update test";
        Assertions.assertEquals(tester.updatePost(index, update), "Your post has been updated");
    }

    @Test
    void testDeletePost1() {
        NewsFeed tester = new NewsFeed();
        int index = 0;
        Assertions.assertEquals(tester.deletePost(index), "Your post has been deleted");
    }

    @Test
    void testDeletePost2() {
        NewsFeed tester = new NewsFeed();
        int index = 1;
        Assertions.assertEquals(tester.deletePost(index), "Your post has been deleted");
    }

    @Test
    void testDeletePost3() {
        NewsFeed tester = new NewsFeed();
        int index = 2;
        Assertions.assertEquals(tester.deletePost(index), "Your post has been deleted");
    }

    @Test
    public void happyCreateMessage()
    {
        String test = "{\"gamerTag\":\"testGT\",\"userMessage\":\"ExampleMessage\"}";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(test,header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/createMessage", HttpMethod.POST, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());

    }
    @Test
    public void unhappyCreateMessage()
    {
        String test = "{\"gamerTag\":testGT\",bb\"userMessagewfwrefewfe\":\"ExampleMessage\"}";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(test,header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/createMessage", HttpMethod.POST, entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());

    }
    @Test
    public void happyTestDeleteMessage()
    {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/deleteMessage?id=0", HttpMethod.DELETE, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }
    @Test
    public void unhappyTestDeleteMessage()
    {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/deleteMessage?id=a", HttpMethod.DELETE, entity, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, r.getStatusCode());
    }
    @Test
    public void testGetAllMessages()
    {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBasicAuth("admin","admin");
        HttpEntity<String> entity = new HttpEntity<>(header);
        TestRestTemplate t = new TestRestTemplate();
        ResponseEntity<String> r = t.exchange("http://localhost:8080/getAllChat", HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(HttpStatus.OK, r.getStatusCode());
    }


}
