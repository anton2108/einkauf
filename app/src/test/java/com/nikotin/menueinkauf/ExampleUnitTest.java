package com.nikotin.menueinkauf;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}
public class TestMenuNormal(){
    @Test
 public void testGetName(){
	assertThat("", is(sameInstance( "" )));
	assertThat(new Object(), is(notNullValue()));
	}
	public void TestgetMenuId(){
	assertEquals(2, menuId.getMenuId());
	assertTrue(menuId.getMenuId() > 0)
	}
}
