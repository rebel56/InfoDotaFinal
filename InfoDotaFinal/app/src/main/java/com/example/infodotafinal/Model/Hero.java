package com.example.infodotafinal.Model;

public class Hero {
    private String title_hero;
    private String image_hero;
    private String desc_hero;
    private String HeroId;


    public Hero(String title_hero, String image_hero, String desc_hero, String HeroId) {
        this.title_hero = title_hero;
        this.image_hero = image_hero;
        this.desc_hero = desc_hero;
        this.HeroId = HeroId;
    }

    public String getTitle_hero() {
        return title_hero;
    }

    public void setTitle_hero(String title_hero) {
        this.title_hero = title_hero;
    }

    public String getImage_hero() {
        return image_hero;
    }

    public void setImage_hero(String image_hero) {
        this.image_hero = image_hero;
    }

    public String getDesc_hero() {
        return desc_hero;
    }

    public void setDesc_hero(String desc_hero) {
        this.desc_hero = desc_hero;
    }

    public String getHeroId() {
        return HeroId;
    }

    public void setHeroId(String heroId) {
        HeroId = heroId;
    }

    public Hero()
    {

    }

}
