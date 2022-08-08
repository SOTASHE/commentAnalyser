

Please *note* that there are two branches in this repo, *main* and *master*. <strong>Master *has my latest version code*</strong>

# My Approach
 ### So I envisioned approaching the task in the following ways:

 - ### polymorphism
  
   -   Using polymorphism (poly means *many* and morphism means *form*.). So it means the ability of an object to take many different forms.
  
   - That means that we will have a method by the name analyze which will be implemented differently depending on the type of comments class we have.
     - I noticed that this method is the same in all types of comments classes( <strong>Comments</strong>, <strong>Spam</strong>,  <strong>Questions</strong>). The aim here is to analyze comments right so polymorphism takes form in this case. My first approach is to try to make the program more maintainable and accessible in the future.
     - ok let's try out polymorphism
     - The main/ App class talks with CommentAnalyzer class, which is the base for other classes
     -  in commentAnalyzer class, we have an abstract class called analyze
     -  The analyze method is implemented in child classes(Comments, Spam, Questions)
     -  I believe this technique will take away the burden of if statement in the future
     -  any other type of comment will just call the method analyze on its implementation
     - See the UML digraph for more information about polymorphism implementation: <br /> <br/> 


       ![alt text](UML.png)
        
- ## Programming to an interface
     - This can be the easiest way too. We can have each type of comment being a class( comments, Spam, Questions). CommentAnalyser will be the interface for all types of class comments. So that means each class comment will implement the interface according to its behavior method.
     - But I feel like this is still not object-oriented enough because we will need to have many different methods and implementations for each class comment.
     - Keeping in mind that the goal here is to analyze comments so having just one abstract method with the name analyze would perform better. This makes me favor polymorphisms over programming to an interface. <br/> <br/> 

         ```java

         //make an interface with a method to be implemented by child classes
        public interface CommentAnalyser {
        //make it a method commet analyzer of tabe of Map<String,Integer>
        public Map<String, Integer> AnalyzeComments(String fileName);

         }



        //classes to implement interface
       public class AnalyserQuestions implements CommentAnalyser {
       @Override
       public Map<String, Integer> AnalyzeComments(String fileName) {
            // TODO Auto-generated method stub
          return null;
         }
    
         }
    
        

        public class AnalyserSpam implements CommentAnalyser {
    
        @Override
       public Map<String, Integer> AnalyzeComments(String fileName) {
        // TODO Auto-generated method stub
        return null;
        }
        }
    
             


       public class AnalyserComment implements CommentAnalyser {

         @Override
       public Map<String, Integer> AnalyzeComments(String fileName) {
        // TODO Auto-generated method stub
        return null;
        }
    
       }


       ```
- ## Command pattern
  -  Seems like  polymorphism worked out good but I still see some redundant code here
  -  It is worth considering using the Command pattern
  -  I will give it a shot.