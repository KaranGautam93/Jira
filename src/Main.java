import User.UserStore;
import User.Users;
import board.Board;
import board.BoardStore;
import board.Privacy;
import cards.Cards;
import list.List;


public class Main {

    public static void main(String[] args) {

        BoardStore boardStore = new BoardStore();

        //create board part
        int id = boardStore.createBoard("work@tech");


        boardStore.setBoardName(id,"work.tech");

        boardStore.setPrivacy(id, Privacy.PRIVATE);

        int newBoard = boardStore.createBoard("New board V1");

        //add members to board
        Board board = boardStore.getBoard(newBoard);

        UserStore userStore = new UserStore();

        Users user1 = userStore.createUser("Karan","karan@gmail.com");
        Users user2 = userStore.createUser("Mallika","mallika@gmail.com");
        Users user3 = userStore.createUser("Nikama","Nikama@gmail.com");

        board.addMember(user1);
        board.addMember(user2);
        board.addMember(user3);

        board.removeMember(user3);

        //remove board
        boardStore.deleteBoard(id);

        //add list to board
        List list1 = board.createList("List 1");
        List list2 = board.createList("List 2");

        board.removeList(list1);

        //add cards to list

        Cards card1 = list2.addCard("Card1","this is first card in list 2");
        Cards card2 = list2.addCard("Card2","this is second card in list 2");

        //set assigned user to card
        card1.setAssignedUser(user2);
        card2.setAssignedUser(user1);

        card2.removeAssignedUser();

        System.out.println("MEMBERS OF BOARD"+" "+board.getName());
        board.printMembers();

        System.out.println("Lists OF BOARD"+" "+board.getName());
        board.printList();

        System.out.println("Cards OF List"+" "+list2.getName());
        list2.printCards();
    }
}
