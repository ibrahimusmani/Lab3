/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arshad
 */
public class RestaurantTest {
    
    public RestaurantTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of reservation method, of class Restaurant.
     */
    @Test
    public void testReservation() {
        System.out.println("reservation");
        String table = "xl";
        int time = 5;
        Restaurant instance = new Restaurant();
        String expResult = "Extra large table for 12 booked for you for 5 hours sir";
        String result = instance.reservation(table, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of prepareOrder method, of class Restaurant.
     */
    @Test
    public void testPrepareOrder() {
        System.out.println("prepareOrder");
        String[] s = {"","a","b","c","d","","","","","","","","","","","","","","",""};
        String res = "xl";
        int time = 5;
        Restaurant instance = new Restaurant();
        String expResult = "You'll have to wait for 120 minutes";
        String result = instance.prepareOrder(s, res, time);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of serve method, of class Restaurant.
     */
    @Test
    public void testServe() {
        System.out.println("serve");
        String[] s = {"","a","b","c","d","","","","","","","","","","","","","","",""};
        int i = 5;
        String res = "xl";
        Restaurant instance = new Restaurant();
        String expResult = "serving a, b, c, d";
        String result = instance.serve(s, i, res);
        assertEquals(expResult, result);
    }
    /**
     * Test of reservation method, of class Restaurant.
     */
    @Test
    public void testReservation1() {
        System.out.println("reservation");
        String table = "Small";
        int time = 5;
        Restaurant instance = new Restaurant();
        String expResult = "Small table for 2 booked for you for 2 hours sir because we have too many guests today!";
        String result = instance.reservation(table, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of prepareOrder method, of class Restaurant.
     */
    @Test
    public void testPrepareOrder1() {
        System.out.println("prepareOrder");
        String[] s = {"","a","b","c","d","","","","","","","","","","","","","","",""};
        String res = "Lorem Ipsum";
        int time = 69;
        Restaurant instance = new Restaurant();
        String expResult = "Error"; //Because Lorem ipsum is not a category if tables
        String result = instance.prepareOrder(s, res, time);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of serve method, of class Restaurant.
     */
    @Test
    public void testServe1() {
        System.out.println("serve");
        String[] s = {"","a","b","c","d","","","","","","","","","","","","","","",""};
        int i = 5;
        String res = "smally";
        Restaurant instance = new Restaurant();
        String expResult = "Error"; //Because smally is not a table type
        String result = instance.serve(s, i, res);
        assertEquals(expResult, result);
    }
    
    
    
    /**
     * Test of reservation method, of class Restaurant.
     */
    @Test
    public void testReservation2() {
        System.out.println("reservation");
        String table = "lol";
        int time = 1;
        Restaurant instance = new Restaurant();
        String expResult = "Invalid choice"; //lol is not a table type
        String result = instance.reservation(table, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of prepareOrder method, of class Restaurant.
     */
    @Test
    public void testPrepareOrder2() {
        System.out.println("prepareOrder");
        String[] s = {"","a","b","c","d","","","","","","","","","","","","","","",""};
        String res = "small";
        int time = 1;
        Restaurant instance = new Restaurant();
        String expResult = "We cannot prepare order because of shortage of time";
        String result = instance.prepareOrder(s, res, time);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of serve method, of class Restaurant.
     */
    @Test
    public void testServe2() {
        System.out.println("serve");
        String[] s = {"","a","b","c","d","","","","","","","","","","","","","","",""};
        int i = 5;
        String res = "xl";
        Restaurant instance = new Restaurant();
        instance.flag=1;
        String expResult = "Error";//Because there was an error with preparation of food
        String result = instance.serve(s, i, res);
        assertEquals(expResult, result);
    }
    
}
