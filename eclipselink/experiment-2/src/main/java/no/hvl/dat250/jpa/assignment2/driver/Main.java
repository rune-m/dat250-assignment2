package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        // Bank
        Bank bank = new Bank();
        bank.setName("Pengebank");


        // Pincode
        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);
        em.persist(pincode);

        // Credit cards
        CreditCard card1 = new CreditCard();
        card1.setNumber(12345);
        card1.setBalance(-5000);
        card1.setLimit(-10000);
        card1.setPincode(pincode);
        card1.setOwningBank(bank);

        CreditCard card2 = new CreditCard();
        card2.setNumber(123);
        card2.setBalance(1);
        card2.setLimit(2000);
        card2.setPincode(pincode);
        card2.setOwningBank(bank);

        Set<CreditCard> cards = new HashSet<>();
        cards.add(card1);
        cards.add(card2);
        bank.setCreditCards(cards);
        em.persist(bank);
        em.persist(card1);
        em.persist(card2);

        // Address
        Address address = new Address("Inndalsveien", 28);

        // Person
        Person person = new Person();
        person.setName("Max Mustermann");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        person.setAddresses(addressSet);
        Set<CreditCard> creditCardSet = new HashSet<>();
        creditCardSet.add(card1);
        creditCardSet.add(card2);
        person.setCreditCards(creditCardSet);

        // Persist person and address
        Set<Person> people = new HashSet<>();
        people.add(person);
        address.setOwners(people);

        em.persist(address);
        em.persist(person);

        em.getTransaction().commit();
    }
}
