package com.nikotin.menueinkauf;

//DV: This is the Class which is used to map the JSON Response to an Object
//in our case we will use the Menu Object from the Menu JSON Object of the Backend
//e.g. https://ffhs-innt-my-menu.eu-gb.mybluemix.net/v1/menu/random
public class MenuNormal {
    Integer menuId;
    String name;
    String kueche;
    String art;
    String bildUrl;
    Integer anzPersonen;
    String zutaten;

    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }
    public void setName(String subject) {
        this.name = name;
    }

    public String getKueche(){return kueche;}
    public void setKueche(String project){this.kueche=kueche;}

    public String getArt(){return art;}
    public void setArt(String project){this.art=art;}

    public String getBildUrl(){return bildUrl;}
    public void setBildUrl(String project){this.bildUrl=bildUrl;}

    public Integer getAnzPersonen(){return anzPersonen;}
    public void setArt(Integer anzPersonen){this.anzPersonen=anzPersonen;}

    public String getZutaten(){return zutaten;}
    public void setZutaten(String zutaten){this.zutaten=zutaten;}


}

