package net.iouhase.gilbert.model;

public class User {
    String email;
    String username;
    String password;
    String realName;
    String img;
    String role;
    int sales;
    int followers;
    int following;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSales() {
        return sales;
    }

    public boolean setSales(int sales) {
        if (sales > 0) {
            this.sales = sales;
            return true;
        }
        return false;
    }

    public int getFollowers() {
        return followers;
    }

    public boolean setFollowers(int followers) {
        if (followers > 0) {
            this.followers = followers;
            return true;
        }
        return false;
    }

    public int getFollowing() {
        return following;
    }

    public boolean setFollowing(int following) {
        if (following > 0) {
            this.following = following;
            return true;
        }
        return false;
    }
}
