Process Notes Json-Manipulation
---

#### General Appoach:

* break down json structure into explicit java classes to make parsing / manipulating easier
* carry over existing function from mystery duplicates to find path
* keep json file loading in it's own class

&nbsp;
#### Task 1

Once I got the classes well defined enough for GSON to directly convert raw json into a custom type of
`JsonResource` (structured to be identical to the format folled by resource json files) which contains
a list of `TextArrayMembers` which are elements of the `TextArray` field.

My biggest initial hurdle was mostly remembering how to write Java correctly from four years ago.

However, that said I did complete task 1 in full and figured I'd spend the last bit of time explaining how
I'd modify this code going forward for the following tasks.

Ideally the best way to implement custom comparison for `TextArrayMember` would be to have the class
itself implement `Comparable <TextArrayMember>` with a companion custom `CompareTo` method.  However,
for now I've just left a comparator sitting in `main.java` for this.

The primary goal was to end up with the `TextArray` field as a `<List>` type so I could start to manipulate
that data simple as a list instead of some unruly Java object.  This would make Task 2 relatively straight-forward
as the lists could be merged with java builtins and then sorted as a single set  (sorting individually and then merging
wouldn't really give much of an advantage). 

* a util function could be added to aid in taking a `JsonResource` object and extracting
a `List<TextArrayMember>` from it.

---

For task 3 I'd approach this by using the Java equivalent of python's `collections.counter`.  The short
of this python builtin is that it creates a double-ended queue which can be constructed in o(n) time but
"counted" in o(1) since access after creation is o(1).

---

For task 4 I'd ideally have implemented a `exportAsJson` func and a few small helper functions that would update the 
necessary fields for the export (last-modified, uuid).  Additive merging would also be relatively straightforward as a 
hashmap of the "newer" file could be generated and the "older" file could be traversed checking against the hashmap in order
to decide what elements need to be appended to the newest copy (I also think the construction of a single `HashSet` could make sense?).