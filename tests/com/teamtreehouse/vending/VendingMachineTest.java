package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine machine;

    class NotifierStub implements Notifier {

        @Override
        public void onSale(Item item) {
        }
    }

    @Before
    public void setUp() throws Exception {
        Notifier notifier = new NotifierStub();
        machine = new VendingMachine(notifier, 10, 10, 10);
        machine.restock("A1", "Twinkies", 10, 30, 75);
    }

    @Test
    public void vendingWhenWhenStokedReturnsItem() throws Exception {
        machine.addMoney(75);

        Item item = machine.vend("A1");

        assertEquals("Twinkies", item.getName());
    }

    @Test
    public void vendingIncrementsSalesTotal() throws Exception {
        machine.addMoney(75);
        machine.vend("A1");

        assertThat(machine.getRunningSalesTotal(), is(75));
    }

}