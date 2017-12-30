# Design pattern

Copy from [wiki](https://en.wikipedia.org/wiki/Software_design_pattern#Structural_patterns)(2016-11-18 20:27:53)

## Creational patterns

|Name|Description|In Design Patterns|In Code Complete|	Other|
|:-- |:----------|:-----------------|:---------------|:------|
|Multiton|Ensure a class has only named instances, and provide a global point of access to them.|No|No|N/A|
|Object pool|Avoid expensive acquisition and release of resources by recycling objects that are no longer in use. Can be considered a generalisation of connection pool and thread pool patterns.|No|No|N/A|
|Resource|acquisition is initialization	Ensure that resources are properly released by tying them to the lifespan of suitable objects.|No|No|N/A|

## Structural patterns
|Name|Description|In Design Patterns|In Code Complete|Other|
|:-- |:----------|:-----------------|:---------------|:----|
|Extension object|Adding functionality to a hierarchy without changing the hierarchy.|No|No|Agile Software Development, Principles, Patterns, and Practices|
|Front controller|The pattern relates to the design of Web applications. It provides a centralized entry point for handling requests.|No|Yes|N/A|
|Marker|Empty interface to associate metadata with a class.|No|No|Effective Java|
|Module|Group several related elements, such as classes, singletons, methods, globally used, into a single conceptual entity.|No|No|N/A|
|Twin|Twin allows modeling of multiple inheritance in programming languages that do not support this feature.|No|No|N/A|



## Behavioral patterns
|Name|Description|In Design Patterns|In Code Complete|Other|
|:-- |:----------|:-----------------|:---------------|:----|
|Blackboard|Artificial intelligence pattern for combining disparate sources of data (see blackboard system)|No|No|N/A
|Chain of responsibility|Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.|Yes|No|N/A|
|Interpreter|Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.|Yes|No|N/A|
|Memento|Without violating encapsulation, capture and externalize an object's internal state allowing the object to be restored to this state later.|Yes|No|N/A|
|Null object|Avoid null references by providing a default object.|No|No|N/A|
|Observer or Publish/subscribe|Define a one-to-many dependency between objects where a state change in one object results in all its dependents being notified and updated automatically.|Yes|Yes|N/A|
|Servant|Define common functionality for a group of classes.|No|No|N/A|
|Specification|Recombinable business logic in a Boolean fashion.|No|No|N/A|
|Strategy|Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.|Yes|Yes|N/A|
|Template method|Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.|Yes|Yes|N/A|

## Concurrency patterns
|Name|Description|In Design Patterns|In POSA2|
|:-- |:----------|:-----------------|:-------|
|Active Object|Decouples method execution from method invocation that reside in their own thread of control. The goal is to introduce concurrency, by using asynchronous method invocation and a scheduler for handling requests.|Yes|N/A
|Balking|Only execute an action on an object when the object is in a particular state.|No|N/A|
|Binding properties|Combining multiple observers to force properties in different objects to be synchronized or coordinated in some way.|No|N/A|
|Blockchain|Decentralized way to store data and agree on ways of processing it in a Merkle tree, optionally using Digital signature for any individual contributions.|No|N/A|
|Double-checked locking|Reduce the overhead of acquiring a lock by first testing the locking criterion (the 'lock hint') in an unsafe manner; only if that succeeds does the actual locking logic proceed. Can be unsafe when implemented in some language/hardware combinations. It can therefore sometimes be considered an anti-pattern.|Yes|N/A|
|Event-based asynchronous|Addresses problems with the asynchronous pattern that occur in multithreaded programs.|No|N/A|
|Guarded suspension|Manages operations that require both a lock to be acquired and a precondition to be satisfied before the operation can be executed.|No|N/A|
|Join|Join-pattern provides a way to write concurrent, parallel and distributed programs by message passing. Compared to the use of threads and locks, this is a high-level programming model.|No|N/A|
|Lock|One thread puts a "lock" on a resource, preventing other threads from accessing or modifying it.|No|PoEAA|
|Messaging design pattern (MDP)|Allows the interchange of information (i.e. messages) between components and applications.|No|N/A|
|Monitor object|An object whose methods are subject to mutual exclusion, thus preventing multiple objects from erroneously trying to use it at the same time.|Yes|N/A|
|Reactor|A reactor object provides an asynchronous interface to resources that must be handled synchronously.|Yes|N/A|
|Read-write lock|Allows concurrent read access to an object, but requires exclusive access for write operations.|No|N/A|
|Scheduler|Explicitly control when threads may execute single-threaded code.|No|N/A|
|Thread pool|A number of threads are created to perform a number of tasks, which are usually organized in a queue. Typically, there are many more tasks than threads. Can be considered a special case of the object pool pattern.|No|N/A|
|Thread-specific storage|Static or "global" memory local to a thread.|Yes|N/A|