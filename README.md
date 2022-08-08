

 I envesioned appaching the second task in the following ways:

 - Using polymorphism (poly mean *many* and morphism  means *form*.). So it means the ability of an object to take in in many different forms.
  
   - That means that we will have a method by the name analyser which will be implemented differently depending on the type of comments class we have.
     - I noticed that this method is the same in all type of comments classes(Comments,Spam, questions, etc). The aim here is to analyse comments right so polymorphism that take form in this case. Difinatly my first approach to try making the program more maintainable and  accessible in the future.
     - ok let's try out polymorphism
     -  A main class talks with commentAnalyzer class, which is the base for other classes
     -  in commentAnalyzer class we have an abstract class call  analyse
     -  The analyse method is implemented in child classes(Comments, Spam, Qustions)
     -  I belive this technique will take away the agry many if statement ub the future
     -  any other type of comment will just call the method analyse on its implementation
     - See the UML digraph for more information about polymorphism implementation.
        
  - Programming to an interface
     - This can be the easiest way too. We can have each type of comment being a class(comments, Spam, Questions). CommentAnalyser will be the interface for all types of class comments. So that means each class comment will implement the interface according to its behavior method.
     - But I feel like this is still not object orriented enough beacuse we will need to have many different methods and implenations for each class comment.
     - Keeping in mind that the goal  here is to analyse comments so having just one obstract method with the name analyser would perform better.This makes me favor polymorphisms over programing to an interface.
  
  

-Another idea in mind is to use the command pattern.
   