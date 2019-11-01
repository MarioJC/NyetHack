package com.edmarsoft.nyethack;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Jhava {

    private String greeting = "BLARGH";
    private int hitPoints = 52489112;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @NotNull
    public String utterGreeting() {
        return greeting;
    }

    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }

    public void offerFood() {
        Hero.handOverFood("pizza");
    }

    public static void main(String[] args) {
        // calling Kotlin's top-level function as a static method call
        System.out.println(Hero.makeProclamation());

        System.out.println("Spells:");
        Spellbook spellbook = new Spellbook();
        for (String spell: spellbook.spells) {
            System.out.println(spell);
        }

        System.out.println("Max spell count: " + Spellbook.MAX_SPELL_COUNT);

        Spellbook.getSpellbookGreeting();
    }
}