
import java.util.ArrayDeque;

public class MergeSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();

    record.add(unsorted);

    //make a unique card pile for each card
    for(Card myCard : unsorted){
      CardPile singleton  = new CardPile(2, 2);
      singleton.add(myCard);
      queue.addLast(singleton);
    }
    
    while(queue.size() > 1){
      //pull last two card piles off queue
      CardPile one = queue.poll();
      CardPile two = queue.poll();

      //make a pile "mergedPile" to store sorted cards
      CardPile mergedPile = new CardPile(2, 2);
  
      while(!one.isEmpty() && !two.isEmpty()){ //until we empty one of the piles

        //get the first card off each pile
        Card c1 = one.getFirst();
        Card c2 = two.getFirst();
        if(c1.compareTo(c2) < 0){ //c1 is smaller
          mergedPile.addLast(c1);
          one.removeFirst();
        }
        else{ //card 2 is smaller
          mergedPile.addLast(c2);
          two.removeFirst();
        }
      }
      //queue.addLast(mergedPile);
      if(one.isEmpty()){
        mergedPile.append(two);
      }
      else if(two.isEmpty()){
        mergedPile.append(one);

      }
      queue.addLast(mergedPile);
      for(Card card : mergedPile){
        unsorted.remove(card);
      }

    //not the right position? look at given code below? 
    record.next();         // tell it this is a new step
    for (CardPile pile: queue) { // add all piles
               record.add(pile);
            }
    record.add(unsorted);

  
   //***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************

    // return the sorted result here
    //return queue.remove();
    }
    return queue.remove(); //the final sorted result
  }
}

