package com.example.srihari.pinkbunny;

/**
 * Created by srihari on 20/10/17.
 */

public class ObjectiveNames {
    static String[] obejctiveName={"Make one new friend", "Watch 5 comedy movies in a  week ",
            "Tweet or post on FaceBook-'#IamAFurryBunny","Post 2 memes on any social network", "Write 5 jokes in a notebook","Go to your favourite restraunt with your friend",
            "Write your best trait on a Peice of paper","Feed a stray animal","Learn something new",
            "Dance to a song","Play a sport","Write a poem/song (happy ones)","Go shopping with a friend"};
    public static String AllNames(int listNum){
        return obejctiveName[listNum-1];
    }
}
