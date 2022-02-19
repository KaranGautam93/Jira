package list;

import User.Users;
import cards.AssignStatus;
import cards.Cards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class List {
    private int id;
    private String name;
    private java.util.List cards;
    private Users assignedUser;

    public List() {
        cards = new ArrayList<Cards>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.List getCards() {
        return cards;
    }

    public Cards addCard(String name, String description) {
        Cards card = new Cards();
        Random rand = new Random();
        int id = rand.nextInt();
        card.setId(id);
        card.setName(name);
        card.setDescription(description);
        cards.add(card);
        return card;
    }

    public void printCards()
    {
        Iterator<Cards> iterator = cards.iterator();

        while (iterator.hasNext())
        {
            Cards card = iterator.next();

            String assignedUserStatus = String.valueOf(AssignStatus.UNASSIGNED);

            if(card.getAssignedUser() != null)
            {
                assignedUserStatus = String.valueOf(AssignStatus.ASSIGNED)+" to "+card.getAssignedUser().getName();
            }

            System.out.println("---------------------Cards-----------"+card.getId()+" "+card.getName()+" "+card.getDescription()+" "+assignedUserStatus);
        }
    }
}
