public class SelectionSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile(2,2);
  
    // ***********************************************************
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
    // ***********************************************************

    // return the sorted result here
    return sorted;
  }
}


// Until unsorted is empty:
// Scan unsorted for the smallest remaining element.
// Remove that element from unsorted and add it to the tail of sorted.
// One way to do this: Loop through all the nodes, keeping the index of the smallest element seen so far as you continue to scan through the list, then remove that element by index.

// Another way: avoid using an index by actually pulling out the smallest element seen so far, and then swapping it back in if and when you encounter a smaller one.

// Yet another: use two iterators, one to traverse the loop element by element and the other to hold the place of the smallest element seen so far, so you get a stable sort.