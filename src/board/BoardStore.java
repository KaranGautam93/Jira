package board;

import User.Users;

import java.util.*;

public class BoardStore {
    private Map boards;

    public BoardStore() {
        boards = new HashMap<Integer, Board>();
    }


    public void add(Board board) {
        boards.put(board.getId(), board);
    }

    public Board getBoard(int id) {
        return (Board) boards.get(id);
    }

    public int createBoard(String name) {
        Board board = new Board(name);
        Date date = new Date();
        Random rand = new Random();
        board.setId(Math.abs((int)date.getTime()) + rand.nextInt());
        add(board);
        return board.getId();
    }

    public void showAll() {
        if (this.boards.size() == 0) {
            System.out.println("No boards available");
        } else {
            Iterator<Map.Entry<Integer, Board>> iterator = boards.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Board> entry = iterator.next();
                Board board = entry.getValue();
                System.out.println(board.getId() + " " + board.getName() + " " + board.getPrivacy());
            }
        }
    }

    public void show(int id)
    {
        Board board = (Board) boards.get(id);
        if(board == null)
        {
            System.out.println("Not found");
        }
        else
        {
            System.out.println(board.getId() + " " + board.getName() + " " + board.getPrivacy());
        }
    }

    public void setBoardName(int id,String name)
    {
        Board board = getBoard(id);
        board.setName(name);
        boards.put(id,board);
    }

    public void setPrivacy(int id,Privacy privacy)
    {
        Board board = getBoard(id);
        board.setPrivacy(privacy);
        boards.put(id,board);
    }


    public void deleteBoard(int id)
    {
        boards.remove(id);
        return;
    }
}
