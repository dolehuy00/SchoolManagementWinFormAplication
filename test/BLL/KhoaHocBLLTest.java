/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BLL;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class KhoaHocBLLTest {
    
    public KhoaHocBLLTest() {
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

    @Test
    public void testGetDepartmentID() {
        System.out.println("getDepartmentID");
        String name = "English";
        KhoaHocBLL instance = new KhoaHocBLL();
        String expResult = "2";
        String result = instance.getDepartmentID(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchCourse() {
        System.out.println("searchCourse");
        String keyword = "";
        KhoaHocBLL instance = new KhoaHocBLL();
        ArrayList expResult = null;
        ArrayList result = instance.searchCourse(keyword);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    
}
