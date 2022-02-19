package cards;

import User.Users;

public class Cards {
    private int id;
    private String name;
    private String description;
    private Users assignedUser;
    private AssignStatus status = AssignStatus.UNASSIGNED;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(Users assignedUser) {
        this.status = AssignStatus.ASSIGNED;
        this.assignedUser = assignedUser;
    }

    public void removeAssignedUser()
    {
        this.setAssignedUser(null);
    }
}
