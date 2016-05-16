package com.pilotcraftsystems.games;

import android.util.Log;

/**
 * FindTheBeet
 *
 * Class implements the logic for the Find The Beet game. Works in conjunction with the
 * {@code FindTheBeetActivity} class.
 *
 * @Author Damian Ugalde, Chris Minnig, Dutch Clark, and Kristopher Rollert
 * @date 2016-05-10
 */
public class FindTheBeet {

    public static final String TAG = "FindTheBeet";
    private int beetToFind;

    public static final int BASE_HR = 80;
    public static final int HR_RANDOMNESS = 20;

    /**
     * Creates a new Find The Beet game, assigning a new beet to be found.
     */
    public FindTheBeet(){
        beetToFind = 70;//(int) (Math.random() * HR_RANDOMNESS + BASE_HR);
    }

    /**
     * Updates the logic of the game for the next screen render.
     * @param heartRate the current heart rate
     * @return A String with the red and blue RGB values for the background, separated by a '-'.
     */
    public String update(int heartRate){
        return updateRGB(heartRate, 60, 120, beetToFind);

    }

    public int getBeetToFind() {
        return beetToFind;
    }

    public void newBeet(){

    }


    /**
     * Updates the color of the background based on the current heart rate.
     * @param heartBeet Current user heart rate.
     * @param min Minimum value for the heart rate.
     * @param max Maximum value for the heart rate.
     * @param target Target to be found by the user by matching its heart rate.
     * @return
     */
    public static String updateRGB(int heartBeet,int min, int max, int target){
        double range;
        int red=255;
        int blue=255;
        heartBeet= THE_CLAMPS(heartBeet,min,max);
        //if the beat hits the target
        if(heartBeet==target){
            //max red and blue
            red=255;
            blue=255;
            Log.i(TAG,"The red value is: "+red+", The blue value is: "+blue);
            return red + "-" + blue;
        }
        //if the beat is below the target...
        else if(heartBeet<target){
            range=target-min;
            //remove some red
            red= (int)(((heartBeet-min)/range)*255);
            blue=255;
            Log.i(TAG,"The red value is: "+red+", The blue value is: "+blue);
            return red + "-" + blue;
        }
        //if the beat is above the target...
        else{
            range=max-target;
            red=255;
            //remove some blue
            blue=(int)(((range-(heartBeet-target))/range)*255);
            Log.i(TAG,"The red value is: "+red+", The blue value is: "+blue);
            return red + "-" + blue;

        }
    }


    /**Francis X. Clampazzo, better known as Clamps, is one of the recurring antagonists in
     * Futurama. He is robot who is a part of the Robot Mafia and works for Donbot.

     Clamps is a bronze colored Robot, with a slender body and small door on his torso. He has a
     row of rivets on the right side of his face, appearing like a scar or stitches. Clamps'
     personality is paranoid, sarcastic, and highly aggressive, reflecting that of Joe Pesci's
     character Tommy DeVito in the film Goodfellas, as well as his high pitch, high tempo voice.

     Clamps loves to use his own clamps at "every opportunity" but his clamps are often unnecessary
     in any given situation. In spite of his love for his clamps, in Bender Gets Made, when they
     are needed, he is antagonized by Joey Mousepad when Joey suggests Clamps actually uses them.
     In The Silence Of The Clamps, he starts to work in Planet Express after Bender is forced to
     go into the witness protection program. Clamps may have been a high ranked member or favoured
     by the Donbot given that in Bender Gets Made Donbot suggested giving Bender a pair of clamps
     causing Clamps to mumble angrily

     The crew starts to trust him completely except Zoidberg, who thinks that he will also be
     replaced by Francis due to the fact that Francis can cut and clamp while Zoidberg can only
     cut. Francis goes into the moon's western border and finds Bender, who is actually Billy West.
     Francis tries to murder Billy but Zoidberg prevents him from doing so and they fight. Francis
     tries to kill Zoidberg by crushing his skull but Zoidberg gains the upper hand and defeats
     Francis by cutting off his clamps. Voiced by Maurice LaMarche.

      @param value Value to be CLAMPED
      @param min minimum value for the CLAMP
      @param max maximum value for the CLAMP
      @return the value inside the boundaries of the CLAMP
     */
    public static int THE_CLAMPS(int value, int min, int max){

         if(value>max){
            return max;
        }
        else if(value<min){
            return min;
        }
        else{
            return value;
        }
    }

}
