# grindelfStack
This is my Kotlin implementation of stack data structure

## How it works?

## Creating an object of a Stack
Object of class "Stack" can be created using three different constructors:
1. With parameter "size": this way you create an instance of Stack of a particular length, which you pass as a parameter.
2. With parameter "collection": this way you create an instance of Stack and fill it completely with a Kotlin ArrayList you pass as a conctructor.
3. Without parameters: this way you create an instance of an empty Stack.

## Stack realization
### Properties (private)
1. stack: ArrayList<T?> - stack itself, realized as an instance of a Kotlin ArrayList.
2. size: Int - maximum capasity of this Stack (can be modified externally using "setSize" function).
3. upperIndex: Int - index of the topmost element of Stack (if it's equal to the size property it means, that the Stack is full).

### Constructors
1. With parameter "size": checks if size is positive integer (throws an exception if otherwise) and initializes properties of the class.
2. With parameter "collection": gets a Kotlin ArrayList of data, initializes properties of the class.
3. Without parameters: initializes properties of the class (size to 0 and stack to 0 size Kotlin ArrayList).
(NOTE: upperIndex property is always set to 0 value when initialized, exept for the case, when a collection of data is passed to the constructor - in this case upperIndex property is set equal to the size property.)

### Functions
1. push(element: T?) - adds an element of type of the Stack to the Stack.
2. pop(): T? - removes last added element from the Stack and returns it.
3. top(): T? - returns last added element of the Stack without removing it.
4. isEmpty(): Boolean - returns true if the upperIndex property is equal to 0, otherwise - returns false.
5. setSize(value: Int) - checks if provided parameter's value is less than value of upperIndex property and if so - throws an exception, otherwise sets size property to the parameter value.
6. map(mapper: (T?) -> T?) : Stack<T> - applies some function passed as a parameter to every element of a Stack and returns a new Stack of these updated elements.
7. override fun toString(): String - overrides standart "toString" function: returns a string of all Stack elements surrounded by "[]" and divided by comma.
8. override fun hashCode(): Int - overrides standart "hashCode" function: returns hashCode of a stack property of the Stack object.

