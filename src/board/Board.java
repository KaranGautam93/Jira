package board;

import User.Users;

import java.util.*;

public class Board {
    private int id;
    private String name;
    private String privacy = String.valueOf(Privacy.PUBLIC);
    private String url;
    private List members;
    private List lists;

    public Board(String name) {
        members = new ArrayList<Users>();
        lists = new ArrayList<list.List>();
        this.setName(name);
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

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = String.valueOf(privacy);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int addMember(Users u)
    {
        members.add(u);
        return members.indexOf(u);
    }

    public boolean removeMember(Users u)
    {
        return members.remove(u);
    }

    public boolean removeList(list.List list)
    {
        return lists.remove(list);
    }

    public List getMembers()
    {
        return this.members;
    }

    public List getLists()
    {
        return this.lists;
    }


    public list.List createList(String name)
    {
        list.List list = new list.List();
        Random random = new Random();
        list.setId(Math.abs((int) (new Date().getTime()) + random.nextInt()));
        list.setName(name);
        lists.add(list);
        return list;
    }

    public void printMembers()
    {

        Iterator<Users> iterator = this.members.iterator();

        while (iterator.hasNext())
        {
            Users user = iterator.next();
            System.out.println("---Members---"+user.getId()+" "+user.getName()+" "+user.getEmail());
        }
    }

    public void printList()
    {
        Iterator<list.List> iterator = lists.iterator();

        while (iterator.hasNext())
        {
            list.List list = iterator.next();
            System.out.println("----------LISTS------"+list.getId()+" "+list.getName());
        }
    }
}
