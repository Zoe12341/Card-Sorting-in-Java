public class Quicksort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    System.out.println("here we go again");

    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    
    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile(2,2);
    CardPile bigger = new CardPile(2,2);

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    System.out.println("Unsorted nothing removed: " + unsorted);
    Card pivot = unsorted.removeFirst();
    System.out.println("pivot: " + pivot);
    System.out.println("unsorted post: " + unsorted);
    //Card pivot = unsorted.getFirst();  // edit this!
    //unsorted.removeFirst();

    
    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile(2,2);
    
    // ***********************************************************
    //System.out.println(unsorted.size());
    if(unsorted.size() > 1){
      //pivot = unsorted.removeFirst();
      for(Card c1 : unsorted){
        //get the first card off each pile
        //Card c1 = unsorted.getFirst();
        //unsorted.removeFirst();
        //Card c2 = two.getFirst();
        if(c1.compareTo(pivot) < 0){ //c1 is smaller
          smaller.addLast(c1);
        }
        else if(c1.compareTo(pivot) > 0){ //pivot is smaller
          bigger.addLast(c1);
        }
      }
      System.out.println("smaller: " + smaller);
      System.out.println("bigger: " + bigger);
      if(!smaller.isEmpty()){
        smaller = sort(smaller, record);
      }

      if(!bigger.isEmpty()){
        bigger = sort(bigger, record);
      }

      //sort(bigger, record);
    }
    

    //CardPile sorted = new CardPile(2,2);
    result.append(smaller);
    result.addLast(pivot);
    result.append(bigger);
    //return sorted;
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************

    // record the sorted result
    record.add(result);
    record.next();
    
    // return the sorted result here
    return result;
  }
}
