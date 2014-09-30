package models;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {

    @Before
    public play.test.FakeApplication provideFakeApplication() {
	return fakeApplication(inMemoryDatabase());
    }

   @Test
    public void tryAuthenticateUser(){
	//new User("alex@test.com", "Alex", "secret", "78987877", "fb.com", "1 north ave, CA").save();
	
	assertNotNull(User.authenticate("alex@test.com", "secret"));
	assertNull(User.authenticate("north@at.yn", "north"));
	assertNull(User.authenticate("alex@test.com", "sekret"));
    }
}
