import java.util.*;

class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        // If total cards cannot be divided into equal groups
        if(hand.length % groupSize != 0){
            return false;
        }

        // TreeMap keeps keys sorted automatically
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Count frequency of each card
        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Process cards starting from the smallest
        while(!map.isEmpty()){

            // Get the smallest available card
            int firstCard = map.firstKey();

            // Try to create a consecutive group
            for(int i = 0; i < groupSize; i++){

                int currentCard = firstCard + i;

                // If the required card is missing, grouping not possible
                if(!map.containsKey(currentCard)){
                    return false;
                }

                // Reduce frequency
                map.put(currentCard, map.get(currentCard) - 1);

                // Remove card if frequency becomes zero
                if(map.get(currentCard) == 0){
                    map.remove(currentCard);
                }
            }
        }

        // If all cards are grouped successfully
        return true;
    }
}