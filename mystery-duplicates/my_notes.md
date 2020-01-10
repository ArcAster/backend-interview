Alex Process Notes
---

#### Step 1 ~ how is existing buggy code structured 

`static void main()`

1. init hashmap that associates `Employee` with `int` for count

2. open csv file provided via path in input arg
    * for each row of csv...
    * parse comma separated values into array of `String`
    * construct temp `Employee` instance from `String` array `elements`
    * attempt to insert into hashmap
        * `getOrDefault` so if no value set default of `0` then increment by 1
        * if some value exists take that and increment by 1
 
 3. Print results    
    * if above doesn't throw excepion...
        * print out each element in hashmap `duplicateCount`
        * break out each elem's `Employee` type into readable parts
        
&nbsp;
&nbsp;
        
#### Step 2 ~ where is the break most likely ocurring

The root of the problem seems to be how `.put` is deciding to hash the key or 
checking whether that key exists already.

Just to be sure parsing was absolutely working properly and bringing in 
duplicates consistently I temporarily added 

```
System.out.println(Arrays.toString(elements));
```

to the main function.  Everything looked fine, so that definitely wasn't the issue.

---

&nbsp;

In Java any func within another func is evaluated before the parent func so 
`.getOrDefault` shouldn't be causing issues - if anything it's a good way
to avoid an if/else block to set a default ticker.

I tried swapping out `Employee` for just `String` and avoiding duplicates on
insertion into the hashmap (which shouldn't be able to have duplicates) worked fine

Thus the issue was not really with the main function in `EmployeeProcessor.java`
but really with the type definition of Employee which `HashMap` had no clue
how to hash and therefore identify collisions against any other entries.

After adding overrides for `equals()` and `hashCode()` methods on the `Employee`
type everything seems to now be functioning properly.

---

Output now looks like this:

```aidl
STEPHANIE L NICKS: 1
JOHN Q PUBLIC: 2
LARS X ULRICH: 1
```