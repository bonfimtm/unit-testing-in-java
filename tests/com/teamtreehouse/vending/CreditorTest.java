package com.teamtreehouse.vending;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditorTest {

    private Creditor creditor;

    @Before
    public void setUp() {
        creditor = new Creditor();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addingFundsIncrementsAvailableFunds() throws Exception {
        creditor.addFunds(25);
        creditor.addFunds(25);

        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    public void refundReturnsAllAvailableFunds() throws Exception {
        creditor.addFunds(10);

        assertEquals(10, creditor.refund());
        assertEquals(0, creditor.getAvailableFunds());
    }

    @Test
    public void refundingResetsAvailableFundsToZero() throws Exception {
        creditor.addFunds(10);

        creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());
    }

    @Test(expected = NotEnoughFundsException.class)
    public void deductingAmountHigherThanBalanceIsNotAllowed() throws Exception {
        creditor.deduct(1);
    }

}